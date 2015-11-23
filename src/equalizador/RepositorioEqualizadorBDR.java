/*
* RepositórioEqualizador
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package equalizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConecatBancoPostgresql;
import excecoesEqualizadores.EqualizadorJaCadastradoException;
import excecoesEqualizadores.EqualizadorNaoEncontradoException;
import excecoesEqualizadores.NomeVazioException;

public class RepositorioEqualizadorBDR implements IRepositorioEqualizador {
	Connection connection;

	public RepositorioEqualizadorBDR() throws ClassNotFoundException {
		this.connection = ConecatBancoPostgresql.conectabd();

	}

	@Override
	public void cadastrar(Equalizador equalizador) throws EqualizadorJaCadastradoException, NomeVazioException, SQLException{
		// System.out.println("Estou no Repositorio :D " + artista);
		// artista.setCodigo(35);
		try {

			String sql = "insert into equalizadores (nomeequalizador, volumeequalizador, graveequalizador, medioequalizador, agudoequalizador) values (?,?,?,?,?)";
			
			PreparedStatement preStatement = connection.prepareStatement(sql);

			//preStatement.setLong	(1, equalizador.getIdEqualizador	());
			preStatement.setString	(1, equalizador.getNomeEqualizador	());
			preStatement.setString	(2, equalizador.getVolumeEqualizador());
			preStatement.setString	(3, equalizador.getGraveEqualizador	());
			preStatement.setString	(4, equalizador.getMedioEqualizador	());
			preStatement.setString	(5, equalizador.getAgudoEqualizador	());
			//preStatement.setObject(7, equalizador.getArtista			());

			preStatement.execute();
			
			ResultSet resultSet = preStatement.getGeneratedKeys();
			Integer IdEqualizador = 0;
		
			while (resultSet.next()) {
				IdEqualizador = resultSet.getInt(1);
			}
			System.out.println("ID do Insert no Banco " + IdEqualizador);
			JOptionPane.showMessageDialog(null, "Equalizador Cadastrado!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}

	@Override
	public void atualizar(Equalizador equalizador) throws EqualizadorNaoEncontradoException, SQLException {
		String sql = "inset into equalizadores () values(?,?,?,?,?,?,?) ";
		PreparedStatement preStatement = connection.prepareStatement(sql);

		preStatement.setLong	(1, equalizador.getIdEqualizador	());
		preStatement.setString	(2, equalizador.getNomeEqualizador	());
		preStatement.setString	(3, equalizador.getVolumeEqualizador());
		preStatement.setString	(4, equalizador.getGraveEqualizador	());
		preStatement.setString	(5, equalizador.getMedioEqualizador	());
		preStatement.setString	(6, equalizador.getAgudoEqualizador	());
		//preStatement.setObject(7, equalizador.getArtista			());

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Equalizador Atualizado!");

	}

	@Override
	public void remover(String nome) throws SQLException, EqualizadorNaoEncontradoException {
		String sql = "delete from equalizadores where IdEqualizador = ?";
		PreparedStatement preStatement = connection.prepareStatement(sql);
		
		preStatement.setString(1, nome);
		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Equalizador Removido");
	}

	@Override
	public Equalizador procurar(String nome) throws SQLException, EqualizadorNaoEncontradoException {
		String sql = "select * from equalizadores where IdEqualizadores = ?";
		PreparedStatement preStatement;
		preStatement = connection.prepareStatement(sql);

		preStatement.setString(1, nome);
		ResultSet resultset = preStatement.executeQuery();
		
		while (resultset.next()) {

			int 	idEqualizador 		= 	resultset.getInt	(1);
			String 	nomeEqualizador 	= 	resultset.getString	(2);
			String 	volumeEqualizador 	= 	resultset.getString	(3);
			String 	graveEqualizador 	= 	resultset.getString	(4);
			String 	medioEqualizador 	= 	resultset.getString	(5);
			String 	agudoEqualizador 	= 	resultset.getString	(6);

			Equalizador equalizador1 = new Equalizador(idEqualizador, nomeEqualizador, volumeEqualizador, graveEqualizador, medioEqualizador, agudoEqualizador);
			
			return equalizador1;
		}

		return null;
	}

	@Override
	public boolean existe(String nome) {
		return false;
	}

	@Override
	public ArrayList<Equalizador> listar() throws SQLException {
		ArrayList<Equalizador> arrayListEqualizador = new ArrayList<Equalizador>();
		String sql = "select * from equalizadores";
		
		PreparedStatement preStatement;
		preStatement = connection.prepareStatement(sql);
		ResultSet resultset = preStatement.executeQuery();
		
		while (resultset.next()) {
			
			int 	idEqualizador 		= 	resultset.getInt	(1);
			String 	nomeEqualizador 	= 	resultset.getString	(2);
			String 	volumeEqualizador 	= 	resultset.getString	(3);
			String 	graveEqualizador 	= 	resultset.getString	(4);
			String 	medioEqualizador 	= 	resultset.getString	(5);
			String 	agudoEqualizador 	= 	resultset.getString	(6);
			
			Equalizador equalizador1 = new Equalizador(idEqualizador, nomeEqualizador, volumeEqualizador, graveEqualizador, medioEqualizador, agudoEqualizador);
				arrayListEqualizador.add(equalizador1);

		}
		return arrayListEqualizador;
	}

}
