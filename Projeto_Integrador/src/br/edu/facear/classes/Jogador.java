package br.edu.facear.classes;

import java.util.ArrayList;

public class Jogador {
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private int telefone;
	private int pontos;
	private int nivel;
		
	public void Logar(){
		if(this.login == "admin" && this.senha == "1234")
			System.out.println("Logando com sucesso");
		else
			System.out.println("Login ou senha invalidos!");

	}
	public void Cadastrar(){
		try {
			ArrayList<Jogador> lista = new ArrayList<Jogador>();
			this.getNome();
			this.getIdade();
			this.getLogin();
			this.getPontos();
			this.getSenha();
			lista.add(this);
			System.out.println("Cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao salvar");
		}
	}
	
	public Jogador() {
	}
	
	public Jogador(String nome, int idade, String login, String senha, int telefone, int pontos, int nivel) {
		this.nome = nome;
		this.idade = idade;
		this.login = login;
		this.senha = senha;
		this.telefone = telefone;
		this.pontos = pontos;
		this.nivel = nivel;
	}
	
	
	public Jogador(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "Jogador nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha + ", telefone="
				+ telefone + ", pontos=" + pontos + ", nivel=" + nivel + "";
	}
	
	
	
	
}
