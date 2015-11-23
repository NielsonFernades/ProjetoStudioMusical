package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectaBancoOracle10 {
	public static Connection conectabd() throws ClassNotFoundException {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:http:127.0.0.1:8080", "system", "premiereads");
			JOptionPane.showMessageDialog(null, "Conectado com Oracle");
			return con;
		}

		catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, erro);

			return null;
		}

	}

}