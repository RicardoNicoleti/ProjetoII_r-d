package br.edu.facear.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setSize(437, 302);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public Tela_Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel lblQuizByRd = new JLabel("Quiz by R&D");
		lblQuizByRd.setBounds(159, 11, 156, 32);
		painel.add(lblQuizByRd);
		lblQuizByRd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(108, 84, 35, 17);
		painel.add(lblLogin);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtLogin = new JTextField();
		txtLogin.setBounds(159, 83, 176, 20);
		painel.add(txtLogin);
		txtLogin.setColumns(20);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(108, 112, 41, 17);
		painel.add(lblSenha);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(159, 111, 176, 20);
		painel.add(txtSenha);
		txtSenha.setColumns(20);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(254, 141, 81, 25);
		painel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(159, 141, 85, 25);
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
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnCadastrar = new JButton("Cadastre - se aqui");
		btnCadastrar.setBounds(225, 190, 166, 25);
		painel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Cadastrar cadastrar = new Tela_Cadastrar();
				cadastrar.Run();
				dispose();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblCadastrar = new JLabel("N�o � cadastrado");
		lblCadastrar.setBounds(103, 194, 112, 17);
		painel.add(lblCadastrar);
		lblCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
	
		getRootPane().setDefaultButton(btnEntrar);
	}
}
