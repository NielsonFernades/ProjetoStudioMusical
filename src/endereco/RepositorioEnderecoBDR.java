/*
* RepositórioEndereçoBDR
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import artista.Artista;
import conexao.ConecatBancoPostgresql;

public class RepositorioEnderecoBDR implements IRepositorioEndereco {

	Connection connection;

	public RepositorioEnderecoBDR() throws ClassNotFoundException {
		this.connection = ConecatBancoPostgresql.conectabd();
	}

	@Override
	public void cadastrar(Endereco endereco) throws SQLException {
			String sql = "inset into endereco (rua, bairro, numero, cep, cidade) values(?,?,?,?,?) ";		
			PreparedStatement preStatement = connection.prepareStatement(sql);

			//preStatement.setLong	(1, endereco.getIdEndereco	());
			preStatement.setString	(1, endereco.getRua			());
			preStatement.setString	(2, endereco.getBairro		());
			preStatement.setString	(3, endereco.getNumero		());
			preStatement.setString	(4, endereco.getCep			());
			preStatement.setString	(5, endereco.getCidade		());
			//preStatement.setObject	(6, endereco.getArtista		());

			// resultSet = preStatement.getGeneratedKeys();
			//Integer idEndereco = 0;

			//while (resultSet.next()) {
				//idEndereco = resultSet.getInt(1);
			
			//System.out.println("ID do Insert no Banco " + idEndereco);
			
			preStatement.execute();
			
			JOptionPane.showMessageDialog(null, "Endereço Cadastrado!");
		}

	@Override
	public void atualizar(Endereco endereco) throws SQLException {
		String sql = "update endereco  set idEndereco = ?, rua = ?, bairro = ?, numero = ?,"
				+ " cep = ?, cidade= ?)";	
		PreparedStatement preStatement = connection.prepareStatement(sql);

		preStatement.setLong	(1, endereco.getIdEndereco		());
		preStatement.setString	(2, endereco.getRua				());
		preStatement.setString	(3, endereco.getBairro			());
		preStatement.setString	(4, endereco.getNumero			());
		preStatement.setString	(5, endereco.getCep				());
		preStatement.setString	(6, endereco.getCidade			());
		preStatement.setObject	(7, endereco.getArtista			());

		preStatement.executeUpdate();

		System.out.println("Endereço Atualizado!");
		JOptionPane.showMessageDialog(null, "Endereço Atualizado!");
	}

	@Override
	public void remover(Integer idEndereco) throws SQLException{
		String sql = "delete from endereco where idEndereco = ?";		
		PreparedStatement prestatement = connection.prepareStatement(sql);
		prestatement.setLong(1, idEndereco);
		prestatement.executeUpdate();

		System.out.println("Endereço Removido!");
		JOptionPane.showMessageDialog(null, "Endereço Removido!");

	}

	@Override
	public Endereco procurar(Integer idEndereco) throws SQLException {
		String sql = "select * from endereco where idEndereco = ?";	
		PreparedStatement preStatement = connection.prepareStatement(sql);
		preStatement.setInt(1, idEndereco);

		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {
			
			Integer 	IdEndereco 		= 			resultSet.getInt	(1);
			String 		rua 			= 			resultSet.getString	(2);
			String 		bairro 			= 			resultSet.getString	(3);
			String 		numero 			= 			resultSet.getString	(4);
			String 		cep 			= 			resultSet.getString	(5);
			String 		cidade 			= 			resultSet.getString	(6);
			Artista 	artista 		= (Artista) resultSet.getObject	(7);

			Endereco endereco = new Endereco(IdEndereco, rua, bairro, numero, cep, cidade, artista);
			return endereco;
		}
		return null;
	}

	@Override
	public boolean existir(Integer IdEndereco) throws SQLException {
		String sql = "select * from endereco where IdEndereco = ?";	
		PreparedStatement preStatement = connection.prepareStatement(sql);
		preStatement.setInt(1, IdEndereco);
		ResultSet resultSet = preStatement.executeQuery();

		if (resultSet.equals(IdEndereco)) {
			JOptionPane.showMessageDialog(null, "Endereço já Existente!");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Endereço Não Existe!");
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() throws SQLException{
		String sql = "select * from endereco";
		PreparedStatement preStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();

		ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();

		while (resultSet.next()) {

			Integer 	idEndereco 		= 			resultSet.getInt	(1);
			String 		rua 			= 			resultSet.getString	(2);
			String 		bairro 			= 			resultSet.getString	(3);
			String 		numero 			= 			resultSet.getString	(4);
			String 		cep 			= 			resultSet.getString	(5);
			String 		cidade 			= 			resultSet.getString	(6);
			Artista 	artista 		= (Artista) resultSet.getObject	(7);

			Endereco endereco = new Endereco(idEndereco, rua, bairro, numero, cep, cidade, artista);
			arrayEndereco.add(endereco);
		}

		return arrayEndereco;
	}

}
