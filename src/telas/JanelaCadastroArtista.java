package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JSeparator;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JanelaCadastroArtista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JLabel lblWebsite;
	private JLabel lblGneroMusical;
	private JLabel lblRua;
	private JLabel lblNmero;
	private JTextField textField_7;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JTextField textField_8;
	private JLabel lblCidade;
	private JTextField textField_10;
	private JLabel lblCod;
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaCadastroArtista dialog = new JanelaCadastroArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JanelaCadastroArtista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\imagens\\2108105847F01.png"));
		setResizable(false);
		setTitle("Cadastro de Artistas");
		setBounds(100, 100, 754, 537);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel paneldados = new JPanel();
		paneldados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		paneldados.setBounds(21, 40, 698, 182);
		contentPanel.add(paneldados);
		paneldados.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNome.setBounds(21, 35, 79, 14);
		paneldados.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(21, 49, 320, 20);
		paneldados.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCpfcnpj.setBounds(352, 35, 79, 14);
		paneldados.add(lblCpfcnpj);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEmail.setBounds(21, 80, 79, 14);
		paneldados.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 94, 320, 20);
		paneldados.add(textField_2);
		textField_2.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTelefone.setBounds(352, 125, 79, 14);
		paneldados.add(lblTelefone);
		
		lblWebsite = new JLabel("WebSite");
		lblWebsite.setFont(new Font("Dialog", Font.BOLD, 11));
		lblWebsite.setBounds(352, 80, 79, 14);
		paneldados.add(lblWebsite);
		
		lblGneroMusical = new JLabel("G\u00EAnero Musical");
		lblGneroMusical.setFont(new Font("Dialog", Font.BOLD, 11));
		lblGneroMusical.setBounds(21, 125, 102, 14);
		paneldados.add(lblGneroMusical);
		
		textField_3 = new JTextField();
		textField_3.setBounds(352, 94, 320, 20);
		paneldados.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(21, 141, 179, 20);
		paneldados.add(textField_4);
		textField_4.setColumns(10);
		
		lblCod = new JLabel("Cod");
		lblCod.setEnabled(false);
		lblCod.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCod.setBounds(609, 35, 46, 14);
		paneldados.add(lblCod);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(351, 49, 160, 20);
		paneldados.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(352, 141, 159, 20);
		paneldados.add(formattedTextField_1);
		
		JPanel panelendereco = new JPanel();
		panelendereco.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panelendereco.setBounds(21, 282, 698, 182);
		contentPanel.add(panelendereco);
		panelendereco.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 50, 526, 20);
		panelendereco.add(textField_1);
		textField_1.setColumns(10);
		
		lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Dialog", Font.BOLD, 11));
		lblRua.setBounds(25, 34, 46, 14);
		panelendereco.add(lblRua);
		
		lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNmero.setBounds(578, 34, 62, 14);
		panelendereco.add(lblNmero);
		
		textField_7 = new JTextField();
		textField_7.setBounds(577, 50, 86, 20);
		panelendereco.add(textField_7);
		textField_7.setColumns(10);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 11));
		lblBairro.setBounds(25, 81, 46, 14);
		panelendereco.add(lblBairro);
		
		lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCep.setBounds(578, 81, 46, 14);
		panelendereco.add(lblCep);
		
		textField_8 = new JTextField();
		textField_8.setBounds(25, 98, 241, 20);
		panelendereco.add(textField_8);
		textField_8.setColumns(10);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCidade.setBounds(311, 81, 46, 14);
		panelendereco.add(lblCidade);
		
		textField_10 = new JTextField();
		textField_10.setBounds(308, 98, 243, 20);
		panelendereco.add(textField_10);
		textField_10.setColumns(10);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(578, 98, 110, 20);
		panelendereco.add(formattedTextField_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\\u00EDcones\\Icones\\user_add.png"));
		btnSalvar.setBounds(35, 131, 110, 23);
		panelendereco.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\\u00EDcones\\Icones\\page_white.png"));
		btnLimpar.setBounds(168, 131, 110, 23);
		panelendereco.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\\u00EDcones\\Icones\\user_delete.png"));
		btnExcluir.setBounds(301, 131, 110, 23);
		panelendereco.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\\u00EDcones\\Icones\\application_edit.png"));
		btnEditar.setBounds(434, 131, 110, 23);
		panelendereco.add(btnEditar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcurar.setIcon(new ImageIcon("E:\\Edi\u00E7\u00E3o\\Projeto Mars\\ProjetoStudioMusical\\src\\\u00EDcones\\Icones\\zoom.png"));
		btnProcurar.setBounds(567, 131, 110, 23);
		panelendereco.add(btnProcurar);
		contentPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNome, paneldados, textField, lblCpfcnpj, lblEmail, textField_2, lblTelefone, lblWebsite, lblGneroMusical, textField_3, textField_4, lblCod, btnSalvar, btnLimpar, btnExcluir, btnEditar, btnProcurar, panelendereco, textField_1, lblRua, lblNmero, textField_7, lblBairro, lblCep, textField_8, lblCidade, textField_10}));
		
		Label label_2 = new Label("Cadastro Artistas");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(311, 10, 106, 22);
		contentPanel.add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 243, 664, 13);
		contentPanel.add(separator);
		
		panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel1.setBounds(10, 35, 718, 197);
		contentPanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel2.setBounds(10, 267, 718, 209);
		contentPanel.add(panel2);
	}
}
