package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class Versao {

	private JFrame FrameVersao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versao window = new Versao();
					window.FrameVersao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Versao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrameVersao = new JFrame();
		FrameVersao.setTitle("Sobre");
		FrameVersao.setForeground(SystemColor.inactiveCaption);
		FrameVersao.setBounds(100, 100, 450, 300);
		FrameVersao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameVersao.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, null, null, null));
		panel.setBounds(10, 11, 414, 240);
		FrameVersao.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 11, 394, 218);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		
		Label label = new Label("Metal Music Studio Vers\u00E3o 1.0 ");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setAlignment(Label.CENTER);
		label.setBounds(120, 89, 173, 22);
		panel.add(label);
		
		Label label_1 = new Label("Por Nielson Vieira");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(120, 117, 174, 22);
		panel.add(label_1);
		btnNewButton.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\imagens\\1251864367771-797793.jpeg"));
		panel.add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
