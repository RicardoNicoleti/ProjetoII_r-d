package br.edu.facear.classes;

public class Categoria {
	
	private int idCategoria;
	private String categoria;
	private Pergunta pergunta;
	
	public void GerenciarCategoria(){
		
	}
		
	public Categoria(){
		
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Categoria(int idCategoria, String categoria) {
		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}

	public String getCategoria(){
		return this.categoria;
	}
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}
