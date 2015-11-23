/*
* ControladorArtista
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;

public class ControladorArtista {
	private IRepositorioArtista repositorioArtista;

	public ControladorArtista() throws ClassNotFoundException, IOException {
		this.repositorioArtista = new RepositorioArtistaBDR();
	}

	public void cadastrar(Artista artista) throws ArtistaJaCadastradoException, SQLException, IOException {
		this.repositorioArtista.cadastrar(artista);
	}

	public void atualizar(Artista artista) throws ArtistaNaoEncontradoExecption, SQLException, ArtistaJaCadastradoException, IOException {
		repositorioArtista.atualizar(artista);

		/*
		 * Validações da Classe Artista if
		 * (!ValidarCPF.validaCPF(artista.getCpf())) System.out.println(
		 * "CPF Inválido."); else if (artista.getNome() == "")
		 * System.out.println("Nome é nulo ou Inválido."); else {
		 * this.repositorioArtista.atualizar(artista);
		 */

	}

	public void remover(String cpf) throws ArtistaNaoEncontradoExecption, SQLException, IOException {
		repositorioArtista.remover(cpf);

		/*
		 * boolean retorno = false; // Limpando a formatação do CPF; cpf =
		 * cpf.replaceAll("\\.|\\-|\\ ", ""); // Validações da Classe Artista if
		 * (!ValidarCPF.validaCPF(cpf)) System.out.println(
		 * "CPF Inválido ou Nome esta em branco."); else { retorno =
		 * this.repositorioArtista.remover(cpf); } return retorno;
		 */

	}

	public boolean existe(String cpf) throws SQLException, IOException {
		return repositorioArtista.existe(cpf);
	}

	public Artista procurar(String cpf) throws ArtistaNaoEncontradoExecption, SQLException, ArtistaJaCadastradoException, IOException {
		return repositorioArtista.procurar(cpf);

		/*
		 * Artista artista = null; // Limpando a formatação do CPF; cpf =
		 * cpf.replaceAll("\\.|\\-|\\ ", ""); // Validações da Classe Artista if
		 * (!ValidarCPF.validaCPF(cpf)) System.out.println("CPF Inválido"); else
		 * { artista = this.repositorioArtista.procurar(cpf); } return artista;
		 * }
		 */

	}

	public ArrayList<Artista> listar() throws SQLException, IOException {
		return this.repositorioArtista.listar();
	}
}
