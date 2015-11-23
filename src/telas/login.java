package telas;

import java.sql.*;
import conexao.ConecatBancoPostgresql;
//import conexao.ConectaBancoOracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class login {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws ClassNotFoundException
	 */
	public login() throws ClassNotFoundException {
		initialize();
		con = ConecatBancoPostgresql.conectabd();
	}

	public void Logar() {

		String sql = "Select * from loginadm where usuario = ? and senha = ?";

		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtSenha.getText());

			rs = pst.executeQuery();

			if (rs.next()) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos!");
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 328, 196);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(65, 49, 218, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(65, 84, 218, 20);
		frame.getContentPane().add(txtSenha);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLogin.setBounds(24, 45, 201, 20);
		frame.getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSenha.setBounds(24, 83, 201, 20);
		frame.getContentPane().add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logar();
			}
		});
		btnEntrar.setBounds(44, 115, 89, 23);
		frame.getContentPane().add(btnEntrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(177, 115, 89, 23);
		frame.getContentPane().add(btnCancelar);

		JLabel lblLoginAdmnistrador = new JLabel("Login Admnistrador");
		lblLoginAdmnistrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAdmnistrador.setForeground(Color.GRAY);
		lblLoginAdmnistrador.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLoginAdmnistrador.setBounds(84, 11, 158, 27);
		frame.getContentPane().add(lblLoginAdmnistrador);
	}
}
