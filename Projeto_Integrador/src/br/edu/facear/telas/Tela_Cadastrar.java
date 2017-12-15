package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.edu.facear.classes.Jogador;

public class Tela_Cadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmarSenha;
	private JFormattedTextField txtTelefone;
	private JTextField txtIdade;
	private JLabel lblLoginExistente;
	private JButton btnSair;
	private Jogador jogador;
	private JLabel lblFundo;
	private JLabel label_2;
	private JLabel lblImagem;
	private JLabel lblSenhaIncorreta;
	private String fileName;
	
	public void Run(){
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
	
	}
	
	public Tela_Cadastrar() throws ParseException {
		setTitle("Cadastrar Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblNome.setBounds(455, 121, 63, 37);
		contentPane.add(lblNome);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblLogin.setBounds(456, 190, 63, 37);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblSenha.setBounds(455, 261, 68, 37);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setForeground(Color.BLACK);
		lblConfirmarSenha.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 28));
		lblConfirmarSenha.setBounds(455, 334, 185, 37);
		contentPane.add(lblConfirmarSenha);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblTelefone.setBounds(455, 403, 98, 37);
		contentPane.add(lblTelefone);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.BLACK);
		lblIdade.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblIdade.setBounds(454, 477, 66, 37);
		contentPane.add(lblIdade);
		
		JButton btnCadastrar = new JButton(" Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\plus.png"));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(75, 0, 130));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				jogador = new Jogador();
				String nome = txtNome.getText();
				String login = txtLogin.getText();
				
				char[] chars = txtSenha.getPassword();
				String senha = String.valueOf(chars);
				
				char[] charsConfirma = txtConfirmarSenha.getPassword();
				String confirma = String.valueOf(charsConfirma);
				
				String telefone = txtTelefone.getText();
				int idade = Integer.parseInt(txtIdade.getText());
				
				jogador.setNome(nome);
				jogador.setLogin(login);
				
				jogador.setSenha(senha);
				jogador.setConfirma(confirma);
				
				jogador.setTelefone(telefone);
				jogador.setIdade(idade);
				
				if(fileName == null){
					fileName = "C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\UsuarioPadrao.png";
					jogador.setImagem(fileName);
				}else
					jogador.setImagem(fileName);
				
				if(jogador.Existente().equals("ERRO"))
					lblLoginExistente.setText("");
				else
					lblLoginExistente.setText(" * Login Existente");
				if(jogador.getSenha().equals(jogador.getConfirma()))
					lblSenhaIncorreta.setText("");
				else
					lblSenhaIncorreta.setText(" * As senhas n�o correspondem ");

				
				if(jogador.getSenha().equals(jogador.getConfirma()) && jogador.Existente().equals("ERRO")){
					jogador.Cadastrar(true);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					Tela_Login tela = new Tela_Login();
					tela.Run();
					dispose();
				}
			}
		});
		btnCadastrar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		btnCadastrar.setBounds(455, 562, 194, 58);
		contentPane.add(btnCadastrar);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(455, 159, 365, 27);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLogin.setBounds(455, 230, 363, 27);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(456, 303, 363, 27);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtConfirmarSenha.setBounds(454, 374, 362, 27);
		contentPane.add(txtConfirmarSenha);
		txtConfirmarSenha.setColumns(10);
		
		MaskFormatter mascara = new MaskFormatter("(##) #####-####");
		mascara.setPlaceholder("_");
		txtTelefone = new JFormattedTextField(mascara);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setBounds(458, 443, 210, 27);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdade.setBounds(455, 516, 58, 27);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnSair.setBackground(new Color(75, 0, 130));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Login l = new Tela_Login();
				l.Run();
				dispose();
			}
		});
		btnSair.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		btnSair.setBounds(659, 562, 194, 58);
		contentPane.add(btnSair);
		
		lblLoginExistente = new JLabel();
		lblLoginExistente.setForeground(Color.RED);
		lblLoginExistente.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		lblLoginExistente.setBounds(540, 195, 219, 30);
		contentPane.add(lblLoginExistente);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\user-image-with-black-background.png"));
		lblImagem.setBounds(876, 139, 128, 128);
		contentPane.add(lblImagem);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(568, -31, 311, 200);
		contentPane.add(label_2);
		
		JButton btnSelecioneUmaImagem = new JButton("Adicionar Foto");
		btnSelecioneUmaImagem.setBackground(Color.GREEN);
		btnSelecioneUmaImagem.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		btnSelecioneUmaImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser escolha = new JFileChooser();
				escolha.showOpenDialog(null);
				File f = escolha.getSelectedFile();
				fileName = f.getAbsolutePath();
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
				lblImagem.setIcon(imageIcon);
							
			}
		});
		btnSelecioneUmaImagem.setBounds(856, 278, 178, 27);
		contentPane.add(btnSelecioneUmaImagem);
		
		lblSenhaIncorreta = new JLabel("");
		lblSenhaIncorreta.setForeground(Color.RED);
		lblSenhaIncorreta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		lblSenhaIncorreta.setBounds(639, 341, 198, 30);
		contentPane.add(lblSenhaIncorreta);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(147, 112, 219));
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(391, 121, 709, 430);
		contentPane.add(panel);
		
		lblFundo = new JLabel("Fundo");
		lblFundo.setVerticalAlignment(SwingConstants.TOP);
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(-50, -7, 2534, 768);
		contentPane.add(lblFundo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(547, -6, 311, 200);
		contentPane.add(lblLogo);
				
	}
}
