package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConecatBancoPostgresql {
	public static Connection conectabd() throws ClassNotFoundException {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Crud2", "postgres","premiereads");
			JOptionPane.showMessageDialog(null, "Conectado com Banco Postegre");
			return con;
		}

		catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, erro);

			return null;
		}

	}

}
