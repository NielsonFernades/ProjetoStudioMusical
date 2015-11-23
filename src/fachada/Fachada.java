/*
* Fachada.java
* Versão: 1.0
* Data de Criação : 19/10/2015
*/

package fachada;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import artista.Artista;
import artista.ControladorArtista;
import endereco.ControladorEndereco;
import endereco.Endereco;
import equalizador.ControladorEqualizador;
import equalizador.Equalizador;
import excecoesArtistas.ArtistaJaCadastradoException;
import excecoesArtistas.ArtistaNaoEncontradoExecption;
import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.EqualizadorNaoEncontradoException;
import excecoesEqualizadores.NomeVazioException;
import preset.ControladorPreset;

public class Fachada {

	private static Fachada instance;
	
	private 	ControladorArtista 		controladorArtista;
	private 	ControladorEndereco 	controladorEndereco;
	private 	ControladorPreset 		controladorPreset;
	private 	ControladorEqualizador 	controladorEqualizador;

	/* Construtor privado da Classe Fachada void */
	private Fachada() throws ClassNotFoundException, IOException {
		this.controladorArtista 		= new ControladorArtista	();
		this.controladorPreset 			= new ControladorPreset		();
		this.controladorEqualizador 	= new ControladorEqualizador();
		this.controladorEndereco 		= new ControladorEndereco	();
	}

	//Método para cria uma unica instancia da classe Fachada Retorna um objeto da Classe Fachada
	public static Fachada getInstance() throws ClassNotFoundException, IOException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	//====================== Cadastrar Artista Objeto da Classe Artista void ========================
	public void cadastrarAtista(Artista artista) throws SQLException, ArtistaJaCadastradoException, IOException {
		controladorArtista.cadastrar(artista);
	}

	//Método para atualizar os dados do Cliente Objeto da Classe Artista. void
	public void atualizarArtista(Artista artista)
			throws SQLException, ArtistaNaoEncontradoExecption, ArtistaJaCadastradoException, IOException {
		this.controladorArtista.atualizar(artista);
	}

	//Método para remover os dados do Artista CPF do Artista Booleano
	public void removerArtista(String cpf) throws SQLException, ArtistaNaoEncontradoExecption, IOException {
		this.controladorArtista.remover(cpf);
	}

	//Método para procurar os dados do Artista CPF do Artista Retorna um objeto da Classe Artista
	public Artista procurarArtista(String cpf)
			throws ArtistaNaoEncontradoExecption, SQLException, ArtistaJaCadastradoException, IOException {
		return this.controladorArtista.procurar(cpf);
	}

	public boolean existeArtista(String cpf) throws SQLException, IOException {
		return controladorArtista.existe(cpf);
	}

	//Método para lista todos os dados do Artista Retorna uma coleção de objetos da Classe Artista	
	public ArrayList<Artista> listarArtista() throws SQLException, IOException {
		return this.controladorArtista.listar();
	}
	
	
	
	//====================== Cadastrar Endereço Objeto da Classe Endereço void ========================
	public void cadastrarEndereco(Endereco endereco) throws SQLException, IOException {
		controladorEndereco.cadastrar(endereco);

	}

	public void atualizarEndereco(Endereco endereco) throws SQLException, IOException {
		controladorEndereco.atualizar(endereco);

	}

	public void removerEndereco(Integer IdEndereco) throws SQLException, IOException {
		controladorEndereco.remover(IdEndereco);
	}

	public Endereco procurarEndereco(Integer IdEndereco) throws Exception {
		return controladorEndereco.procurar(IdEndereco);
	}

	public boolean existirEndereco(Integer IdEndereco) throws SQLException, IOException {
		return controladorEndereco.existir(IdEndereco);
	}

	public ArrayList<Endereco> listarEndereco() throws SQLException, IOException {
		return controladorEndereco.listar();
	}
	/*
	 * ====================== Cadastrar Preset Objeto da Classe Preset void ========================
	 */
	
	/*
	 * ====================== Cadastrar Equalizador Objeto da Classe Equalizador void ========================
	 */
	public void cadastrarEqualizador(Equalizador equalizador) {
		try {
			controladorEqualizador.cadastrar(equalizador);
		} catch (Exception e) {
			System.out.println("cadastrarEqualizador -> " + e.getMessage());
		}
		

	}

	public void atualizarEqualizador(Equalizador equalizador) throws SQLException, IOException, EqualizadorNaoEncontradoException {
		controladorEqualizador.atualizar(equalizador);

	}

	public void removerEqualizador(Integer nomeEqualizador) throws SQLException, IOException {
		controladorEndereco.remover(nomeEqualizador);
	}

	public Equalizador procurarEqualizador(String nomeEqualizador) throws Exception {
		return controladorEqualizador.procurar(nomeEqualizador);
	}

	public boolean existirEqualizador(String nomeEqualizador) throws SQLException, IOException {
		return controladorEqualizador.existi(nomeEqualizador);
	}

	public ArrayList<Equalizador> listarEqualizador() throws SQLException, IOException {
		return controladorEqualizador.listar();

	}
}