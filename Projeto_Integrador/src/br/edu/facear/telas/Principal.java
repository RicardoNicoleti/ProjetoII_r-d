package br.edu.facear.telas;

import java.util.ArrayList;
import java.util.List;

import br.edu.facear.classes.Categoria;
import br.edu.facear.classes.Jogador;
import br.edu.facear.classes.Jogo;
import br.edu.facear.classes.Pergunta;
import br.edu.facear.classes.Ranking;

public class Principal {

	public static void main(String[] args) {

		// Instancia
		Jogador jogador = new Jogador();
		Jogo jogo = new Jogo();
		Ranking ranking = new Ranking();
		Categoria categoria = new Categoria();
		Pergunta pergunta = new Pergunta();

		// Atribui��o

		// Criando um novo jogador -----------------------

		List<Jogador> listaJogador = new ArrayList<Jogador>();
		jogador.setNome("Ricardo");
		jogador.setIdade(27);
		jogador.setTelefone(99999999);
		jogador.setNivel(3);
		jogador.setPontos(1082);
		jogador.setLogin("admin");
		jogador.setSenha("12234");

		listaJogador.add(jogador);
		// ---------------------------------------------

		// Inserindo Perguntas no sistema-------------------
		ArrayList<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
		categoria.setCategoria("Categoria 1");
		pergunta.setPergunta("Pergunta 1");
		pergunta.setAlternativas1("Alternativa 1");
		pergunta.setAlternativas2("Alternativa 2");
		pergunta.setAlternativas3("Alternativa 3");
		pergunta.setCorreta("Alternativa Correta!");
		pergunta.setCategoria(categoria);
//		categoria.setPergunta(pergunta);
		listaPerguntas.add(pergunta);

		
		// Inserir um jogador-------------
		jogador.Logar();
		
		
		//Jogar---------------------------
		jogo.setJogador(jogador);
		jogo.setPergunta(pergunta);
		jogo.setTempo(30);
		jogo.setVez(1);
		jogo.Jogar();
		// -----------------------------------------------
		
		// Prot�tipo de ranking --------------------------
		System.out.println("Ranking---------------------");
		ranking.setJogador(jogador);
		ranking.GerenciarRanking();
		
		// -----------------------------------------------

		pergunta.AvaliarPerguntas();
		
		

	}
}
