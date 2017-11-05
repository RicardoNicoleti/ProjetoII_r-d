package br.edu.facear.classes;

public enum Categoria {
		Geografia("Geografia"),
		Hist�ria("Hist�ria"),
		Ci�ncias("Ci�ncias"),
		Programa��o("Programa��o"),
		Games("Games"),
		Atualidades("Atualidades");

	    private String categoria;
	    
	    private Categoria(String categoria) {
			this.categoria = categoria;
		}
	    
	    public String getCategoria() {
			return this.categoria;
		}
	    
	    @Override
	    public String toString() {
	    	return this.categoria;
	    }
	}
