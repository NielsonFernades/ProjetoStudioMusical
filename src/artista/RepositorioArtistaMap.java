/*
* RepositórioArtistaMap
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import java.util.HashMap;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public class RepositorioArtistaMap implements IRepositorioArtista {

	HashMap<Integer, Artista> arrayArtistaMap;
	Integer indice;

	public RepositorioArtistaMap() {
		arrayArtistaMap = new HashMap<Integer, Artista>();
		indice = 1;

	}

	@Override
	public void cadastrar(Artista artista) throws ArtistaJaCadastradoException, SQLException, IOException {

		if (existe(artista.getCpf()))
			throw new ArtistaJaCadastradoException();

		artista.setID_Artista(indice);
		arrayArtistaMap.put(indice, artista);
		indice++;
		System.out.println("Artista Cadastrado");
		JOptionPane.showMessageDialog(null, "Artista Cadastrado!");

	}

	@Override
	public void atualizar(Artista artista) throws ArtistaNaoEncontradoExecption, SQLException {
		Integer a = artista.getID_Artista();
		arrayArtistaMap.put(a, artista);
		JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

	}

	@Override
	public void remover(String cpf) throws ArtistaNaoEncontradoExecption, SQLException {

		for (int i = 1; i < indice; i++) {
			Artista artista = arrayArtistaMap.get(i);
			if (cpf.equals(artista.getCpf())) {
				arrayArtistaMap.remove(artista);
				JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			}
		}

	}

	@Override
	public Artista procurar(String cpf) throws ArtistaNaoEncontradoExecption, SQLException {
		for (int i = 1; i < indice; i++) {
			Artista artista = arrayArtistaMap.get(i);
			if (cpf.equals(artista.getCpf())) {
				return artista;

			}
		}
		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		for (int i = 1; i < indice; i++) {
			Artista artista = arrayArtistaMap.get(i);
			if (cpf.equals(artista.getCpf())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<Artista> listar() throws SQLException, IOException {
		ArrayList<Artista> arrayListLocal = new ArrayList<Artista>();
		for (int i = 1; i < indice; i++) {
			Artista artista = arrayArtistaMap.get(i);
			arrayListLocal.add(artista);

		}

		return null;
	}

}
