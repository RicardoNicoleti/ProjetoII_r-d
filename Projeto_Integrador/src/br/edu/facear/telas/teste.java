package br.edu.facear.telas;

public class teste {

	public static void main(String[] args) {
//		Pergunta pergunta = new Pergunta();
//		List<Pergunta> lista1 = pergunta.Ler();
//		List<Pergunta> lista2 = new ArrayList<Pergunta>();
////		int ID = new Random().nextInt(6) + 1;
//		int ID = 6;
//		for (Pergunta pergunta2 : lista1) {
//			if (pergunta2.getCategoria().getId() == ID && pergunta2.getAvaliacao() >= 5) {
//				lista2.add(pergunta2);
//			}
//		}
//		int ID1 = new Random().nextInt(lista2.size());
//		pergunta.buscarPerguntas(ID1);
//		
		
		
//		Jogo jogo = new Jogo();
//		jogo.EscolherPergunta1();
//		System.out.println(jogo.getPergunta().getId());
		
//		int x = 99;
//		
//		if(x %10==0){
//			System.out.println("aqui");
//		}else
//			System.out.println("n�o");
		
		
//		Jogo jogo = new Jogo();
//		jogo.IniciarJogo();
		
//		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
//		List<Integer> inteiros = new ArrayList<Integer>();
//		inteiros.add(10);
//		inteiros.add(1);
//		inteiros.add(10);
//		inteiros.add(2);
//		inteiros.add(10);
//		inteiros.add(7);
//		inteiros.add(10);
//		inteiros.add(5);
//		inteiros.add(5);
//		Iterator<Integer> it = inteiros.iterator();
//		while(it.hasNext()) {
//			Object obj = it.next();
//			int frequency = Collections.frequency(inteiros, obj);
//			map.put(String.valueOf(obj), frequency);
//			
//		}
//		System.out.println(map);
		
//		Pergunta p = new Pergunta();
//		Jogo j = new Jogo();
//		Rodada rodada = new Rodada();
//		rodada.setIdRodada(6);
//		rodada.setPergunta(p.buscarPerguntas(5));
//		rodada.setJogo(j.Ler(0));
//		rodada.Cadastrar(true);
		
		
//		Pergunta pergunta = new Pergunta();
//		List<Pergunta> lista = pergunta.Ler();
//		for (Pergunta pergunta2 : lista) {
//			if(pergunta2.getCategoria().getId() == 1){
//				Categoria categoria = new Categoria();
//				System.out.println(categoria.listaCategoria(pergunta2.getCategoria().getId()));
//				System.out.println(pergunta2.getPergunta());
//			
//			}
//			
//		}
		
//		for (Jogo jogo2 : lista) {
//			System.out.println(jogo2.getRodada().get(1).getPergunta().getId());
//		}
//		
//		List<Jogo> listaJogo = jogo.Ler();
//		for (Rodada rodada : jogo.getRodada()) {
//			System.out.println(rodada);
//		}
		
//		List<Rodada> listaTeste = new Jogo().getRodada();
//		for (Rodada rodada : listaTeste) {
//			System.out.println(rodada);
//		}
		
//		//Metodo buscar jogo
//		Jogo jogo = new Jogo();
//		List<Jogo> lista1 = jogo.Ler();
//		Rodada rodada1 = new Rodada();
//		for (Jogo jogo2 : lista) {
//			if(jogo2.isFinalizado())
//				System.out.println(jogo2.getId());
//				for (Rodada rodada : jogo2.getRodada()) {
//					if(!rodada.isPerguntaRes())
//						System.out.println(rodada.getIdRodada());
//	
//				}
				
//			}
			
		//Metodo buscar pergunta
//			Scanner teclado = new Scanner(System.in);
//			int intec  = teclado.nextInt();
//			int cont = 0;
//			int cont1 = 0; 
//			int cont2 = 0;
//			for (Jogo jogo2 : lista1) {
//				if(jogo2.getId() == intec)
//					for (Rodada rodada : jogo2.getRodada()) {
//					if (pergunta.buscarPerguntas(rodada.getPergunta().getId()).getCategoria().getId() == 1){
//						cont++;	
//					}else if(pergunta.buscarPerguntas(rodada.getPergunta().getId()).getCategoria().getId() == 2){
//						cont1++;	
//					}else if(pergunta.buscarPerguntas(rodada.getPergunta().getId()).getCategoria().getId() == 3){
//						cont2++;
//					}
//				}
//				
//			}
//			if(cont < 2){
//				System.out.println("cont 1 = " + cont);
//			}else if(cont1 < 2){
//				System.out.println("cont 2 = " + cont1);
//			}else if(cont2 < 2)
//				System.out.println("cont 2 =" + cont2);

//			Rodada rodada = new Rodada();
//			List<Rodada> lista = rodada.Ler();
//			for (Rodada rodada1 : lista) {
//				if(rodada.getIdRodada() == 0){
//					rodada.setIdRodada(rodada1.getIdRodada()+1);
//				}
//			}	
//			System.out.println(rodada.getIdRodada());
			
			
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(jogo.getRodada().get(i));
//		}
				
//		List<Rodada> lista = new ArrayList<Rodada>();
//		
//		Jogador j = new Jogador();
//		Pergunta p = new Pergunta();
//		Rodada r = new Rodada();
//		
//		r.setJogador(j.Ler(1));
//		r.setPerguntaFeita(true);
//		
//		lista.add(r);
//		
//		new Rodada().Salvar(lista);
		
		
		
		//Metodo atualizar status
		
//		List<Rodada> lista3 = new Rodada().Ler();		
//		 for (int i = 0; i < lista3.size(); i++) {
//			 if (lista3.get(i).getJogo().getId() == 1){
//				 lista3.get(i).setPerguntaRes(false);
//			 }		
//		}
////		 
//		 new Rodada().Salvar(lista3);
//		 System.out.println("OK");


//		 List<Jogador> lista = new Jogador().Ler();
//		 for (int i = 0; i < lista.size(); i++) {
//			 if (lista.get(i).getId() == 4){
//				 lista.get(i).setLogin("teste");
//				 lista.get(i).setNome("teste1");
//				 lista.get(i).setHorcrux(300);
//			 }
//				
//		}
//		 
//		 new Jogador().Salvar(lista);
//		 System.out.println("OK");
//
	}
}