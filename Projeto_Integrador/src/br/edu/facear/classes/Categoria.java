package br.edu.facear.classes;

public enum Categoria {
		Geografia("Geografia"),
		História("História"),
		Ciências("Ciências"),
		Programação("Programação"),
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
