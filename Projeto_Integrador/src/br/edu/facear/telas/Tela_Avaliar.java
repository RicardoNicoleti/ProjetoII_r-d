package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Pergunta;

public class Tela_Avaliar extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private int index = 0;
	private JPanel contentPane;
	private JLabel lblAutor, lblCategoria;
	private Pergunta pergunta;
	private JLabel lblFundo;
	private JLabel label_1;
	private JLabel lblPergunta;
	private JLabel lblAlternativa;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JButton btnAvaliar;
	private JLabel lblLogo;
	private JTextArea txtAlternativa4;
	private JTextArea txtAlternativa3;
	private JTextArea txtAlternativa2;
	private JTextArea txtAlternativa1;
	private JTextArea txtAPergunta;
	private JLabel lblAlternativa_3;
	private JLabel lblAlternativa_2;
	private JLabel lblAlternativa_1;
	private JLabel lblFoto;
	private JPanel panel_1;

	public void Run() {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);

	}

	public void carregarPergunta(int id) {
		pergunta = new Pergunta();
		List<Pergunta> listaObjectPerg = pergunta.carregarPerguntaAvaliar();
		pergunta.setId(listaObjectPerg.get(id).getId());
		
		List<String> perguntas = Arrays.asList(listaObjectPerg.get(id).getCorreta(),listaObjectPerg.get(id).getAlternativas1(),
				listaObjectPerg.get(id).getAlternativas2(), listaObjectPerg.get(id).getAlternativas3());
		
		Collections.shuffle(perguntas);

		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(listaObjectPerg.get(id).getJogador().getImagem()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		lblFoto.setIcon(imageIcon2);

		
		lblAutor.setText(listaObjectPerg.get(id).getJogador().getLogin().toUpperCase());
		lblCategoria.setText(listaObjectPerg.get(id).getCategoria().getCategoria());
		txtAPergunta.setText(listaObjectPerg.get(id).getPergunta());
		txtAlternativa1.setText(perguntas.get(0));
		txtAlternativa2.setText(perguntas.get(1));
		txtAlternativa3.setText(perguntas.get(2));
		txtAlternativa4.setText(perguntas.get(3));

	}

	public Tela_Avaliar() {
		setTitle("Avaliar Pergunta");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Sair");
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnVoltar.setBackground(new Color(75, 0, 130));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_inicial t = new Tela_inicial();
				t.Run();
				dispose();

			}
		});
		btnVoltar.setBounds(843, 585, 146, 63);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBounds(384, 129, 605, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setBounds(164, 11, 224, 62);
		panel.add(lblCategoria);
		lblCategoria.setFont(new Font("Bernard MT Condensed", Font.BOLD | Font.ITALIC, 35));
		
		lblPergunta = new JLabel("Pergunta");
		lblPergunta.setForeground(Color.BLACK);
		lblPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblPergunta.setBounds(32, 85, 72, 25);
		panel.add(lblPergunta);
		
		lblAlternativa = new JLabel("Alternativa 1");
		lblAlternativa.setForeground(Color.BLACK);
		lblAlternativa.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativa.setBounds(34, 172, 97, 25);
		panel.add(lblAlternativa);
		
		lblAlternativa_1 = new JLabel("Alternativa 2");
		lblAlternativa_1.setForeground(Color.BLACK);
		lblAlternativa_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativa_1.setBounds(32, 236, 99, 25);
		panel.add(lblAlternativa_1);
		
		lblAlternativa_2 = new JLabel("Alternativa 3");
		lblAlternativa_2.setForeground(Color.BLACK);
		lblAlternativa_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativa_2.setBounds(32, 301, 99, 25);
		panel.add(lblAlternativa_2);
		
		lblAlternativa_3 = new JLabel("Alternativa 4");
		lblAlternativa_3.setForeground(Color.BLACK);
		lblAlternativa_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativa_3.setBounds(32, 365, 99, 25);
		panel.add(lblAlternativa_3);
		
		label_1 = new JLabel("Autor:");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(372, 31, 47, 25);
		panel.add(label_1);
		label_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		
		lblAutor = new JLabel();
		lblAutor.setText("nome");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setBounds(406, 85, 173, 18);
		panel.add(lblAutor);
		lblAutor.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		
		txtAPergunta = new JTextArea();
		txtAPergunta.setBackground(new Color(248, 248, 255));
		txtAPergunta.setEditable(false);
		txtAPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtAPergunta.setBounds(34, 110, 531, 58);
		panel.add(txtAPergunta);
		
		txtAlternativa1 = new JTextArea();
		txtAlternativa1.setBackground(new Color(248, 248, 255));
		txtAlternativa1.setEditable(false);
		txtAlternativa1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtAlternativa1.setBounds(32, 196, 531, 40);
		panel.add(txtAlternativa1);
		
		txtAlternativa2 = new JTextArea();
		txtAlternativa2.setBackground(new Color(248, 248, 255));
		txtAlternativa2.setEditable(false);
		txtAlternativa2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtAlternativa2.setBounds(32, 260, 531, 40);
		panel.add(txtAlternativa2);
		
		txtAlternativa3 = new JTextArea();
		txtAlternativa3.setBackground(new Color(248, 248, 255));
		txtAlternativa3.setEditable(false);
		txtAlternativa3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtAlternativa3.setBounds(32, 325, 531, 40);
		panel.add(txtAlternativa3);
		
		txtAlternativa4 = new JTextArea();
		txtAlternativa4.setBackground(new Color(248, 248, 255));
		txtAlternativa4.setEditable(false);
		txtAlternativa4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtAlternativa4.setBounds(33, 389, 531, 40);
		panel.add(txtAlternativa4);
		
		lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(433, 11, 115, 67);
		panel.add(lblFoto);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(123, 104, 238));
		panel_1.setBounds(447, 11, 86, 67);
		panel.add(panel_1);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(530, -21, 311, 200);
		contentPane.add(lblLogo);
		
		btnAvaliar = new JButton("  Avaliar");
		btnAvaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pergunta.AvaliarPergunta();
				List<Pergunta> listaObjectPerg = pergunta.carregarPerguntaAvaliar();
				if (index < listaObjectPerg.size())
					index++;
				else
					index = 0;
				carregarPergunta(index);
			}
		});
		btnAvaliar.setForeground(new Color(255, 255, 255));
		btnAvaliar.setBackground(new Color(75, 0, 130));
		btnAvaliar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnAvaliar.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_check-circle_326571.png"));
		btnAvaliar.setBounds(384, 584, 156, 63);
		contentPane.add(btnAvaliar);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 0){
					index--;
					carregarPergunta(index);	
				}
			}
		});
		btnAnterior.setBackground(new Color(147, 112, 219));
		btnAnterior.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_circle-back-arrow-glyph_763477.png"));
		btnAnterior.setBounds(296, 321, 89, 73);
		contentPane.add(btnAnterior);
		
		btnProximo = new JButton("");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pergunta = new Pergunta();
				List<Pergunta> listaObjectPerg = pergunta.carregarPerguntaAvaliar();
				if (index < listaObjectPerg.size())
					index++;
				else
					index = 0;
				carregarPergunta(index);
			}
		});
		btnProximo.setBackground(new Color(147, 112, 219));
		btnProximo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_circle-next-arrow-disclosure-glyph_763448.png"));
		btnProximo.setBounds(987, 321, 89, 73);
		contentPane.add(btnProximo);
		
		lblFundo = new JLabel("Fundo");
		lblFundo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(0, 0, 2534, 768);
		contentPane.add(lblFundo);

		carregarPergunta(index);
	}
}
