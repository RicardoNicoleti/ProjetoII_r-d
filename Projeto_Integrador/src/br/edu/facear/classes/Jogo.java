package br.edu.facear.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
	private float tempo;
	private int vez;
	private Jogador jogador;
	private Pergunta pergunta;
	Random r = new Random();

	public void Jogar() {
		System.out.println(this.jogador.getNome() + " Jogando");
		System.out.println(this.pergunta.getCategoria() + "\n"+ this.pergunta.getPergunta() + "\n" + this.pergunta.getAlternativas1() + "\n"
				+ this.pergunta.getAlternativas2() + "\n" + this.pergunta.getAlternativas3() + "\n" + this.pergunta.getCorreta());

	}

	public void FazerPergunta() {
		List<Pergunta> lista = new ArrayList<Pergunta>();
		for (int i = 0; i < lista.size(); i++) {
			randomizar(lista);
		}

	}

	private void randomizar(List<Pergunta> lista) {
		int index = r.nextInt(lista.size());

		System.out.println(lista.get(index));

	}

	public void MostrarRanking() {
		System.out.println("Mostrando ranking");
	}

	public void EscolherAdversario() {
		System.out.println("Escolhendo adversario");
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public int getVez() {
		return vez;
	}

	public void setVez(int vez) {
		this.vez = vez;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Jogo() {

	}

	public Jogo(float tempo, int vez, Jogador jogador, Pergunta pergunta) {
		this.tempo = tempo;
		this.vez = vez;
		this.jogador = jogador;
		this.pergunta = pergunta;
	}

}
