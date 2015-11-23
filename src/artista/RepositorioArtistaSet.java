/*
* RepositórioArtistaSet
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public class RepositorioArtistaSet implements IRepositorioArtista {

	HashSet<Artista> arrayArtistaset;
	int indice;

	public RepositorioArtistaSet() {
		arrayArtistaset = new HashSet<Artista>();
		indice = 1;
	}

	@Override
	public void cadastrar(Artista artista) throws ArtistaJaCadastradoException, SQLException, IOException {
		if (existe(artista.getCpf()))
			throw new ArtistaJaCadastradoException();
		artista.setID_Artista(indice);
		arrayArtistaset.add(artista);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

	}

	@Override
	public void atualizar(Artista artista) throws ArtistaNaoEncontradoExecption, SQLException {
		int i = artista.getID_Artista();
		for (Artista artistas : arrayArtistaset) {
			if (i == artistas.getID_Artista()) {
				arrayArtistaset.remove(artistas);

			}

		}
		arrayArtistaset.add(artista);
		JOptionPane.showInternalMessageDialog(null, "Artista Atualizado!");

	}

	@Override
	public void remover(String cpf) throws ArtistaNaoEncontradoExecption, SQLException {
		for (Artista artista : arrayArtistaset) {
			if (artista.getClass().equals(cpf)) {
				arrayArtistaset.remove(artista);
				JOptionPane.showMessageDialog(null, "Removido com Sucesso!");
			}
		}
		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public Artista procurar(String cpf) throws ArtistaNaoEncontradoExecption, SQLException {
		for (Artista artista : arrayArtistaset) {
			if (cpf.equals(artista.getCpf())) {
				JOptionPane.showMessageDialog(null, "Encontrado!");
				return artista;
			}
		}

		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		for (Artista artista : arrayArtistaset) {
			if (cpf.equals(artista.formatarCpf())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Artista> listar() throws SQLException, IOException {
		ArrayList<Artista> array = new ArrayList<Artista>();
		for (Artista artista : array) {
			array.add(artista);
		}
		return array;
	}

}
