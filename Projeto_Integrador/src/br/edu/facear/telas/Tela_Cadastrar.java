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

public class Tela_Cadastrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtConfirmarSenha;
	private JTextField txtTelefone;
	private JTextField txtIdade;
	private JLabel label;
	private JLabel lblLogo;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public void Run(){
		Tela_Cadastrar tela = new Tela_Cadastrar();
		tela.setSize(1144, 762);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		tela.setExtendedState(MAXIMIZED_BOTH);
	
	}

	public Tela_Cadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(595, 143, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLogin.setBounds(596, 183, 46, 21);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSenha.setBounds(596, 233, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(596, 277, 135, 14);
		contentPane.add(lblConfirmarSenha);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefone.setBounds(595, 323, 89, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdade.setBounds(598, 364, 46, 14);
		contentPane.add(lblIdade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				Jogador jogador = new Jogador();
				String nome = txtNome.getText();
				String login = txtLogin.getText();
				char[] chars = txtSenha.getPassword();
				String senha = String.valueOf(chars);
				String confirma = txtConfirmarSenha.getText();
				int telefone = Integer.parseInt(txtTelefone.getText());
				int idade = Integer.parseInt(txtIdade.getText());
				
				jogador.setNome(nome);
				jogador.setLogin(login);
				jogador.setSenha(senha);
				jogador.setConfirma(confirma);
				jogador.setTelefone(telefone);
				jogador.setIdade(idade);
				if(jogador.Cadastrar().equals("OK")){
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						Tela_Login tela = new Tela_Login();
						tela.Run();
						dispose();
				}else
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCadastrar.setBounds(599, 419, 111, 34);
		contentPane.add(btnCadastrar);
		
		txtNome = new JTextField();
		txtNome.setBounds(594, 162, 234, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(596, 202, 231, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(596, 248, 230, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtConfirmarSenha = new JTextField();
		txtConfirmarSenha.setBounds(597, 292, 231, 20);
		contentPane.add(txtConfirmarSenha);
		txtConfirmarSenha.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(596, 338, 133, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(598, 381, 46, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(275, 69, 46, 14);
		contentPane.add(label);
		
		lblLogo = new JLabel("Quiz by R&D");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogo.setBounds(661, 28, 117, 55);
		contentPane.add(lblLogo);
		
		btnSair = new JButton("Voltar");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSair.setBounds(714, 420, 114, 33);
		contentPane.add(btnSair);
	
	}
}