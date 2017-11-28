package br.edu.facear.telas;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Jogador;
import br.edu.facear.classes.Jogo;
import br.edu.facear.classes.Rodada;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Tela_Final_Jogo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Jogo jogo;
	private JLabel lblParabens;
	
	public void Run(int id) {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);

	}
	
	public void FimDeJogo(int id) {
		jogo = new Jogo();
		List<Jogo> lista = jogo.Ler();
		Jogador jogador = new Jogador();
		for (Jogo jogo : lista) {
			if (jogo.getId() == id) {
				if (jogo.getPontoJogador1() > jogo.getPontoJogador2()) {
					lblParabens.setText("Vencedor " + jogador.Ler(jogo.getJogador1().getId()).getLogin().toUpperCase());
				} else if (jogo.getPontoJogador2() > jogo.getPontoJogador1()) {
					lblParabens.setText("Vencedor " + jogador.Ler(jogo.getJogador2().getId()).getLogin().toUpperCase());
				} else
					lblParabens.setText("Empatou!!!");
			}
		}
	}
	
	public Tela_Final_Jogo(int id) {
		setTitle("Fim de Jogo\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblParabens = new JLabel("Parabens");
		lblParabens.setHorizontalAlignment(SwingConstants.CENTER);
		lblParabens.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblParabens.setBounds(477, 88, 414, 164);
		contentPane.add(lblParabens);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_inicial t = new Tela_inicial();
				t.Run();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(704, 395, 165, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Jogar Novamente");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Jogo t = new Tela_Jogo();
				t.Run();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(523, 394, 156, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Fundo.png"));
		lblFundo.setBounds(-36, -32, 2534, 768);
		contentPane.add(lblFundo);
		
		FimDeJogo(id);
		
	}
}