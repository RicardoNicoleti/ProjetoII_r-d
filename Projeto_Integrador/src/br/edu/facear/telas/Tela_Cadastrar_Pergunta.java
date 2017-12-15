package br.edu.facear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.edu.facear.classes.Categoria;
import br.edu.facear.classes.Jogador;
import br.edu.facear.classes.Pergunta;

public class Tela_Cadastrar_Pergunta extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Pergunta pergunta;
	private JTextArea txtAPergunta;
	private JPanel pnlForm;
	private JLabel lblAutor;
	private JLabel lblQuestao;
	private JLabel lblAlternativaCorreta;
	private JTextArea txtACorreta;
	private JLabel lblIncorreta1;
	private JTextArea txtAIncorreta1;
	private JLabel lblIncorreta2;
	private JTextArea txtAIncorreta2;
	private JLabel lblIncorreta3;
	private JTextArea txtAIncorreta3;
	private JLabel lblLogo;
	private JLabel lblFundo;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnCadastrar;
	private JComboBox<String> comboBox;
	private JPanel pnlEditar;
	private JLabel lblCategoria;
	private JComboBox<String> comboBoxEditar;
	private JLabel lblPergunta;
	private JTextArea txtEditarPergunta;
	private JLabel lblAlternativaCorreta_1;
	private JTextArea txtEditarCorreta;
	private JLabel lblAlternativaIncorreta;
	private JTextArea txtEditarIncorreta1;
	private JLabel lblAlternativaIncorreta_1;
	private JTextArea txtEditarIncorreta2;
	private JLabel lblAlternativaIncorreta_2;
	private JTextArea txtEditarIncorreta3;
	private JButton btnSair;
	private JButton btnAnterior;
	private JButton btnProximo;
	private boolean acao;
	private int index = 0;

	private JButton btnCancelar;

	public void Run() {
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);

	}

	public void carregarPerguntas(int id) {
		pergunta = new Pergunta();
		List<Pergunta> listaObjectPerg = pergunta.carregarPergunta();

		pergunta.setId(listaObjectPerg.get(id).getId());
		comboBoxEditar.setModel(new DefaultComboBoxModel(new Categoria().listaCategoria()));
		comboBoxEditar.setSelectedIndex(listaObjectPerg.get(id).getCategoria().getId());
		pergunta.setCategoria(listaObjectPerg.get(id).getCategoria());
		txtEditarPergunta.setText(listaObjectPerg.get(id).getPergunta());
		txtEditarCorreta.setText(listaObjectPerg.get(id).getCorreta());
		txtEditarIncorreta1.setText(listaObjectPerg.get(id).getAlternativas1());
		txtEditarIncorreta2.setText(listaObjectPerg.get(id).getAlternativas2());
		txtEditarIncorreta3.setText(listaObjectPerg.get(id).getAlternativas3());

			
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Tela_Cadastrar_Pergunta() {
		setTitle("Cadastrar Pergunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnSalvar.setBackground(new Color(0, 255, 0));
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (acao) {
					pergunta = new Pergunta();
					String questao = txtAPergunta.getText();
					String correta = txtACorreta.getText();
					String incorreta1 = txtAIncorreta1.getText();
					String incorreta2 = txtAIncorreta2.getText();
					String incorreta3 = txtAIncorreta3.getText();

					pergunta.setCategoria((Categoria) comboBox.getSelectedItem());
					pergunta.setPergunta(questao);
					pergunta.setCorreta(correta);
					pergunta.setAlternativas1(incorreta1);
					pergunta.setAlternativas2(incorreta2);
					pergunta.setAlternativas3(incorreta3);
					pergunta.setJogador(Jogador.getInstance());

					if (pergunta.Cadastrar(true).equals("OK") && comboBox.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

						txtAPergunta.setText("");
						txtACorreta.setText("");
						txtAIncorreta1.setText("");
						txtAIncorreta2.setText("");
						txtAIncorreta3.setText("");

						txtEditarPergunta.setEditable(false);
						txtEditarCorreta.setEditable(false);
						txtEditarIncorreta1.setEditable(false);
						txtEditarIncorreta2.setEditable(false);
						txtEditarIncorreta3.setEditable(false);
						btnProximo.setVisible(true);
						btnAnterior.setVisible(true);
						pnlEditar.setVisible(true);

						pnlForm.setVisible(false);
						btnCancelar.setVisible(false);
						btnSalvar.setVisible(false);
						btnEditar.setVisible(true);
						
						carregarPerguntas(index);
					} else {
						JOptionPane.showMessageDialog(null, "Um ou mais campo n�o foram preenchidos");
					}
				} else {
					try {

						String questao = txtEditarPergunta.getText();
						String correta = txtEditarCorreta.getText();
						String incorreta1 = txtEditarIncorreta1.getText();
						String incorreta2 = txtEditarIncorreta2.getText();
						String incorreta3 = txtEditarIncorreta3.getText();

						pergunta.setCategoria((Categoria) comboBoxEditar.getSelectedItem());
						pergunta.setPergunta(questao);
						pergunta.setCorreta(correta);
						pergunta.setAlternativas1(incorreta1);
						pergunta.setAlternativas2(incorreta2);
						pergunta.setAlternativas3(incorreta3);

						pergunta.EditarPergunta();

						txtEditarPergunta.setEditable(false);
						txtEditarCorreta.setEditable(false);
						txtEditarIncorreta1.setEditable(false);
						txtEditarIncorreta2.setEditable(false);
						txtEditarIncorreta3.setEditable(false);
						btnSalvar.setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Editado com sucesso");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao editar");
					}

				}

			}
		});
		btnSalvar.setBounds(685, 569, 168, 73);
		contentPane.add(btnSalvar);

		btnEditar = new JButton("Editar Pergunta");
		btnEditar.setIcon(
				new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\editMenor.png"));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		btnEditar.setBackground(new Color(75, 0, 130));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pnlForm.setVisible(false);
				pnlEditar.setVisible(true);
				pergunta.setId(pergunta.getId());
				pergunta.setCategoria((Categoria) comboBoxEditar.getSelectedItem());
				txtEditarPergunta.setEditable(true);
				txtEditarCorreta.setEditable(true);
				txtEditarIncorreta1.setEditable(true);
				txtEditarIncorreta2.setEditable(true);
				txtEditarIncorreta3.setEditable(true);

				btnSalvar.setVisible(true);
				btnSalvar.setText("Editar");

				btnProximo.setVisible(true);
				btnAnterior.setVisible(true);

				acao = false;

			}
		});
		btnEditar.setBounds(488, 570, 189, 73);
		contentPane.add(btnEditar);

		btnCadastrar = new JButton("Nova Pergunta");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setIcon(
				new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\questaomenor.png"));
		btnCadastrar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 19));
		btnCadastrar.setBackground(new Color(75, 0, 130));
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				pnlForm.setVisible(true);
				pnlEditar.setVisible(false);

				btnSalvar.setVisible(true);
				btnSalvar.setText("Salvar");
				btnEditar.setVisible(false);
				btnCancelar.setVisible(true);
				btnProximo.setVisible(false);
				btnAnterior.setVisible(false);
				acao = true;

			}
		});
		btnCadastrar.setBounds(278, 569, 203, 73);
		contentPane.add(btnCadastrar);

		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 0)
					index--;
				carregarPerguntas(index);
			}

		});
		btnAnterior.setBackground(new Color(147, 112, 219));
		btnAnterior.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_circle-back-arrow-glyph_763477.png"));
		btnAnterior.setBounds(186, 288, 97, 73);
		contentPane.add(btnAnterior);

		btnProximo = new JButton("");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pergunta = new Pergunta();
				List<Pergunta> listaObjectPerg = pergunta.carregarPergunta();
				if (index < listaObjectPerg.size())
					index++;
				else
					index = 1;
				carregarPerguntas(index);
			}
		});
		btnProximo.setBackground(new Color(147, 112, 219));
		btnProximo.setIcon(new ImageIcon(
				"C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\if_circle-next-arrow-disclosure-glyph_763448.png"));
		btnProximo.setBounds(1031, 299, 97, 73);
		contentPane.add(btnProximo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCancelar.setVisible(false);
				btnEditar.setVisible(true);
				pnlForm.setVisible(false);
				pnlEditar.setVisible(true);

				txtEditarPergunta.setEditable(false);
				txtEditarCorreta.setEditable(false);
				txtEditarIncorreta1.setEditable(false);
				txtEditarIncorreta2.setEditable(false);
				txtEditarIncorreta3.setEditable(false);
				btnSalvar.setVisible(false);
				btnProximo.setVisible(true);
				btnAnterior.setVisible(true);

			}
		});
		btnCancelar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(75, 0, 130));
		btnCancelar.setBounds(490, 569, 185, 73);
		contentPane.add(btnCancelar);

		pnlEditar = new JPanel();
		pnlEditar.setBounds(278, 113, 756, 444);
		contentPane.add(pnlEditar);
		pnlEditar.setLayout(null);
		pnlEditar.setBackground(new Color(147, 112, 219));

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		lblCategoria.setBounds(32, 11, 108, 37);
		pnlEditar.add(lblCategoria);

		comboBoxEditar = new JComboBox<String>();
		comboBoxEditar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		comboBoxEditar.setBounds(32, 48, 325, 31);
		pnlEditar.add(comboBoxEditar);

		lblPergunta = new JLabel("Pergunta:");
		lblPergunta.setForeground(new Color(0, 0, 128));
		lblPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblPergunta.setBounds(31, 86, 142, 25);
		pnlEditar.add(lblPergunta);

		txtEditarPergunta = new JTextArea();
		txtEditarPergunta.setEditable(false);
		txtEditarPergunta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtEditarPergunta.setLineWrap(true);
		txtEditarPergunta.setBounds(31, 112, 658, 52);
		pnlEditar.add(txtEditarPergunta);

		lblAlternativaCorreta_1 = new JLabel("Alternativa correta:");
		lblAlternativaCorreta_1.setForeground(Color.GREEN);
		lblAlternativaCorreta_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativaCorreta_1.setBounds(31, 169, 215, 25);
		pnlEditar.add(lblAlternativaCorreta_1);

		txtEditarCorreta = new JTextArea();
		txtEditarCorreta.setEditable(false);
		txtEditarCorreta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtEditarCorreta.setLineWrap(true);
		txtEditarCorreta.setBounds(29, 198, 660, 30);
		pnlEditar.add(txtEditarCorreta);

		lblAlternativaIncorreta = new JLabel("Alternativa incorreta:");
		lblAlternativaIncorreta.setForeground(Color.BLACK);
		lblAlternativaIncorreta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativaIncorreta.setBounds(28, 239, 238, 20);
		pnlEditar.add(lblAlternativaIncorreta);

		txtEditarIncorreta1 = new JTextArea();
		txtEditarIncorreta1.setEditable(false);
		txtEditarIncorreta1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtEditarIncorreta1.setLineWrap(true);
		txtEditarIncorreta1.setBounds(28, 265, 661, 30);
		pnlEditar.add(txtEditarIncorreta1);

		lblAlternativaIncorreta_1 = new JLabel("Alternativa incorreta:");
		lblAlternativaIncorreta_1.setForeground(Color.BLACK);
		lblAlternativaIncorreta_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativaIncorreta_1.setBounds(28, 298, 230, 25);
		pnlEditar.add(lblAlternativaIncorreta_1);

		txtEditarIncorreta2 = new JTextArea();
		txtEditarIncorreta2.setEditable(false);
		txtEditarIncorreta2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtEditarIncorreta2.setLineWrap(true);
		txtEditarIncorreta2.setBounds(27, 324, 662, 30);
		pnlEditar.add(txtEditarIncorreta2);

		lblAlternativaIncorreta_2 = new JLabel("Alternativa incorreta:");
		lblAlternativaIncorreta_2.setForeground(Color.BLACK);
		lblAlternativaIncorreta_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		lblAlternativaIncorreta_2.setBounds(27, 360, 230, 25);
		pnlEditar.add(lblAlternativaIncorreta_2);

		txtEditarIncorreta3 = new JTextArea();
		txtEditarIncorreta3.setEditable(false);
		txtEditarIncorreta3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		txtEditarIncorreta3.setLineWrap(true);
		txtEditarIncorreta3.setBounds(26, 386, 663, 30);
		pnlEditar.add(txtEditarIncorreta3);

		pnlForm = new JPanel();
		pnlForm.setBackground(new Color(147, 112, 219));
		pnlForm.setBounds(278, 113, 756, 444);
		contentPane.add(pnlForm);
		pnlForm.setLayout(null);

		lblAutor = new JLabel("Categoria");
		lblAutor.setBounds(32, 11, 108, 37);
		pnlForm.add(lblAutor);
		lblAutor.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));

		comboBox = new JComboBox<String>();
		comboBox.setBounds(32, 48, 325, 31);
		pnlForm.add(comboBox);
		comboBox.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new Categoria().listaCategoria()));

		lblQuestao = new JLabel("Digite a Pergunta:");
		lblQuestao.setBounds(31, 86, 142, 25);
		pnlForm.add(lblQuestao);
		lblQuestao.setForeground(new Color(0, 0, 128));
		lblQuestao.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		txtAPergunta = new JTextArea();
		txtAPergunta.setBounds(30, 111, 660, 52);
		pnlForm.add(txtAPergunta);
		txtAPergunta.setLineWrap(true);

		lblAlternativaCorreta = new JLabel("Digite a alternativa correta:");
		lblAlternativaCorreta.setBounds(31, 169, 215, 25);
		pnlForm.add(lblAlternativaCorreta);
		lblAlternativaCorreta.setForeground(Color.GREEN);
		lblAlternativaCorreta.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		txtACorreta = new JTextArea();
		txtACorreta.setBounds(29, 198, 660, 30);
		pnlForm.add(txtACorreta);
		txtACorreta.setLineWrap(true);

		lblIncorreta1 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta1.setBounds(28, 239, 238, 20);
		pnlForm.add(lblIncorreta1);
		lblIncorreta1.setForeground(Color.BLACK);
		lblIncorreta1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		txtAIncorreta1 = new JTextArea();
		txtAIncorreta1.setBounds(28, 265, 662, 30);
		pnlForm.add(txtAIncorreta1);
		txtAIncorreta1.setLineWrap(true);

		lblIncorreta2 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta2.setBounds(28, 298, 230, 25);
		pnlForm.add(lblIncorreta2);
		lblIncorreta2.setForeground(Color.BLACK);
		lblIncorreta2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		txtAIncorreta2 = new JTextArea();
		txtAIncorreta2.setBounds(27, 324, 663, 30);
		pnlForm.add(txtAIncorreta2);
		txtAIncorreta2.setLineWrap(true);

		lblIncorreta3 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta3.setBounds(27, 360, 230, 25);
		pnlForm.add(lblIncorreta3);
		lblIncorreta3.setForeground(Color.BLACK);
		lblIncorreta3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));

		txtAIncorreta3 = new JTextArea();
		txtAIncorreta3.setBounds(26, 386, 664, 30);
		pnlForm.add(txtAIncorreta3);
		txtAIncorreta3.setLineWrap(true);

		btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Sair.png"));
		btnSair.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_inicial inicio = new Tela_inicial();
				inicio.Run();
				dispose();
			}
		});
		btnSair.setBackground(new Color(75, 0, 130));
		btnSair.setBounds(859, 569, 175, 73);
		contentPane.add(btnSair);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\Logo.png"));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(501, -34, 311, 200);
		contentPane.add(lblLogo);

		lblFundo = new JLabel("Fundo");
		lblFundo.setIcon(
				new ImageIcon("C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador\\img\\FundoPadrao.png"));
		lblFundo.setBounds(0, 0, 2534, 768);
		contentPane.add(lblFundo);
		
		pergunta = new Pergunta();
		List<Pergunta> listaObjectPerg = pergunta.carregarPergunta();
		
		if (listaObjectPerg.size() != 0) {
			carregarPerguntas(index);
		}else{
			comboBoxEditar.setModel(new DefaultComboBoxModel(new Categoria().listaCategoria()));
			txtEditarPergunta.setText("N�o h� perguntas cadastradas");
			txtEditarCorreta.setText("N�o h� perguntas cadastradas");
			txtEditarIncorreta1.setText("N�o h� perguntas cadastradas");
			txtEditarIncorreta2.setText("N�o h� perguntas cadastradas");
			txtEditarIncorreta3.setText("N�o h� perguntas cadastradas");
		}
		btnSalvar.setVisible(false);
		btnCancelar.setVisible(false);

	}
}
