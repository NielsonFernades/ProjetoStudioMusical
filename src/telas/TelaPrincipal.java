package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Studio Metal Music");

		// setIconImage(Toolkit.getDefaultToolkit()
		// .getImage(TelaPrincipal.class.getResource("/ProjetoStudioMusical/imagens/fundo_azul.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 573, 392);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setIcon(new ImageIcon("C:\\Users\\Nielson\\Downloads\\Icones\\application_add.png"));
		menuBar.add(mnCadastro);

		JMenuItem mntmAdcionarArtista = new JMenuItem("Artista");
		mntmAdcionarArtista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});

		JMenuItem mntmCadastrarNovo = new JMenuItem("Cadastrar Novo");
		mntmCadastrarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaCadastroArtista jca = new JanelaCadastroArtista();
				jca.setVisible(true);
				this.setLocationRelativeTo(null);
			}

			private void setLocationRelativeTo(Object object) {
				// TODO Auto-generated method stub

			}
		});
		mnCadastro.add(mntmCadastrarNovo);
		mnCadastro.add(mntmAdcionarArtista);

		JMenuItem mntmAdcionarPreset = new JMenuItem("Preset");
		mntmAdcionarPreset.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		mnCadastro.add(mntmAdcionarPreset);

		JMenuItem mntmAdcionarEqualizador = new JMenuItem("Equalizador");
		mnCadastro.add(mntmAdcionarEqualizador);

		JMenu mnProcurar = new JMenu("Procurar");
		mnProcurar.setIcon(new ImageIcon("C:\\Users\\Nielson\\Downloads\\Icones\\zoom.png"));
		menuBar.add(mnProcurar);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		mnOpes.setIcon(new ImageIcon("C:\\Users\\Nielson\\Downloads\\Icones\\application_osx_terminal.png"));
		menuBar.add(mnOpes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // System.exit(0);
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versao versao = new Versao();
				versao.setVisible(true);

			}

		});
		mnOpes.add(mntmNewMenuItem);
		mnOpes.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

}
