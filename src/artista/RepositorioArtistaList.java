/*
* RepositórioArtistaList
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public class RepositorioArtistaList implements IRepositorioArtista {

	ArrayList<Artista> arrayListArtista;
	int indice;

	public RepositorioArtistaList() {
		arrayListArtista = new ArrayList<Artista>();
		indice = 1;
	}

	@Override
	public void cadastrar(Artista artista) throws ArtistaJaCadastradoException { // Método cadastrar
		if (existe(artista.getCpf())) // Se já existir
			throw new ArtistaJaCadastradoException();
		artista.setID_Artista(indice);
		arrayListArtista.add(artista);
		indice++;
		System.out.println("Artista Cadastrado!");
		JOptionPane.showMessageDialog(null, "Artista Cadastrado!");
		// artista.setID_Artista(10);

	}

	@Override
	public void atualizar(Artista artista) throws ArtistaNaoEncontradoExecption {
		int i = artista.getID_Artista();
		for (Artista artistas : arrayListArtista) {
				if (i == artistas.getID_Artista()) {
					arrayListArtista.remove(artistas);
					arrayListArtista.add(artista);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
				}
			}
			
		}

	@Override
	public void remover(String cpf) throws ArtistaNaoEncontradoExecption {
		for (Artista artista : arrayListArtista) {
			if (artista.getCpf().equals(cpf)) {
				arrayListArtista.remove(artista);
				System.out.println("Artista removido!");
				JOptionPane.showMessageDialog(null, "Artista removido!");
			}
		}

		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public Artista procurar(String cpf) throws ArtistaNaoEncontradoExecption {
		for (Artista artista : arrayListArtista) {
			if (cpf.equals(artista.getCpf())) {
				return artista;
			}
		}

		throw new ArtistaNaoEncontradoExecption();
	}

	@Override
	public boolean existe(String cpf) { // Metodo de retorno para verificar o cpf
		for (Artista artista : arrayListArtista) {
			if (cpf.equals(artista.getCpf())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Artista> listar() {
		return arrayListArtista;
	}

}
