package br.com.tonhao.steps;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Assert;

import br.com.tonhao.entities.Filme;
import br.com.tonhao.entities.NotaAluguel;
import br.com.tonhao.entities.TipoAluguel;
import br.com.tonhao.services.AlguelService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;

public class LocadoraSteps {
	
	private Filme filme;
	private AlguelService aluguelService = new AlguelService();
	private NotaAluguel notaAluguel;
	private Throwable error;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;
	
	
	@Dado("um filme com estoque de {int} unidades")
	public void um_filme_com_estoque_de_unidades(Integer int1) {
		filme = new Filme();
		
		filme.setEstoque(int1);
	}

	@Dado("que o preço do aluguel seja de R$ {int}")
	public void que_o_preço_do_aluguel_seja_de_r$(Integer int1) {
		filme.setAluguel(Double.valueOf(int1));
	}
	
	@Quando("alugar")
	public void alugar() {
		try {
			notaAluguel = aluguelService.alugar(filme, tipoAluguel);
		}catch(Exception e) {
			error = e;
		}
	}
	
	@Então("o preço do aluguel será de R$ {int}")
	public void o_preço_do_aluguel_será_de_r$(Integer int1) {
		Assert.assertEquals(Double.valueOf(int1), notaAluguel.getPreco(), 0);
	}
	
	@Então("a data de entrega será após {int} dias")
	public void a_data_de_entrega_será_apos_dias(Integer int1) {
		LocalDate data = LocalDate.now().plusDays(int1);
		
		LocalDate dataEntrega = notaAluguel.getDataEntrega();
		Assert.assertEquals(data, dataEntrega);
	}
	
	@Então("o estoque do filme será {int} unidades")
	public void o_estoque_do_filme_será_unidades(Integer int1) {
		Assert.assertEquals(int1, filme.getEstoque(), 0);
	}
	
	@Então("não será possível por falta de estoque")
	public void não_será_possível_por_falta_de_estoque() {
		Assert.assertNotNull(error);
		System.out.println(error.getMessage());
	}

	@Dado("que o tipo do aluguel seja {string}")
	public void que_o_tipo_do_aluguel_seja(String string) {
		tipoAluguel = TipoAluguel.getByDescricao(string);
	}
	
	@Então("a pontuação recebida será de {int} pontos")
	public void a_pontuação_recebida_será_de_pontos(Integer int1) {
		Assert.assertEquals(int1, notaAluguel.getPontuacao(), 0);
	}
	
	@Dado("um filme")
	public void um_filme(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Integer.parseInt(map.get("preco")));
		tipoAluguel = TipoAluguel.getByDescricao(map.get("tipo"));
		
	}
	
}
