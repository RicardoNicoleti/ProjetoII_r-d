package br.edu.facear.classes;

public class Ranking {
	private int semanal;
	private int mensal;
	
	
	public void GerenciarRanking(){
		
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
		
}
