package br.edu.facear.telas;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Jogador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtLogin;
	private JTextField txtSenha;

	
	public void Run(){
		Login tela = new Login();
		tela.setSize(437, 302);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
		
		JPanel panel_4 = new JPanel();
		painel.add(panel_4);
		
		JLabel lblQuizByRd = new JLabel("Quiz by R&D");
		panel_4.add(lblQuizByRd);
		lblQuizByRd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		painel.add(panel);
		
		JLabel lblLogin = new JLabel("Login");
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtLogin = new JTextField();
		panel.add(txtLogin);
		txtLogin.setColumns(20);
		
		JPanel panel_1 = new JPanel();
		painel.add(panel_1);
		
		JLabel lblSenha = new JLabel("Senha");
		panel_1.add(lblSenha);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtSenha = new JPasswordField();
		panel_1.add(txtSenha);
		txtSenha.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		painel.add(panel_2);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jogador jogador = new Jogador();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				jogador.setLogin(login);
				jogador.setSenha(senha);
				if(jogador.Logar().equals("OK")){
					Tela_inicial tela = new Tela_inicial();
					tela.Run();
				}
				else
					JOptionPane.showMessageDialog(null,"Login ou senha Inv�lido");
						
			}
		});
		panel_2.add(btnEntrar);
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		panel_2.add(btnSair);
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JPanel panel_3 = new JPanel();
		painel.add(panel_3);
		
		JLabel lblCadastrar = new JLabel("N�o � cadastrado");
		panel_3.add(lblCadastrar);
		lblCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnCadastrar = new JButton("Cadastre - se aqui");
		panel_3.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
	}
}