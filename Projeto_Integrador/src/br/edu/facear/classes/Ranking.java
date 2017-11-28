package br.edu.facear.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking implements Comparator<Jogador> {
	private int semanal;
	private int mensal;
	private Jogador jogador;

	public Ranking() {

	}

	public Ranking(int semanal, int mensal) {
		this.semanal = semanal;
		this.mensal = mensal;
	}

	public int getSemanal() {
		return semanal;
	}

	public void setSemanal(int semanal) {
		this.semanal = semanal;
	}

	public int getMensal() {
		return mensal;
	}

	public void setMensal(int mensal) {
		this.mensal = mensal;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> GerenciarRanking() {
		List<Jogador> listaRetorno = new ArrayList<Jogador>();

		jogador = new Jogador();
		List<Jogador> listaObjectJog = jogador.Ler();
		for (Jogador jogador : listaObjectJog) {

			listaRetorno.add(jogador);

		}
		
		return listaRetorno;
	}

	@Override
	public int compare(Jogador um, Jogador dois) {

		return dois.getNivel() - um.getNivel();

	}

}
