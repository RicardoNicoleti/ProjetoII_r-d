package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Jogador;
import br.edu.facear.classes.Jogo;

public class Tela_Jogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private String resposta;
	private JPanel contentPane;
	private JLabel lblPontos, lblHorcrux, lblTempo, lblTempo1, lblLogo, lblJogador, lblJogador2, lblJogador_1,
			lblJogador_2, lblImg, lblPergunta, lblVez, lblPontoGanho;
	private JRadioButton rdbtnAlternativa_1, rdbtnAlternativa_2, rdbtnAlternativa_3, rdbtnAlternativa_4;
	private JButton btnConfirmar, btnPedirAjuda, btnSair;
	private Thread conta;
	private Jogo jogo;
	private ButtonGroup bg;
	private JLabel lblRodada;

	public void Run() {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	public void ComecarJogo() {
		jogo = new Jogo();

		buscarJogos();

//		jogo.Jogar();

//		
//		String ponto = Integer.toString(jogo.getJogador1().getPontos());
//
//		lblPontoGanho.setText(ponto);

		if (!jogo.isJogoAnterior()){
			jogo.EscolherAdversario();
			
			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());

			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());
			jogo.setJogadorVez(jogo.getJogador1());
		
			lblJogador_1.setForeground(Color.red);
			lblJogador_2.setForeground(Color.black);
			
			carregarPergunta();
			
		}else
			perguntaJogoAnterior();
		
		jogo.SalvarJogo();

		}

	public void Contar() {
		conta = new Thread() {
			public void run() {
				int segundos = 59;
				int i;
				int t = 2;
				try {
					while (t != -1) {
						for (i = segundos; i >= 0; i--) {
							lblTempo1.setText(String.format("%02d:%02d", t, i));
							Thread.sleep(1000); // 1 segundo
						}
						t--;
					}
				} catch (InterruptedException e) {
					// System.out.println("Erro ao iniciar " + e);
				}
			}
		};
		conta.start();
	}

	public void verificarResposta() {
		if (rdbtnAlternativa_1.isSelected())
			resposta = rdbtnAlternativa_1.getText();
		else if (rdbtnAlternativa_2.isSelected())
			resposta = rdbtnAlternativa_2.getText();
		else if (rdbtnAlternativa_3.isSelected())
			resposta = rdbtnAlternativa_3.getText();
		else if (rdbtnAlternativa_4.isSelected())
			resposta = rdbtnAlternativa_4.getText();

		String retirarTag = "<[^>]+>";
		String res = resposta.replaceAll(retirarTag, "");

		if (jogo.getPergunta().ValidarPergunta(res).equals("OK")) {
			JOptionPane.showMessageDialog(null, "correta");
			jogo.PerguntaFeitas();
		} else {
			JOptionPane.showMessageDialog(null, "errada");
			if (jogo.getJogadorVez().getId() == jogo.getJogador1().getId()) {
				jogo.setJogadorVez(jogo.getJogador2());
				lblJogador_1.setForeground(Color.black);
				lblJogador_2.setForeground(Color.red);
				lblVez.setText("JOGADOR 2");
				jogo.PerguntaFeitas();
			} else {
				jogo.setJogadorVez(jogo.getJogador1());
				lblJogador_2.setForeground(Color.black);
				lblJogador_1.setForeground(Color.red);
				lblVez.setText("JOGADOR 1");
				jogo.PerguntaFeitas();
				carregarPergunta();

			}
		}
	}

	public void buscarJogos() {
		jogo = new Jogo();
		List<Jogo> lista = jogo.Ler();
		for (Jogo jogo2 : lista) {
			if (Jogador.getInstance().getId() == jogo2.getJogador1().getId()) {
				if (!jogo2.isFinalizado()) {
					int result = JOptionPane.showConfirmDialog(null, "Deseja Retomar o jogo anterior ? ", "Sim",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						System.out.println("Jogo anterior");
						jogo.setId(jogo2.getId());
						jogo.CarregarJogo();
						jogo.setJogoAnterior(true);
					} else {
						System.out.println("Novo Jogo");
						jogo.setId(jogo2.getId());
						jogo.FinalizarJogo();
					}
				}
			}
		}
	}

	public void perguntaJogoAnterior() {
		
		jogo.CarregarJogo();
		
		if (jogo.getJogadorVez().getId() == Jogador.getInstance().getId()) {
			jogo.setJogadorVez(jogo.getJogador1());
			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());
			lblJogador_2.setForeground(Color.red);
			lblJogador_1.setForeground(Color.black);
			lblVez.setText("JOGADOR 1");
			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());
			lblJogador_1.setForeground(Color.red);
			lblJogador_2.setForeground(Color.black);
			lblVez.setText("JOGADOR 2");
			System.out.println(jogo.getJogadorVez().getId()); 
		} else {
			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());
			jogo.setJogadorVez(jogo.getJogador2());
			lblJogador_1.setForeground(Color.black);
			lblJogador_2.setForeground(Color.red);
			lblVez.setText("JOGADOR 2");
			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());
			lblJogador_2.setForeground(Color.red);
			lblJogador_1.setForeground(Color.black);
			lblVez.setText("JOGADOR 1");
			System.out.println(jogo.getJogadorVez().getId()); 
		
		}
		
		lblPergunta.setText("<html><b>" + jogo.getPergunta().getPergunta() + "<br></html>");

		List<String> escolhas = Arrays.asList(jogo.getPergunta().getAlternativas1(),
				jogo.getPergunta().getAlternativas2(), jogo.getPergunta().getAlternativas3(),
				jogo.getPergunta().getCorreta());

		Collections.shuffle(escolhas);

		rdbtnAlternativa_1.setText("<html><b>" + escolhas.get(0) + "<br></html>");
		rdbtnAlternativa_2.setText("<html><b>" + escolhas.get(1) + "<br></html>");
		rdbtnAlternativa_3.setText("<html><b>" + escolhas.get(2) + "<br></html>");
		rdbtnAlternativa_4.setText("<html><b>" + escolhas.get(3) + "<br></html>");
						
	}

	public void carregarPergunta() {

		jogo.EscolherPergunta();

		lblPergunta.setText("<html><b>" + jogo.getPergunta().getPergunta() + "<br></html>");

		List<String> escolhas = Arrays.asList(jogo.getPergunta().getAlternativas1(),
				jogo.getPergunta().getAlternativas2(), jogo.getPergunta().getAlternativas3(),
				jogo.getPergunta().getCorreta());

		Collections.shuffle(escolhas);

		rdbtnAlternativa_1.setText("<html><b>" + escolhas.get(0) + "<br></html>");
		rdbtnAlternativa_2.setText("<html><b>" + escolhas.get(1) + "<br></html>");
		rdbtnAlternativa_3.setText("<html><b>" + escolhas.get(2) + "<br></html>");
		rdbtnAlternativa_4.setText("<html><b>" + escolhas.get(3) + "<br></html>");

	}

	public Tela_Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(60, 11, 1133, 718);
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
		lblTempo1.setBounds(689, 107, 171, 24);
		panel.add(lblTempo1);

		lblLogo = new JLabel("Quiz by R&D");
		lblLogo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLogo.setBounds(521, 11, 298, 25);
		panel.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

		lblJogador = new JLabel();
		lblJogador.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_user_male_172625.png"));
		lblJogador.setBounds(230, 239, 135, 112);
		panel.add(lblJogador);

		lblJogador2 = new JLabel("Jogador 2");
		lblJogador2.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_user_female_172621.png"));
		lblJogador2.setBounds(955, 239, 120, 112);
		panel.add(lblJogador2);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_inicial tela = new Tela_inicial();
				tela.Run();
				conta.interrupt();
				dispose();
			}
		});
		btnSair.setBounds(746, 510, 103, 38);
		panel.add(btnSair);

		lblPergunta = new JLabel();
		lblPergunta.setBounds(420, 178, 469, 121);
		panel.add(lblPergunta);

		rdbtnAlternativa_1 = new JRadioButton();
		rdbtnAlternativa_1.setBounds(420, 304, 497, 39);
		panel.add(rdbtnAlternativa_1);

		rdbtnAlternativa_2 = new JRadioButton();
		rdbtnAlternativa_2.setBounds(420, 346, 497, 34);
		panel.add(rdbtnAlternativa_2);

		rdbtnAlternativa_3 = new JRadioButton();
		rdbtnAlternativa_3.setBounds(420, 383, 496, 34);
		panel.add(rdbtnAlternativa_3);

		rdbtnAlternativa_4 = new JRadioButton();
		rdbtnAlternativa_4.setBounds(420, 420, 497, 34);
		panel.add(rdbtnAlternativa_4);

		bg = new ButtonGroup();
		bg.add(rdbtnAlternativa_1);
		bg.add(rdbtnAlternativa_2);
		bg.add(rdbtnAlternativa_3);
		bg.add(rdbtnAlternativa_4);

		lblPontoGanho = new JLabel();
		lblPontoGanho.setBounds(284, 57, 46, 14);
		panel.add(lblPontoGanho);

		JLabel lblPontoHorc = new JLabel("0");
		lblPontoHorc.setBounds(284, 88, 46, 14);
		panel.add(lblPontoHorc);

		lblJogador_1 = new JLabel();
		lblJogador_1.setBounds(262, 362, 75, 14);
		panel.add(lblJogador_1);

		lblJogador_2 = new JLabel();
		lblJogador_2.setBounds(995, 362, 62, 14);
		panel.add(lblJogador_2);

		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon("C:\\Users\\ricar\\Downloads\\if_access-time_326483.png"));
		lblImg.setBounds(543, 86, 70, 64);
		panel.add(lblImg);

		btnPedirAjuda = new JButton("Pedir Ajuda");
		btnPedirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnPedirAjuda.setBounds(513, 510, 105, 38);
		panel.add(btnPedirAjuda);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificarResposta();
				carregarPergunta();
				jogo.SalvarRodada();
				bg.clearSelection();
				conta.interrupt();
				Contar();

			}
		});

		lblRodada = new JLabel("rodada");
		lblRodada.setBounds(705, 153, 46, 14);
		panel.add(lblRodada);

		btnConfirmar.setBounds(628, 510, 107, 38);
		panel.add(btnConfirmar);

		lblVez = new JLabel("Vez");
		lblVez.setBounds(616, 153, 62, 14);
		panel.add(lblVez);

		lblVez.setText("JOGADOR 1");
		ComecarJogo();
		Contar();

	}
}
