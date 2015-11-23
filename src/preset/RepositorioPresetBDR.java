/*
* RepositórioPresetBDR
* Versão: 1.0
* Data de Criação : 19/10/2015
* Nielson Vieira
*/

package preset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConecatBancoPostgresql;

public class RepositorioPresetBDR implements IRepositorioPreset {

	Connection conecta;

	public RepositorioPresetBDR() throws ClassNotFoundException {
		this.conecta = ConecatBancoPostgresql.conectabd();
	}

	@Override
	public void cadastrar(Preset preset) throws SQLException {
		// System.out.println("Estou no Repositorio :D " + artista);
		// artista.setCodigo(35);
		String sql = "insert into presets (idPreset, nomePreset, generoPreset, dataPreset) values(?,?,?,?)";

		PreparedStatement preStatement = conecta.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		preStatement.setInt			(1, preset.getIdPreset		());
		preStatement.setString		(2, preset.getNomePreset	());
		preStatement.setString		(3, preset.getGeneroPreset	());
		preStatement.setString		(4, preset.getDataPreset	());
		
		preStatement.execute();

		JOptionPane.showMessageDialog(null, "Preset cadastrado!");

	}

	@Override
	public void atualizar(Preset preset) throws SQLException {
		String sql = "update presets set idPreset = ?, nomePreset = ?, generoPreset = ?, dataPreset = ? where idPreset = ?";
		PreparedStatement preStatement = conecta.prepareStatement(sql);

		preStatement.setInt			(1, preset.getIdPreset		());
		preStatement.setString		(2, preset.getNomePreset	());
		preStatement.setString		(3, preset.getGeneroPreset	());
		preStatement.setString		(4, preset.getDataPreset	());
		
		preStatement.setInt(5, preset.getIdPreset());

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Preset Atualizado!");

	}

	@Override
	public void remover(String idPreset) throws SQLException {

		String sql = "delete from presets where idPreset = ? ";

		PreparedStatement preStatement = conecta.prepareStatement(sql);

		preStatement.setString(1, idPreset);

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Removido Com Sucesso");

	}

	@Override
	public Preset procurar(String IdPreset) throws SQLException {
		String sql = "select * from presets where idPreset = ? ";

		PreparedStatement preStatement;

		preStatement = conecta.prepareStatement(sql);

		preStatement.setString(1, IdPreset);
		ResultSet resultset = preStatement.executeQuery();
		while (resultset.next()) {

			int 	idPreset 		= resultset.getInt		(1);
			String 	nomePreset 		= resultset.getString	(2);
			String 	generoPreset 	= resultset.getString	(3);
			String 	dataPreset 		= resultset.getString	(4);
			
			Preset preset1 = new Preset(idPreset, nomePreset, generoPreset, dataPreset);

			return preset1;
		}

		return null;
	}

	@Override
	public Boolean existe(String Preset) {
		return null;
	}

	@Override
	public ArrayList<Preset> listar() throws SQLException {

		ArrayList<Preset> arrayListPreset = new ArrayList<Preset>();

		String sql = "select * from presets";

		PreparedStatement preStatement;
		preStatement = conecta.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int 	idPreset 		= resultSet.getInt		(1);
			String 	nomePreset 		= resultSet.getString	(2);
			String 	generoPreset 	= resultSet.getString	(3);
			String 	dataPreset 		= resultSet.getString	(4);
			
			Preset preset1 = new Preset(idPreset, nomePreset, generoPreset, dataPreset);
			arrayListPreset.add(preset1);
		}

		return arrayListPreset;
	}

}
