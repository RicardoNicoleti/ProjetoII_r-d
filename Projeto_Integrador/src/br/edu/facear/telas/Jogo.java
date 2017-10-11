package br.edu.facear.telas;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Jogo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPontos, lblHorcrux, lblTempo, lblTempo1, lblLogo, lblJogador, lblJogador2, lblJogador_1, lblJogador_2, lblImg;
	private JRadioButton rdbtnAlternativa_1, rdbtnAlternativa_2, rdbtnAlternativa_3, rdbtnAlternativa_4;

	public void Run(){
		Jogo tela = new Jogo();
		tela.setSize(1144, 762);
		tela.setVisible(true);
		tela.setExtendedState(MAXIMIZED_BOTH);
		tela.setLocationRelativeTo(null);

	}
	public Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1133, 718);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(217, 55, 44, 17);
		panel.add(lblPontos);
		lblPontos.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblHorcrux = new JLabel("Horcrux");
		lblHorcrux.setBounds(217, 86, 48, 17);
		panel.add(lblHorcrux);
		lblHorcrux.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblTempo = new JLabel("Tempo:");
		lblTempo.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTempo.setBounds(616, 101, 75, 34);
		panel.add(lblTempo);
		
		lblTempo1 = new JLabel("00:20");
		lblTempo1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTempo1.setBounds(690, 111, 56, 17);
		panel.add(lblTempo1);
		
		lblLogo = new JLabel("Quiz by R&D");
		lblLogo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLogo.setBounds(521, 11, 298, 25);
		panel.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblJogador = new JLabel("Jogador 1");
		lblJogador.setIcon(new ImageIcon("C:\\Users\\ricar\\Downloads\\if_user_male_172625.png"));
		lblJogador.setBounds(230, 239, 135, 112);
		panel.add(lblJogador);
		
		lblJogador2 = new JLabel("Jogador 2");
		lblJogador2.setIcon(new ImageIcon("C:\\Users\\ricar\\Downloads\\if_user_female_172621.png"));
		lblJogador2.setBounds(955, 239, 120, 112);
		panel.add(lblJogador2);
		
		rdbtnAlternativa_1 = new JRadioButton("Alternativa 1");
		rdbtnAlternativa_1.setSelected(true);
		rdbtnAlternativa_1.setBounds(612, 340, 109, 23);
		panel.add(rdbtnAlternativa_1);
		
		rdbtnAlternativa_2 = new JRadioButton("Alternativa 2");
		rdbtnAlternativa_2.setBounds(612, 366, 109, 23);
		panel.add(rdbtnAlternativa_2);
		
		rdbtnAlternativa_3 = new JRadioButton("Alternativa 3");
		rdbtnAlternativa_3.setBounds(612, 392, 109, 23);
		panel.add(rdbtnAlternativa_3);
		
		rdbtnAlternativa_4 = new JRadioButton("Alternativa 4");
		rdbtnAlternativa_4.setBounds(612, 418, 109, 23);
		panel.add(rdbtnAlternativa_4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnAlternativa_1);
		bg.add(rdbtnAlternativa_2);
		bg.add(rdbtnAlternativa_3);
		bg.add(rdbtnAlternativa_4);
		
		JLabel lblPergunta = new JLabel("1 - Pergunta");
		lblPergunta.setBounds(514, 239, 127, 14);
		panel.add(lblPergunta);
		
		JButton btnPedirAjuda = new JButton("Pedir Ajuda");
		btnPedirAjuda.setBounds(513, 510, 105, 38);
		panel.add(btnPedirAjuda);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(746, 510, 103, 38);
		panel.add(btnSair);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(628, 510, 107, 38);
		panel.add(btnConfirmar);
		
		JLabel lblPontoGanho = new JLabel("0");
		lblPontoGanho.setBounds(284, 57, 46, 14);
		panel.add(lblPontoGanho);
		
		JLabel lblPontoHorc = new JLabel("0");
		lblPontoHorc.setBounds(284, 88, 46, 14);
		panel.add(lblPontoHorc);
		
		lblJogador_1 = new JLabel("Jogador 1");
		lblJogador_1.setBounds(262, 362, 75, 14);
		panel.add(lblJogador_1);
		
		lblJogador_2 = new JLabel("Jogador 2");
		lblJogador_2.setBounds(995, 362, 62, 14);
		panel.add(lblJogador_2);
		
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon("C:\\Users\\ricar\\Downloads\\if_access-time_326483.png"));
		lblImg.setBounds(543, 86, 70, 64);
		panel.add(lblImg);
	}
}
