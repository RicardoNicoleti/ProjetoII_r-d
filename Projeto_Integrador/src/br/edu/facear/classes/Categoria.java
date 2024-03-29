package br.edu.facear.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Categoria {
	private int id;
	private String categoria;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}
	
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	public Categoria() {

	}

	public Categoria(int id, String categoria) {
		setId(id);
		setCategoria(categoria);
	}
	
	public List<Categoria> Ler(){
		
		List<Categoria> listaRetorno = new ArrayList<Categoria>();
		
		listaRetorno.add(new Categoria(0, "Selecione uma categoria"));
		listaRetorno.add(new Categoria(1, "Atualidades"));
		listaRetorno.add(new Categoria(2, "Geografia"));
		listaRetorno.add(new Categoria(3, "Games"));
		listaRetorno.add(new Categoria(4, "Hist�ria"));
		listaRetorno.add(new Categoria(5, "Programa��o"));
		listaRetorno.add(new Categoria(6, "Ci�ncias"));
		
		return listaRetorno;
	}
	
	public Vector<Categoria> listaCategoria(){
		
		Vector<Categoria> vetorRetorno = new Vector<Categoria>();
		
		List<Categoria> lista = Ler();
		
		for (Categoria categoria : lista) {
			vetorRetorno.addElement(categoria);
			
		}
		
		return vetorRetorno;
	}
	
	public Vector<Categoria> listaCategoria(int id){
		
		Vector<Categoria> vetorRetorno = new Vector<Categoria>();
		
		List<Categoria> lista = Ler();
		
		for (Categoria categoria : lista) {
			if(categoria.getId() == id)
				vetorRetorno.addElement(categoria);
			
		}
		
		return vetorRetorno;
	}
	
	public Categoria Ler(int ID) {
		Categoria categoriaRetorno = null;
		Categoria cat = new Categoria();
		List<Categoria> listaObjectCa = cat.Ler();
		for (Categoria categoria : listaObjectCa) {
			if (categoria.getId() == ID)
				categoriaRetorno = categoria;
		}
		return categoriaRetorno;
	}
	
	
	
	@Override
	public String toString() {
		return categoria;
	}
	
	
	
	
}
