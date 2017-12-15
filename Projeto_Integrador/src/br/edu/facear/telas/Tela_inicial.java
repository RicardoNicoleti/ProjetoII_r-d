package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit.Parser;

import br.edu.facear.classes.Jogador;

public class Tela_inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel lblBemVindo;
	private JButton btnJogar, btnRanking, btnCadastrarPergunta, btnAvaliarPergunta;
	private JLabel lblFundo;
	private JLabel lblLogo;
	private JLabel lblHorcrux;
	private JLabel lblNivel;
	private JLabel lblFoto;
	private JLabel lblPontohorcrux;
	private JLabel lblPontonivel;

	public void Run() {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);

	}

	public Tela_inicial() {
		setTitle("Tela inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 640);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		painel.setBounds(5, 5, 1192, 591);
		painel.setLayout(null);

		btnJogar = new JButton("JOGAR");
		btnJogar.setBackground(new Color(0, 255, 0));
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Jogo jogo = new Tela_Jogo();
				jogo.Run();
				dispose();

			}
		});
		btnJogar.setBounds(415, 294, 653, 100);
		painel.add(btnJogar);
		btnJogar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));

		btnRanking = new JButton("  Ranking");
		btnRanking.setForeground(new Color(255, 255, 255));
		btnRanking.setToolTipText("Ranking");
		btnRanking.setHorizontalAlignment(SwingConstants.LEFT);
		btnRanking.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Ranking.png"));
		btnRanking.setBackground(new Color(75, 0, 130));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Ranking r = new Tela_Ranking();
				r.Run();
				dispose();
			}
		});
		btnRanking.setBounds(246, 420, 236, 73);
		painel.add(btnRanking);
		btnRanking.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		btnCadastrarPergunta = new JButton("Cadastrar Pergunta");
		btnCadastrarPergunta.setForeground(new Color(255, 255, 255));
		btnCadastrarPergunta.setToolTipText("");
		btnCadastrarPergunta.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\QuestaoMaior.png"));
		btnCadastrarPergunta.setBackground(new Color(75, 0, 130));
		btnCadastrarPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Cadastrar_Pergunta c = new Tela_Cadastrar_Pergunta();
				c.Run();
				dispose();
			}
		});
		btnCadastrarPergunta.setBounds(738, 420, 236, 73);
		painel.add(btnCadastrarPergunta);
		btnCadastrarPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));

		btnAvaliarPergunta = new JButton("Avaliar Perguntas");
		btnAvaliarPergunta.setForeground(new Color(255, 255, 255));
		btnAvaliarPergunta.setToolTipText("");
		btnAvaliarPergunta.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Avaliar.png"));
		btnAvaliarPergunta.setBackground(new Color(75, 0, 130));
		btnAvaliarPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Tela_Avaliar a = new Tela_Avaliar();
				a.Run();
				dispose();

			}
		});
		btnAvaliarPergunta.setBounds(492, 420, 236, 73);
		painel.add(btnAvaliarPergunta);
		btnAvaliarPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));

		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setToolTipText("");
		btnSair.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnSair.setBackground(new Color(75, 0, 130));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Login l = new Tela_Login();
				l.Run();
				dispose();
			}
		});
		btnSair.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		btnSair.setBounds(984, 419, 236, 73);
		painel.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(954, 21, 325, 145);
		painel.add(panel);
		panel.setLayout(null);
		lblBemVindo = new JLabel("Olá " + Jogador.getInstance().getLogin());
		lblBemVindo.setBounds(139, 11, 165, 27);
		panel.add(lblBemVindo);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setHorizontalAlignment(SwingConstants.LEFT);
		lblBemVindo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		
		lblHorcrux = new JLabel("Horcrux:");
		lblHorcrux.setForeground(Color.BLACK);
		lblHorcrux.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblHorcrux.setBounds(138, 46, 67, 25);
		panel.add(lblHorcrux);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setForeground(Color.BLACK);
		lblNivel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblNivel.setBounds(140, 80, 41, 25);
		panel.add(lblNivel);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(Jogador.getLogado().getImagem()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	
		lblFoto = new JLabel(imageIcon);
		lblFoto.setBounds(9, 4, 100, 100);
		panel.add(lblFoto);
		
		JButton EditarFoto = new JButton("Editar Foto");
		EditarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser escolha = new JFileChooser();
				escolha.showOpenDialog(null);
				File f = escolha.getSelectedFile();
				String fileName = f.getAbsolutePath();
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
				lblFoto.setIcon(imageIcon);
				
				
				if(!fileName.isEmpty()){
					Jogador.getInstance().getLogado().setImagem(fileName);
					Jogador.getInstance().editarFoto();
				}
			}
		});
		EditarFoto.setBackground(Color.GREEN);
		EditarFoto.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		EditarFoto.setBounds(9, 117, 119, 23);
		panel.add(EditarFoto);
		
		lblPontohorcrux = new JLabel(Integer.toString(Jogador.getInstance().getHorcrux()));
		lblPontohorcrux.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblPontohorcrux.setForeground(Color.BLACK);
		lblPontohorcrux.setBounds(214, 45, 90, 26);
		panel.add(lblPontohorcrux);
		
		lblPontonivel = new JLabel(Integer.toString(Jogador.getInstance().getNivel()));
		lblPontonivel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblPontonivel.setBounds(214, 79, 90, 23);
		panel.add(lblPontonivel);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(558, 11, 311, 200);
		painel.add(lblLogo);
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(0, 0, 2500, 768);
		painel.add(lblFundo);

	}
}
