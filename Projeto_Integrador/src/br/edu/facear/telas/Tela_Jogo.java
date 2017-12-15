package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import br.edu.facear.classes.Rodada;

public class Tela_Jogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private String resposta;
	private JPanel contentPane;
	private JLabel lblPontos1, lblHorcrux1, lblTempo, lblTempo1, lblJogador, lblJogador2, lblJogador_1, lblJogador_2,
			lblImg, lblPergunta, lblCategoria, lblPontos2, lblHorcrux2, lblPontoHorc2, lblPont1, lblPont2,
			lblPontoHorc1;
	private JRadioButton rdbtnAlternativa_1, rdbtnAlternativa_2, rdbtnAlternativa_3, rdbtnAlternativa_4;
	private JButton btnConfirmar, btnPedirAjuda, btnSair;
	private Thread contar;
	private Jogo jogo;
	private boolean fimDeJogo;
	private ButtonGroup bg;
	private JLabel lblRodada;
	private JLabel lblLogo;
	private JLabel lblAcertos1;
	private JLabel lblAcerto1;
	private JLabel lblAcertos2;
	private JLabel lblAcerto2;
	private JPanel pnlPerguntas;
	private JPanel pnlJogador1;
	private JPanel pnlJogador2;

	public void Run() {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
	}

	public void atualizarRodada() {
		List<Jogo> lista = jogo.Ler();
		for (Jogo jogo : lista) {
			if (this.jogo.getId() == jogo.getId()) {
				for (Rodada rodada : jogo.getRodada()) {
					if (jogo.getId() == rodada.getJogo().getId()) {
						lblRodada.setText(String.valueOf(rodada.getIdRodada() + 1 + "/15"));
						if (this.jogo.getId() == rodada.getJogo().getId()
								&& Jogador.getInstance().getId() == rodada.getJogo().getJogador1().getId()
								&& rodada.getIdRodada() == 15) {
							contar.interrupt();
							jogo.setId(this.jogo.getId());
							this.jogo.FinalizarJogo();
							fimDeJogo = true;
							Tela_Final_Jogo t = new Tela_Final_Jogo(this.jogo.getId());
							t.Run(this.jogo.getId());
							dispose();
						}
					}
				}
			}
		}
	}

	public void ComecarJogo() {
		jogo = new Jogo();

		BuscarJogos();

		if (!jogo.isJogoAnterior()) {

			Contar();

			jogo.EscolherAdversario();

			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(jogo.getJogador1().getImagem()).getImage()
					.getScaledInstance(128, 128, Image.SCALE_DEFAULT));
			lblJogador.setIcon(imageIcon);

			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(jogo.getJogador2().getImagem()).getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
			lblJogador2.setIcon(imageIcon2);

			jogo.setJogadorVez(jogo.getJogador1());

			pnlJogador1.setVisible(true);

			lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
			lblPontoHorc1.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
			lblAcerto1.setText(String.valueOf(jogo.getPontoJogador1()));

			pnlJogador2.setVisible(false);

			CarregarPergunta();

		} else {

			Contar();
			PerguntaJogoAnterior();
		}

		jogo.SalvarJogo();

		atualizarRodada();

	}

	public void Contar() {
		contar = new Thread() {
			public void run() {
				int segundos = 20;
				int i;
				int t = 0;
				try {
					while (t != -1) {
						for (i = segundos; i >= 0; i--) {
							lblTempo1.setText(String.format("%02d:%02d", t, i));
							Thread.sleep(1000); // 1 segundo
							if (i <= 5) {
								lblTempo1.setForeground(Color.RED);
							} else
								lblTempo1.setForeground(Color.BLACK);
						}
						t--;
						if (t == -1 && !fimDeJogo) {
							JOptionPane.showMessageDialog(null, "Acabou seu tempo!!!");
							if (jogo.getJogadorVez().getId() == jogo.getJogador1().getId()) {
								jogo.setJogadorVez(jogo.getJogador2());

								pnlJogador2.setVisible(true);

								lblPont2.setText(String.valueOf(jogo.getJogador2().getPontos()));
								lblPontoHorc2.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
								lblAcerto2.setText(String.valueOf(jogo.getPontoJogador2()));

								pnlJogador1.setVisible(false);

								jogo.PerguntasFeitas();
								CarregarPergunta();
								jogo.SalvarRodada();
								atualizarRodada();
							} else {
								jogo.setJogadorVez(jogo.getJogador1());

								pnlJogador1.setVisible(true);

								lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
								lblPontoHorc1.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
								lblAcerto1.setText(String.valueOf(jogo.getPontoJogador1()));

								pnlJogador1.setVisible(false);

								jogo.PerguntasFeitas();
								CarregarPergunta();
								jogo.SalvarRodada();
								atualizarRodada();

							}
							contar.interrupt();
							if (!fimDeJogo)
								Contar();
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			}
		};
		contar.start();
	}

	public void VerificarResposta() {
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
			JOptionPane.showMessageDialog(null, "Parab�ns voc� acertou!!!");
			jogo.AtualizarPontos();
			if (jogo.getJogadorVez().getId() == jogo.getJogador1().getId()) {
				jogo.setJogadorVez(jogo.getJogadorVez());
				lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
				lblPontoHorc1.setText(String.valueOf(jogo.getJogador1().getHorcrux()));
				jogo.setPontoJogador1(jogo.getPontoJogador1() + 1);
				lblAcerto1.setText(String.valueOf(jogo.getPontoJogador1()));
			} else {
				jogo.setJogadorVez(jogo.getJogadorVez());
				lblPont2.setText(String.valueOf(jogo.getJogador2().getPontos()));
				lblPontoHorc2.setText(String.valueOf(jogo.getJogador2().getHorcrux()));
				jogo.setPontoJogador2(jogo.getPontoJogador2() + 1);
				lblAcerto2.setText(String.valueOf(jogo.getPontoJogador2()));
			}
			rdbtnAlternativa_1.setVisible(true);
			rdbtnAlternativa_2.setVisible(true);
			rdbtnAlternativa_3.setVisible(true);
			rdbtnAlternativa_4.setVisible(true);
			btnPedirAjuda.setEnabled(true);
			jogo.PerguntasFeitas();
			atualizarRodada();
		} else {
			JOptionPane.showMessageDialog(null, "Resposta Errada =(");
			if (jogo.getJogadorVez().getId() == jogo.getJogador1().getId()) {
				jogo.setJogadorVez(jogo.getJogador2());

				pnlJogador2.setVisible(true);

				lblPont2.setText(String.valueOf(jogo.getJogador2().getPontos()));
				lblPontoHorc2.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
				lblAcerto2.setText(String.valueOf(jogo.getPontoJogador2()));

				pnlJogador1.setVisible(false);

				jogo.PerguntasFeitas();
				CarregarPergunta();
				atualizarRodada();
			} else {
				jogo.setJogadorVez(jogo.getJogador1());

				pnlJogador1.setVisible(true);

				lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
				lblPontoHorc1.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
				lblAcerto1.setText(String.valueOf(jogo.getPontoJogador1()));

				pnlJogador2.setVisible(false);

				jogo.PerguntasFeitas();
				CarregarPergunta();
				atualizarRodada();

			}

			rdbtnAlternativa_1.setVisible(true);
			rdbtnAlternativa_2.setVisible(true);
			rdbtnAlternativa_3.setVisible(true);
			rdbtnAlternativa_4.setVisible(true);
			btnPedirAjuda.setEnabled(true);

		}
	}

	public void BuscarJogos() {
		jogo = new Jogo();
		List<Jogo> lista = jogo.Ler();
		for (Jogo jogo2 : lista) {
			if (Jogador.getInstance().getId() == jogo2.getJogador1().getId()) {
				if (!jogo2.isFinalizado()) {
					int result = JOptionPane.showConfirmDialog(null, "Deseja Continuar o jogo anterior ? ", "Sim",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						jogo.setId(jogo2.getId());
						jogo.CarregarJogo();
						jogo.setJogoAnterior(true);
					} else {
						jogo.setId(jogo2.getId());
						jogo.FinalizarJogo();
					}
				}
			}
		}
	}

	public void PerguntaJogoAnterior() {

		jogo.CarregarJogo();
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(jogo.getJogador1().getImagem()).getImage()
				.getScaledInstance(128, 128, Image.SCALE_DEFAULT));
		lblJogador.setIcon(imageIcon);
		
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(jogo.getJogador2().getImagem()).getImage()
				.getScaledInstance(128, 128, Image.SCALE_DEFAULT));
		lblJogador2.setIcon(imageIcon2);
		
		if (jogo.getJogadorVez().getId() == Jogador.getInstance().getId()) {
			jogo.setJogadorVez(jogo.getJogador1());

			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());
			
			pnlJogador1.setVisible(true);
			
			lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
			lblPontoHorc1.setText(String.valueOf(jogo.getJogador1().getHorcrux()));
			lblAcerto1.setText(String.valueOf(jogo.getPontoJogador1()));

			pnlJogador2.setVisible(false);

			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());

		} else {
			jogo.setJogadorVez(jogo.getJogador2());
			lblJogador_2.setText(jogo.getJogador2().getLogin().toUpperCase());

			pnlJogador2.setVisible(true);

			lblPont2.setText(String.valueOf(jogo.getJogador2().getPontos()));
			lblPontoHorc2.setText(String.valueOf(jogo.getJogador2().getHorcrux()));
			lblAcerto2.setText(String.valueOf(jogo.getPontoJogador2()));

			pnlJogador1.setVisible(false);

			lblJogador_1.setText(jogo.getJogador1().getLogin().toUpperCase());

		}

		lblCategoria.setText(jogo.getPergunta().getCategoria().getCategoria());

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

	public void CarregarPergunta() {

		jogo.EscolherPergunta();

		lblCategoria.setText(jogo.getPergunta().getCategoria().getCategoria());

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
		setBounds(100, 100, 1263, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTempo = new JLabel("Tempo:");
		lblTempo.setForeground(Color.BLACK);
		lblTempo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblTempo.setBounds(563, 123, 101, 34);
		contentPane.add(lblTempo);

		lblTempo1 = new JLabel("00:20");
		lblTempo1.setForeground(Color.BLACK);
		lblTempo1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblTempo1.setBounds(662, 128, 171, 24);
		contentPane.add(lblTempo1);

		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnSair.setBackground(new Color(75, 0, 130));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contar.interrupt();
				Tela_inicial tela = new Tela_inicial();
				tela.Run();
				dispose();
			}
		});
		btnSair.setBounds(806, 602, 128, 57);
		contentPane.add(btnSair);

		bg = new ButtonGroup();

		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon("C:\\Users\\ricar\\Downloads\\if_access-time_326483.png"));
		lblImg.setBounds(489, 103, 70, 64);
		contentPane.add(lblImg);

		btnPedirAjuda = new JButton("Pedir Ajuda");
		btnPedirAjuda.setForeground(new Color(255, 255, 255));
		btnPedirAjuda.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\help.png"));
		btnPedirAjuda.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnPedirAjuda.setBackground(new Color(75, 0, 130));
		btnPedirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jogo.getJogadorVez().getHorcrux() != 0) {
					String r1 = rdbtnAlternativa_1.getText();
					String r2 = rdbtnAlternativa_2.getText();
					String r3 = rdbtnAlternativa_3.getText();
					String r4 = rdbtnAlternativa_4.getText();

					String retirarTag1 = "<[^>]+>";
					String res1 = r1.replaceAll(retirarTag1, "");

					String retirarTag2 = "<[^>]+>";
					String res2 = r2.replaceAll(retirarTag2, "");

					String retirarTag3 = "<[^>]+>";
					String res3 = r3.replaceAll(retirarTag3, "");

					String retirarTag4 = "<[^>]+>";
					String res4 = r4.replaceAll(retirarTag4, "");

					int cont = 0;
					while (cont < 2) {
						if (cont < 2 && jogo.getPergunta().ValidarPergunta(res1).equals("ERRO")) {
							rdbtnAlternativa_1.setVisible(false);
						} else {
							rdbtnAlternativa_1.setVisible(true);
							cont++;
						}
						if (cont == 1 && cont < 2 && jogo.getPergunta().ValidarPergunta(res2).equals("ERRO")) {
							rdbtnAlternativa_2.setVisible(false);

						} else {
							rdbtnAlternativa_2.setVisible(true);
						}
						if (cont < 2 && jogo.getPergunta().ValidarPergunta(res3).equals("ERRO")) {
							rdbtnAlternativa_3.setVisible(false);
							cont++;
						} else {
							rdbtnAlternativa_3.setVisible(true);
							cont++;
						}
						if (cont < 2 && jogo.getPergunta().ValidarPergunta(res4).equals("ERRO")) {
							rdbtnAlternativa_4.setVisible(false);

						} else {
							rdbtnAlternativa_4.setVisible(true);
							cont++;
						}
					}

					btnPedirAjuda.setEnabled(false);

					jogo.PedirAjuda();

					if (jogo.getJogadorVez().getId() == jogo.getJogador1().getId()) {
						jogo.setJogadorVez(jogo.getJogadorVez());
						lblPont1.setText(String.valueOf(jogo.getJogador1().getPontos()));
						lblPontoHorc1.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
					} else {
						jogo.setJogadorVez(jogo.getJogadorVez());
						lblPont2.setText(String.valueOf(jogo.getJogador2().getPontos()));
						lblPontoHorc2.setText(String.valueOf(jogo.getJogadorVez().getHorcrux()));
					}

				} else
					JOptionPane.showMessageDialog(null, "Voc� n�o tem Horcrux Sufici�ntes");
			}
		});
		btnPedirAjuda.setBounds(372, 598, 171, 55);
		contentPane.add(btnPedirAjuda);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_check-circle_326571.png"));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnConfirmar.setBackground(new Color(75, 0, 130));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contar.interrupt();
				VerificarResposta();
				CarregarPergunta();
				jogo.SalvarRodada();
				bg.clearSelection();
				atualizarRodada();
				Contar();
			}
		});

		lblRodada = new JLabel("Rodada: 0/15");
		lblRodada.setForeground(Color.BLACK);
		lblRodada.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblRodada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRodada.setBounds(543, 167, 204, 24);
		contentPane.add(lblRodada);

		btnConfirmar.setBounds(551, 598, 161, 55);
		contentPane.add(btnConfirmar);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		lblLogo.setFont(new Font("Arial", Font.PLAIN, 40));
		lblLogo.setBounds(471, -18, 300, 142);
		contentPane.add(lblLogo);

		pnlPerguntas = new JPanel();
		pnlPerguntas.setBackground(new Color(147, 112, 219));
		pnlPerguntas.setBounds(372, 196, 560, 395);
		contentPane.add(pnlPerguntas);
		pnlPerguntas.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 54, 519, 110);
		pnlPerguntas.add(panel);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		lblPergunta = new JLabel();
		lblPergunta.setForeground(Color.BLACK);
		lblPergunta.setBounds(2, 4, 512, 104);
		panel.add(lblPergunta);
		lblPergunta.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));

		rdbtnAlternativa_1 = new JRadioButton();
		rdbtnAlternativa_1.setBounds(22, 176, 519, 45);
		pnlPerguntas.add(rdbtnAlternativa_1);
		rdbtnAlternativa_1.setForeground(Color.BLACK);
		rdbtnAlternativa_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnAlternativa_1.setBackground(Color.WHITE);
		bg.add(rdbtnAlternativa_1);

		rdbtnAlternativa_2 = new JRadioButton();
		rdbtnAlternativa_2.setBounds(21, 231, 519, 45);
		pnlPerguntas.add(rdbtnAlternativa_2);
		rdbtnAlternativa_2.setForeground(Color.BLACK);
		rdbtnAlternativa_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnAlternativa_2.setBackground(Color.WHITE);
		bg.add(rdbtnAlternativa_2);

		rdbtnAlternativa_3 = new JRadioButton();
		rdbtnAlternativa_3.setBounds(21, 284, 519, 45);
		pnlPerguntas.add(rdbtnAlternativa_3);
		rdbtnAlternativa_3.setForeground(Color.BLACK);
		rdbtnAlternativa_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnAlternativa_3.setBackground(Color.WHITE);
		bg.add(rdbtnAlternativa_3);

		rdbtnAlternativa_4 = new JRadioButton();
		rdbtnAlternativa_4.setBounds(21, 339, 519, 45);
		pnlPerguntas.add(rdbtnAlternativa_4);
		rdbtnAlternativa_4.setForeground(Color.BLACK);
		rdbtnAlternativa_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rdbtnAlternativa_4.setBackground(Color.WHITE);
		bg.add(rdbtnAlternativa_4);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setBounds(185, 6, 200, 32);
		pnlPerguntas.add(lblCategoria);
		lblCategoria.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 30));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);

		pnlJogador1 = new JPanel();
		pnlJogador1.setBackground(new Color(147, 112, 219));
		pnlJogador1.setBounds(158, 195, 180, 240);
		contentPane.add(pnlJogador1);
		pnlJogador1.setLayout(null);

		lblJogador = new JLabel();
		lblJogador.setBounds(32, 11, 128, 128);
		pnlJogador1.add(lblJogador);
		lblJogador.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\user-image-with-black-background.png"));

		lblPontos1 = new JLabel("Pontos");
		lblPontos1.setForeground(Color.BLACK);
		lblPontos1.setBounds(46, 149, 70, 17);
		pnlJogador1.add(lblPontos1);
		lblPontos1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblPont1 = new JLabel("0");
		lblPont1.setForeground(Color.BLACK);
		lblPont1.setBounds(114, 149, 46, 14);
		pnlJogador1.add(lblPont1);
		lblPont1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblHorcrux1 = new JLabel("Horcrux");
		lblHorcrux1.setForeground(Color.BLACK);
		lblHorcrux1.setBounds(45, 179, 48, 17);
		pnlJogador1.add(lblHorcrux1);
		lblHorcrux1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblPontoHorc1 = new JLabel("0");
		lblPontoHorc1.setForeground(Color.BLACK);
		lblPontoHorc1.setBounds(113, 181, 46, 14);
		pnlJogador1.add(lblPontoHorc1);
		lblPontoHorc1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblAcertos1 = new JLabel("Acertos");
		lblAcertos1.setForeground(Color.BLACK);
		lblAcertos1.setBounds(47, 209, 46, 14);
		pnlJogador1.add(lblAcertos1);
		lblAcertos1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblAcerto1 = new JLabel("0");
		lblAcerto1.setForeground(Color.BLACK);
		lblAcerto1.setBounds(113, 207, 46, 14);
		pnlJogador1.add(lblAcerto1);
		lblAcerto1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblJogador_1 = new JLabel();
		lblJogador_1.setForeground(Color.BLACK);
		lblJogador_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblJogador_1.setBounds(1, 111, 180, 24);
		pnlJogador1.add(lblJogador_1);
		lblJogador_1.setHorizontalAlignment(SwingConstants.CENTER);

		pnlJogador2 = new JPanel();
		pnlJogador2.setBackground(new Color(147, 112, 219));
		pnlJogador2.setBounds(963, 194, 180, 240);
		contentPane.add(pnlJogador2);
		pnlJogador2.setLayout(null);

		lblJogador2 = new JLabel("");
		lblJogador2.setBounds(22, 3, 128, 128);
		pnlJogador2.add(lblJogador2);
		lblJogador2.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\user-image-with-black-background.png"));

		lblPontos2 = new JLabel("Pontos");
		lblPontos2.setForeground(Color.BLACK);
		lblPontos2.setBounds(45, 142, 44, 17);
		pnlJogador2.add(lblPontos2);
		lblPontos2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblPont2 = new JLabel("0");
		lblPont2.setForeground(Color.BLACK);
		lblPont2.setBounds(105, 146, 46, 14);
		pnlJogador2.add(lblPont2);
		lblPont2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblHorcrux2 = new JLabel("Horcrux");
		lblHorcrux2.setForeground(Color.BLACK);
		lblHorcrux2.setBounds(43, 173, 48, 17);
		pnlJogador2.add(lblHorcrux2);
		lblHorcrux2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblPontoHorc2 = new JLabel("0");
		lblPontoHorc2.setForeground(Color.BLACK);
		lblPontoHorc2.setBounds(105, 174, 46, 16);
		pnlJogador2.add(lblPontoHorc2);
		lblPontoHorc2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblAcertos2 = new JLabel("Acertos");
		lblAcertos2.setForeground(Color.BLACK);
		lblAcertos2.setBounds(43, 206, 46, 14);
		pnlJogador2.add(lblAcertos2);
		lblAcertos2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblAcerto2 = new JLabel("0");
		lblAcerto2.setForeground(Color.BLACK);
		lblAcerto2.setBounds(105, 204, 46, 14);
		pnlJogador2.add(lblAcerto2);
		lblAcerto2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));

		lblJogador_2 = new JLabel();
		lblJogador_2.setForeground(Color.BLACK);
		lblJogador_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblJogador_2.setBounds(0, 113, 178, 24);
		pnlJogador2.add(lblJogador_2);
		lblJogador_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFundo = new JLabel();
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(-76, -55, 2500, 842);
		contentPane.add(lblFundo);

		ComecarJogo();

	}
}
