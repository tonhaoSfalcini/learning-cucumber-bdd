package br.com.tonhao.services;

import java.time.LocalDate;

import br.com.tonhao.entities.Filme;
import br.com.tonhao.entities.NotaAluguel;
import br.com.tonhao.entities.TipoAluguel;

public class AlguelService {
	
	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) throws Exception {
		if(filme.getEstoque() == 0) throw new Exception ("Não foi possível alugar. Filme sem estoque");
		
		
		NotaAluguel notaAluguel = new NotaAluguel();
		
		if(TipoAluguel.EXTENDIDO.equals(tipoAluguel)) {
			notaAluguel.setPreco(filme.getAluguel()*2);
			notaAluguel.setDataEntrega(LocalDate.now().plusDays(3));
			notaAluguel.setPontuacao(2);
		} else if(TipoAluguel.SEMANAL.equals(tipoAluguel)) {
				notaAluguel.setPreco(filme.getAluguel()*3);
				notaAluguel.setDataEntrega(LocalDate.now().plusDays(7));
				notaAluguel.setPontuacao(3);
		} else if(TipoAluguel.COMUM.equals(tipoAluguel)) {
			notaAluguel.setPreco(filme.getAluguel());
			notaAluguel.setDataEntrega(LocalDate.now().plusDays(1));
			notaAluguel.setPontuacao(1);
		}
		
		filme.setEstoque(filme.getEstoque()-1);
		return notaAluguel;
	}
	
}
