package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Jogador;

public class Tela_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private Jogador jogador;

	
	public void Run(){
		this.setSize(645, 470);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public Tela_Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLogin.setToolTipText("Login");
		txtLogin.setBounds(179, 175, 314, 25);
		painel.add(txtLogin);
		txtLogin.setColumns(20);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setToolTipText("Senha");
		txtSenha.setBounds(179, 218, 314, 25);
		painel.add(txtSenha);
		txtSenha.setColumns(20);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnSair.setBackground(new Color(75, 0, 130));
		btnSair.setBounds(374, 270, 121, 57);
		painel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(0, 255, 0));
		btnEntrar.setBounds(227, 270, 137, 57);
		painel.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogador = new Jogador();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				jogador.setLogin(login);
				jogador.setSenha(senha);
				if(jogador.Logar().equals("OK")){
					Tela_inicial tela = new Tela_inicial();
					tela.Run();
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null,"Login ou senha Inv�lido");		
			}
		});
		btnEntrar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		
		JButton btnCadastrar = new JButton("Cadastre - se aqui");
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBackground(new Color(0, 255, 0));
		btnCadastrar.setBounds(277, 346, 260, 45);
		painel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Cadastrar cadastrar;
				try {
					cadastrar = new Tela_Cadastrar();
					cadastrar.Run();
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		
		JLabel lblCadastrar = new JLabel("N\u00E3o \u00E9 cadastrado ?");
		lblCadastrar.setForeground(Color.BLACK);
		lblCadastrar.setBackground(new Color(255, 255, 255));
		lblCadastrar.setBounds(32, 352, 235, 35);
		painel.add(lblCadastrar);
		lblCadastrar.setFont(new Font("Arial", Font.BOLD, 25));
	
		getRootPane().setDefaultButton(btnEntrar);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Senha.png"));
		lblSenha.setBounds(138, 211, 35, 37);
		painel.add(lblSenha);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Login.png"));
		lblLogin.setBounds(138, 166, 38, 37);
		painel.add(lblLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(159, 0, 311, 200);
		painel.add(lblLogo);
		
		JLabel lblFundo = new JLabel("fundo");
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(-112, -14, 754, 475);
		painel.add(lblFundo);
	}
}
