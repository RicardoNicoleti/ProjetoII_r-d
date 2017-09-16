package br.edu.facear.classes;

public class Ranking {
	private int semanal;
	private int mensal;
	private Jogador jogador;
	
	public void GerenciarRanking(){
		
		System.out.println(this.jogador.getNome()+ " " + this.jogador.getPontos()+" " + this.jogador.getNivel());
		
	}
	
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
	
	
}
