package br.edu.facear.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	public static String Ler(String Caminho){
		String conteudo = "";
		
		try {
			FileReader arq = new FileReader(Caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while(linha!= null){
					conteudo += linha;
					linha = lerArq.readLine();
				}
				arq.close();
				return conteudo;
			} catch (IOException ex) {
				System.out.println("Erro: N�o foi possivel ler o arquivo");
				return "";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Erro: Arquivo n�o encontrado");
			return "";
		}	
	}
	
	public static boolean Escrever(String Caminho, String Texto){
		try {
			FileWriter arq = new FileWriter(Caminho);
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.println(Texto);
			gravarArq.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
