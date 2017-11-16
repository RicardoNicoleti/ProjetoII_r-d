package br.edu.facear.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import java.awt.Color;

public class Tela_Cadastrar_Pergunta extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblUsuario;
	private Pergunta pergunta;

	public void Run(){
		this.setSize(1144, 762);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Tela_Cadastrar_Pergunta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 762);
		contentPane = new JPanel();
		contentPane.setToolTipText("Selecione a categoria");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo1 = new JLabel("Quiz");
		lblTitulo1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo1.setBounds(622, 19, 77, 47);
		contentPane.add(lblTitulo1);
		
		JLabel lblTitulo2 = new JLabel("by R&D");
		lblTitulo2.setBounds(686, 41, 46, 14);
		contentPane.add(lblTitulo2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new Categoria().listaCategoria()));
		comboBox.setBounds(536, 142, 289, 20);
		contentPane.add(comboBox);
		
		JLabel lblQuestao = new JLabel("Digite a Pergunta:");
		lblQuestao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuestao.setBounds(536, 166, 131, 20);
		contentPane.add(lblQuestao);
		
		JLabel lblAlternativaCorreta = new JLabel("Digite a alternativa correta:");
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlternativaCorreta.setBounds(536, 294, 187, 20);
		contentPane.add(lblAlternativaCorreta);
		
		JLabel lblIncorreta1 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIncorreta1.setBounds(538, 378, 169, 20);
		contentPane.add(lblIncorreta1);
		
		JLabel lblIncorreta2 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIncorreta2.setBounds(536, 450, 169, 20);
		contentPane.add(lblIncorreta2);
		
		JLabel lblIncorreta3 = new JLabel("Digite a alternativa incorreta:");
		lblIncorreta3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIncorreta3.setBounds(536, 524, 169, 20);
		contentPane.add(lblIncorreta3);
		
		JTextArea txtAPergunta = new JTextArea();
		txtAPergunta.setLineWrap(true);
		txtAPergunta.setBounds(537, 185, 289, 105);
		contentPane.add(txtAPergunta);
		
		JTextArea txtACorreta = new JTextArea();
		txtACorreta.setLineWrap(true);
		txtACorreta.setBounds(536, 314, 289, 59);
		contentPane.add(txtACorreta);
		
		JTextArea txtAIncorreta1 = new JTextArea();
		txtAIncorreta1.setLineWrap(true);
		txtAIncorreta1.setBounds(538, 396, 289, 53);
		contentPane.add(txtAIncorreta1);
		
		JTextArea txtAIncorreta2 = new JTextArea();
		txtAIncorreta2.setLineWrap(true);
		txtAIncorreta2.setBounds(536, 468, 289, 53);
		contentPane.add(txtAIncorreta2);
		
		JTextArea txtAIncorreta3 = new JTextArea();
		txtAIncorreta3.setLineWrap(true);
		txtAIncorreta3.setBounds(535, 542, 289, 53);
		contentPane.add(txtAIncorreta3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pergunta = new Pergunta();
				
				String questao = txtAPergunta.getText();
				String correta = txtACorreta.getText(); 
				String incorreta1 = txtAIncorreta1.getText();
				String incorreta2 = txtAIncorreta2.getText();
				String incorreta3 = txtAIncorreta3.getText();
				String autor = Jogador.getInstance().getLogin();
				
				pergunta.setCategoria((Categoria) comboBox.getSelectedItem());
				pergunta.setPergunta(questao);
				pergunta.setCorreta(correta);
				pergunta.setAlternativas1(incorreta1);
				pergunta.setAlternativas2(incorreta2);
				pergunta.setAlternativas3(incorreta3);
				pergunta.setAutor(autor);
				
				if(pergunta.Cadastrar(true).equals("OK")) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
				}
				
			}
		});
		btnSalvar.setBounds(536, 606, 120, 36);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_inicial inicio = new Tela_inicial();
				inicio.Run();
				dispose();
			}
		});
		btnCancelar.setBounds(666, 606, 120, 36);
		contentPane.add(btnCancelar);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutor.setBounds(535, 89, 46, 27);
		contentPane.add(lblAutor);
		
		lblUsuario = new JLabel(Jogador.getInstance().getLogin().toUpperCase());
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(587, 89, 238, 27);
		contentPane.add(lblUsuario);
		
	}
}