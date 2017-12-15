package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Jogador;
import br.edu.facear.classes.Jogo;

public class Tela_Final_Jogo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Jogo jogo;
	private JLabel lblJogador;
	private JLabel lblVencedor;
	private JLabel lblMedalha;
	private JLabel lblVocGanhou;
	private JLabel lblVoceGanhou;
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
					lblJogador.setText(jogador.Ler(jogo.getJogador1().getId()).getLogin().toUpperCase());
				} else if (jogo.getPontoJogador2() > jogo.getPontoJogador1()) {
					lblJogador.setText(jogador.Ler(jogo.getJogador2().getId()).getLogin().toUpperCase());
				} else{
					lblVencedor.setVisible(false);
					lblMedalha.setVisible(false);
					lblVoceGanhou.setVisible(false);
					lblVocGanhou.setVisible(false);
					lblParabens.setVisible(false);
					lblJogador.setText("Empatou!!!");
				}
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
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_inicial t = new Tela_inicial();
				t.Run();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnNewButton.setBounds(708, 399, 185, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Jogar Novamente");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\back.png"));
		btnNewButton_1.setBackground(new Color(75, 0, 130));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Jogo t = new Tela_Jogo();
				t.Run();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnNewButton_1.setBounds(469, 399, 229, 57);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(358, 83, 613, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblJogador = new JLabel("Jogador");
		lblJogador.setBounds(252, 90, 304, 75);
		panel.add(lblJogador);
		lblJogador.setForeground(Color.BLACK);
		lblJogador.setHorizontalAlignment(SwingConstants.LEFT);
		lblJogador.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		
		lblMedalha = new JLabel("");
		lblMedalha.setBounds(138, 98, 64, 64);
		panel.add(lblMedalha);
		lblMedalha.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\medal.png"));
		
		lblVencedor = new JLabel("Parab\u00E9ns");
		lblVencedor.setBounds(52, 0, 532, 67);
		panel.add(lblVencedor);
		lblVencedor.setForeground(Color.BLACK);
		lblVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVencedor.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		
		lblVocGanhou = new JLabel("Voc\u00EA ganhou!!!");
		lblVocGanhou.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocGanhou.setForeground(Color.BLACK);
		lblVocGanhou.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblVocGanhou.setBounds(52, 198, 532, 67);
		panel.add(lblVocGanhou);
		
		lblVoceGanhou = new JLabel("Voc\u00EA ganhou!!!");
		lblVoceGanhou.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoceGanhou.setForeground(Color.YELLOW);
		lblVoceGanhou.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblVoceGanhou.setBounds(49, 197, 532, 67);
		panel.add(lblVoceGanhou);
		
		lblParabens = new JLabel("Parab\u00E9ns");
		lblParabens.setHorizontalAlignment(SwingConstants.CENTER);
		lblParabens.setForeground(Color.YELLOW);
		lblParabens.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblParabens.setBounds(49, 0, 532, 67);
		panel.add(lblParabens);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(-36, -32, 2534, 768);
		contentPane.add(lblFundo);
		
		FimDeJogo(id);
		
	}
}
