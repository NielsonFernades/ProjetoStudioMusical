/*
* RepositórioArtistaBDR
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConecatBancoPostgresql;
import excecoesArtistas.ArtistaJaCadastradoException;
//import endereco.Endereco;

public class RepositorioArtistaBDR implements IRepositorioArtista {

	Connection conecta;

	public RepositorioArtistaBDR() throws ClassNotFoundException {
		this.conecta = ConecatBancoPostgresql.conectabd();

	}

	@Override
	public void cadastrar(Artista artista) throws SQLException, ArtistaJaCadastradoException {

		// Exemplo de Insert Criando a String SQL
		String sql = "insert into artistas (nome, cpf, email, webSite, telefone, genero) values (?, ?, ?, ?, ?, ?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conecta.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Atualizando o primeiro parametro
		preStatement.setString	(1, artista.getNome		());
		preStatement.setString	(2, artista.getCpf		());
		preStatement.setString	(3, artista.getEmail	());
		preStatement.setString	(4, artista.getWebSite	());
		preStatement.setString	(5, artista.getTelefone	());
		preStatement.setString	(6, artista.getGenero	());
		// preStatement.setString(7, artista.getEndereço());

		preStatement.execute();

		// Retorna um ResultSet com todas as chaves geradas
		ResultSet resultSet = preStatement.getGeneratedKeys();
		Integer ID_Artista = 0;

		// Pegando o identificador gerado a partir do último insert
		while (resultSet.next()) {
			ID_Artista = resultSet.getInt(1);
		}
		System.out.println("ID do Insert no Banco " + ID_Artista);
		System.out.println("Cadastro realizado!");
		JOptionPane.showMessageDialog(null, "Artista Cadastrado!");

		// Fechando conexões
		// conecta.close();
		// preStatement.close();
		// resultSet.close();
	}

	// System.out.println("Estou no Repositorio"+artista);artista.setID_Artista(35);

	@Override
	public void atualizar(Artista artista) throws SQLException {

		// Criando a String SQL para atualização dos artistas
		String sql = "update artistas set nome = ?, cpf = ?, email = ?, ewbSite = ?, telefone = ?, genero = ? where cpf = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;

		preStatement = conecta.prepareStatement(sql);

		preStatement.setString	(1, artista.getNome		());
		preStatement.setString	(2, artista.getCpf		());
		preStatement.setString	(3, artista.getEmail	());
		preStatement.setString	(4, artista.getWebSite	());
		preStatement.setString	(5, artista.getTelefone	());
		preStatement.setString	(6, artista.getGenero	());

		// preStatement.setString(7, artista.getEndereço());

		// Executando
		preStatement.executeUpdate();

		System.out.println("Artista Atualizado!");
		JOptionPane.showMessageDialog(null, "Artista Atualizado!");

	}

	@Override
	public void remover(String cpf) throws SQLException {
		// Criando a String SQL
		String sql = "delete from artistas where CPF = ?";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conecta.prepareStatement(sql);

		preStatement.setString(1, cpf);

		// Executando o select
		preStatement.executeUpdate();

		System.out.println("Artista Removido");
		JOptionPane.showMessageDialog(null, "Artista Removido");
	}

	@Override
	public Artista procurar(String cpf) throws SQLException {

		String sql = "select * from artistas where cpf = ?";

		PreparedStatement preStatement = conecta.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
			
			//int 		ID_Artista 		= resultSet.getInt		(1);
			String 		nome 			= resultSet.getString	(2);
			String 		cpf1 			= resultSet.getString	(3);
			String 		email 			= resultSet.getString	(4);
			String 		webSite 		= resultSet.getString	(5);
			String 		telefone 		= resultSet.getString	(6);
			String 		genero 			= resultSet.getString	(7);

			Artista artista = new Artista(nome, cpf1, email, webSite, telefone, genero);
			return artista;

		}

		return null;

	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		String sql = "select * from artistas where cpf= ?";

		PreparedStatement preStatement = conecta.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		return true;

	}

	@Override
	public ArrayList<Artista> listar() throws SQLException {

		ArrayList<Artista> arrayListArtista = new ArrayList<Artista>();

		// Criando a String SQL
		String sql = "select * from artistas";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conecta.prepareStatement(sql);

		ResultSet resultSet = preStatement.executeQuery();

		// Verifica se retornou dados na consulta
		while (resultSet.next()) {

			// Pegando as colunas do registro
			//int 		ID_Artista 	= resultSet.getInt		(1);
			String 		nome 		= resultSet.getString	(2);
			String 		cpf 		= resultSet.getString	(3);
			String 		email 		= resultSet.getString	(4);
			String 		webSite 	= resultSet.getString	(5);
			String 		telefone	= resultSet.getString	(6);
			String 		genero 		= resultSet.getString	(7);

			Artista artista = new Artista(nome, cpf, email, webSite, telefone, genero);
			arrayListArtista.add(artista);
		}

		return arrayListArtista;
	}

}
