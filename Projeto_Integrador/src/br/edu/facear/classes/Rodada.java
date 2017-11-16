package br.edu.facear.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.facear.util.Arquivo;

public class Rodada {

	private int idRodada;
	private Pergunta pergunta;
	private Jogo jogo;
	private boolean perguntaRes;
	private Date data;

	public Rodada() {

	}

	public int getIdRodada() {
		return idRodada;
	}

	public void setIdRodada(int idRodada) {
		this.idRodada = idRodada;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public boolean isPerguntaRes() {
		return perguntaRes;
	}

	public void setPerguntaRes(boolean perguntaRes) {
		this.perguntaRes = perguntaRes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String Cadastrar(boolean acrescentar) {
		String ret = null;

		try {

			String linha = this.idRodada + ";" + this.getPergunta().getId() + ";" + this.getJogo().getId() + ";"
					+ this.getJogo().getJogador1().getId() + ";" + this.getJogo().getJogadorVez().getId() + ";" + this.perguntaRes;

			Arquivo arq = new Arquivo();
			arq.setNome("Rodada.txt");
			arq.setTexto(linha);
			arq.setAcrescentar(acrescentar);
			arq.Gravar();

			ret = "OK";
		} catch (Exception e1) {
			ret = "ERRO";
		}

		return ret;

	}

	public void EscolherPergunta() {
		Pergunta pergunta = new Pergunta();
		List<Pergunta> object1 = pergunta.Ler();
		int ID = new Random().nextInt(object1.size());
		this.setPergunta(pergunta.buscarPerguntas(ID));
		List<Rodada> object2 = this.Ler();
		for (Rodada rodada : object2) {
			if (rodada.getJogo().getId() == 0) {
				if (getPergunta().getId() == rodada.getPergunta().getId())
					EscolherPergunta();
			}
		}
	}

	public List<Rodada> listaRodada(int id) {
		List<Rodada> listaRetorno = new ArrayList<Rodada>();

		List<Rodada> lista = Ler();

		for (Rodada rodada : lista) {
			if (rodada.getJogo().getId() == id)
				listaRetorno.add(rodada);
		}
		return listaRetorno;
	}

	public List<Rodada> Ler() {
		// lista para retornar do m�todo
		List<Rodada> listaRetorno = new ArrayList<Rodada>();

		// recuperar a lista de strings do txt
		Arquivo arq = new Arquivo();
		arq.setNome("Rodada.txt");
		List<String> lista = arq.Ler();

		// percorrer a lista de strings
		for (String linha : lista) {
			// para cada linha
			String[] vetdados = linha.split(";");

			// -> adicionar em um objeto
			Rodada rodada = new Rodada();
			int id = Integer.parseInt(vetdados[0]); // Id
			rodada.setIdRodada(id);

			int idPergunta = Integer.parseInt(vetdados[1]);
			Pergunta pergunta = new Pergunta();
			pergunta.setId(idPergunta);
			rodada.setPergunta(pergunta);

			int idJogo = Integer.parseInt(vetdados[2]); // Id
			Jogo jogo = new Jogo();
			jogo.setId(idJogo);
			rodada.setJogo(jogo);

			int idJogador = Integer.parseInt(vetdados[3]); // Id
			Jogador jogador = new Jogador();
			jogador.setId(idJogador);
			rodada.getJogo().setJogador1(jogador);
			
			int idVez = Integer.parseInt(vetdados[4]);
			jogador = new Jogador();
			jogador.setId(idVez);
			rodada.getJogo().setJogadorVez(jogador);
			
			boolean PerguntaRes = Boolean.parseBoolean(vetdados[5]);
			rodada.setPerguntaRes(PerguntaRes);

			// -> adicionar na lista de retorno
			listaRetorno.add(rodada);

		}

		return listaRetorno;
	}

	public void Salvar(List<Rodada> lista) {
		int cont = 0;
		for (Rodada rodada : lista) {
			if (cont == 0) {
				rodada.Cadastrar(false);
			} else
				rodada.Cadastrar(true);
			cont++;
		}
	}

}