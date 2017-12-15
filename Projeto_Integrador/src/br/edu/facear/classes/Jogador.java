package br.edu.facear.classes;

import java.util.ArrayList;
import java.util.List;

import br.edu.facear.util.Arquivo;

public class Jogador {
	private int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private String telefone;
	private int pontos;
	private int nivel;
	private String confirma;
	private int horcrux;
	private static Jogador logado;
	private String imagem;
	
	public Jogador(){
		
	}
	
	public static Jogador getInstance() {
		if (logado == null) {
			logado = new Jogador();
		}
		return logado;
	}
		
	public static Jogador getLogado() {
		return logado;
	}


	public static void setLogado(Jogador logado) {
		Jogador.logado = logado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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

	public String getConfirma() {
		return confirma;
	}

	public void setConfirma(String confirma) {
		this.confirma = confirma;
	}

	public int getHorcrux() {
		return horcrux;
	}

	public void setHorcrux(int horcrux) {
		this.horcrux = horcrux;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String Logar() {
		String ret = null;
		List<Jogador> listaObjectJog = this.Ler();
		for (Jogador jog1 : listaObjectJog) {
			if (jog1.login.equals(this.login) && jog1.senha.equals(this.senha)) {	
				Jogador.setLogado(this.Ler(jog1.id));
				ret = "OK";
				break;
			} else
				ret = "ERRO";
		}
		return ret;
	}
	
	public String Existente() {
		String ret = null;
		List<Jogador> listaObjectJog = this.Ler();
		for (Jogador jog1 : listaObjectJog) {
			if (jog1.login.equals(this.login)) {				
				ret = "OK";
				break;
			} else
				ret = "ERRO";
		}
		return ret;
	}
	public String Cadastrar() {
		String ret = null;
		if (this.senha.equals(this.confirma)) {
			List<Jogador> listaObjectJog = this.Ler();
			
			this.setId(listaObjectJog.size()+1);
			
				String linha = this.id + ";" + this.nome + ";" + this.login + ";" + this.senha + ";" + this.telefone + ";"
						+ this.idade + ";" + this.nivel  +  ";" + this.pontos + ";" + this.horcrux ;
				
				Arquivo arq = new Arquivo();
				arq.setNome("Jogador.txt");
				arq.setTexto(linha);
				arq.Gravar();
			
				ret = "OK";
			
		}else
			ret = "ERRO";
			
		return ret;

	}
	
	public String Cadastrar(boolean acrescentar) {
		String ret = null;

		if (acrescentar) {
			List<Jogador> listaObjectJog = this.Ler();
			this.setId(listaObjectJog.size());

		}
		
		try {
			
			String linha = this.id + ";" + this.nome + ";" + this.login + ";" + this.senha + ";" + this.telefone + ";"
					+ this.idade + ";" + this.getNivel() + ";" + this.pontos + ";" + this.getHorcrux() + ";" + this.getImagem();

			Arquivo arq = new Arquivo();
			arq.setNome("Jogador.txt");
			arq.setAcrescentar(acrescentar);
			arq.setTexto(linha);
			arq.Gravar();

			ret = "OK";
		} catch (Exception e1) {
			ret = "ERRO";
		}

		return ret;

	}

	public List<Jogador> Ler() {
		// lista para retornar do m�todo
		List<Jogador> listaRetorno = new ArrayList<Jogador>();

		// recuperar a lista de strings do txt
		Arquivo arq = new Arquivo();
		arq.setNome("Jogador.txt");
		List<String> lista = arq.Ler();

		// percorrer a lista de strings
		for (String linha : lista) {
			// para cada linha
			String[] vetdados = linha.split(";");

			// -> adicionar em um objeto
			Jogador jogador = new Jogador();
			int id = Integer.parseInt(vetdados[0]); // Id
			jogador.setId(id);
			jogador.setNome(vetdados[1]); // Nome
			jogador.setLogin(vetdados[2]);
			jogador.setSenha(vetdados[3]);
			jogador.setTelefone(vetdados[4]);
			int idade = Integer.parseInt(vetdados[5]);
			jogador.setIdade(idade);
			int nivel = Integer.parseInt(vetdados[6]);
			jogador.setNivel(nivel);
			int pontos = Integer.parseInt(vetdados[7]); // Id
			jogador.setPontos(pontos);
			int horcrux = Integer.parseInt(vetdados[8]);
			jogador.setHorcrux(horcrux);
			jogador.setImagem(vetdados[9]);
			
			
			// -> adicionar na lista de retorno
			listaRetorno.add(jogador);

		}
		return listaRetorno;

	}
	
	//Buscar
	public Jogador Ler(int ID){
		Jogador jogadorRetorno = null;
		Jogador jog = new Jogador();
		List<Jogador> listaObjectJog = jog.Ler();
		for (Jogador jog1 : listaObjectJog) {
			if(jog1.getId() == ID)
				jogadorRetorno = jog1;
		}
		return jogadorRetorno;

	}
	
	public void Salvar(List<Jogador> lista){
		int cont = 0;
		for (Jogador jogador : lista) {
			if(cont == 0){
				jogador.Cadastrar(false);
			}else
				jogador.Cadastrar(true);	
			cont++;
		}		
	}
	
	public void editarFoto(){
		List<Jogador> lista = Ler();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == Jogador.getInstance().getId()) {
				lista.get(i).setImagem(getImagem());
			}
		}
		this.Salvar(lista);
	}
}