package br.edu.facear.telas;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lblBemVindo, lblLogo;
	private JButton btnJogar, btnRanking, btnCadastrarPergunta, btnAvaliarPergunta ;

	
	public void Run(){
		Tela_inicial tela = new Tela_inicial();
		tela.setSize(1144, 762);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		tela.setExtendedState(MAXIMIZED_BOTH);
	
	}
	
	public Tela_inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 640);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		painel.add(panel, BorderLayout.CENTER);
		
		lblBemVindo = new JLabel("Seja Bem Vindo");
		lblBemVindo.setBounds(646, 135, 73, 14);
		panel.add(lblBemVindo);
		
		lblLogo = new JLabel("Quiz by R&D");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogo.setBounds(626, 69, 117, 55);
		panel.add(lblLogo);
		
		btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jogo jogo = new Jogo();
				jogo.Run();
	
			}
		});
		btnJogar.setBounds(590, 194, 200, 46);
		panel.add(btnJogar);
		btnJogar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnRanking = new JButton("Ranking");
		btnRanking.setBounds(590, 264, 200, 44);
		panel.add(btnRanking);
		btnRanking.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnCadastrarPergunta = new JButton("Cadastrar perguntas");
		btnCadastrarPergunta.setBounds(590, 335, 200, 44);
		panel.add(btnCadastrarPergunta);
		btnCadastrarPergunta.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnAvaliarPergunta = new JButton("Avaliar Perguntas");
		btnAvaliarPergunta.setBounds(590, 400, 200, 44);
		panel.add(btnAvaliarPergunta);
		btnAvaliarPergunta.setFont(new Font("Arial", Font.PLAIN, 16));
	}
}