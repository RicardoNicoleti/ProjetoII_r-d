package br.edu.facear.classes;

public class Perguntas {
	
	private int id;
	private int avaliacao;
	private String pergunta;
	private String alternativas1;
	private String alternativas2;
	private String alternativas3;
	private String correta;
	
	
	public void CadastrarPerguntas(){
		
	}
	public void AvaliarPerguntas(){
		
	}
	public void SortearPerguntas(){
		
	}
	
	public void ValidarPergunta(){
		
	}
	public Perguntas() {

	
	}
	
	public Perguntas(int id, int avaliacao, String pergunta, String alternativas1, String alternativas2,
			String alternativas3, String correta) {
		this.id = id;
		this.avaliacao = avaliacao;
		this.pergunta = pergunta;
		this.alternativas1 = alternativas1;
		this.alternativas2 = alternativas2;
		this.alternativas3 = alternativas3;
		this.correta = correta;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlternativas1() {
		return alternativas1;
	}

	public void setAlternativas1(String alternativas1) {
		this.alternativas1 = alternativas1;
	}

	public String getAlternativas2() {
		return alternativas2;
	}

	public void setAlternativas2(String alternativas2) {
		this.alternativas2 = alternativas2;
	}

	public String getAlternativas3() {
		return alternativas3;
	}

	public void setAlternativas3(String alternativas3) {
		this.alternativas3 = alternativas3;
	}

	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}


}
