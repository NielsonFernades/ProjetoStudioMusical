/*
* ControladorEqualizador
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package equalizador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.EqualizadorNaoEncontradoException;
import excecoesEqualizadores.NomeVazioException;

public class ControladorEqualizador {

	private IRepositorioEqualizador repositorioEqualizador;

	public ControladorEqualizador() throws ClassNotFoundException, IOException {
		repositorioEqualizador = new RepositorioEqualizadorBDR();

	}

	public void cadastrar(Equalizador equalizador) throws NomeVazioException, EqualizadorJaCadastradoException,
			SQLException, IOException, NomeVazioException {
		repositorioEqualizador.cadastrar(equalizador);
	}

	/*
	 * public void atualizar(Equalizador artista) { // Validações da Classe
	 * Artista if (!ValidarCPF.validaCPF(artista.getCpf())) System.out.println(
	 * "CPF Inválido."); else if (artista.getNome() == "") System.out.println(
	 * "Nome é nulo ou Inválido."); else {
	 * this.repositorioArtista.atualizar(artista); } }
	 */

	public void atualizar(Equalizador equalizador) throws EqualizadorNaoEncontradoException, SQLException, IOException {
		repositorioEqualizador.atualizar(equalizador);

	}

	public void remover(String idEqualizador)
			throws EqualizadorJaCadastradoException, SQLException, IOException, EqualizadorNaoEncontradoException {
		repositorioEqualizador.remover(idEqualizador);
		/*
		 * boolean retorno = false; // Limpando a formatação do CPF; cpf =
		 * cpf.replaceAll("\\.|\\-|\\ ", ""); // Validações da Classe Cliente if
		 * (!ValidarCPF.validaCPF(cpf)) System.out.println(
		 * "CPF Inválido ou Nome esta em branco."); else { retorno =
		 * this.repositorioArtista.remover(cpf); } return retorno;
		 */
	}

	public Equalizador procurar(String idEqualizador)
			throws EqualizadorNaoEncontradoException, SQLException, IOException {
		return repositorioEqualizador.procurar(idEqualizador);

		/*
		 * Equalizador cliente = null; / Limpando a formatação do CPF; cpf =
		 * cpf.replaceAll("\\.|\\-|\\ ", ""); // Validações da Classe Cliente if
		 * (!ValidarCPF.validaCPF(cpf)) System.out.println("CPF Inválido"); else
		 * { cliente = this.repositorioArtista.procurar(cpf); } return cliente;
		 */
	}

	public Boolean existi(String idEqualizador) {
		return repositorioEqualizador.existe(idEqualizador);
	}

	public ArrayList<Equalizador> listar() throws SQLException, IOException {
		return this.repositorioEqualizador.listar();
	}
}
