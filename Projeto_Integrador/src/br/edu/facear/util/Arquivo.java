package br.edu.facear.util;

import java.io.*;
import java.util.*;

public class Arquivo {
	//Atributos
	private String diretorio;
	private String nome;
	private String texto;
	
	//Get e Set
	public String getDiretorio(){
		return this.diretorio;
	}
	public void setDiretorio(String diretorio){
		this.diretorio = diretorio;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}	
	public String getTexto(){
		return this.texto;
	}
	public void setTexto(String texto){
		this.texto = texto;
	}	
	//Construtor
	public Arquivo(){
		this.diretorio = "C:\\Users\\ricar\\Desktop\\ProjetoII_r-d\\Projeto_Integrador";		
	}
	public Arquivo(String dir, String nome, String texto){
		this.diretorio = dir;
		this.nome = nome;
		this.texto = texto;
	}	
	
	public boolean Gravar(){
		
		File dir = new File(this.diretorio);		
		File arq = new File(dir, this.nome);
		
		try{
			arq.createNewFile();
			
			boolean acrescentar = true;
			
			FileWriter fw = new FileWriter(arq, acrescentar);
			
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(this.texto);
			
			pw.flush();
			pw.close();
			
		}
		catch (Exception e){
			System.out.println("Erro ao Gravar o arquivo: "+e.getMessage());
		}
		
		System.out.println("GRAVOU");
		return true;
	}
	public List<String> Ler(){
		List<String> lista = new ArrayList<String>();

		File dir = new File(this.diretorio);		
		File arq = new File(dir, this.nome);
		try{
			String linha;
			
			FileReader fr = new FileReader(arq);
			
			BufferedReader br = new BufferedReader(fr);
			while ( (linha = br.readLine()) != null ){
				lista.add(linha);
			}
			
		br.close();
			
		}
		catch (Exception e){
			System.out.println("Erro ao Gravar o arquivo: "+e.getMessage());
		}		
		
		return lista;
		
		
	}	

}
