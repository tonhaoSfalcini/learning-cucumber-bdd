package br.com.tonhao.steps;
import java.time.LocalDate;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("que criei o arquivo corretamente")
	public void que_criei_o_arquivo_corretamente() {
	}

	@Quando("executá-lo")
	public void executá_lo() {
	}

	@Entao("a especificação deve finalizar com sucesso")
	public void a_especificação_deve_finalizar_com_sucesso() {
	}



	private int contador = 0;
	@Dado("que o valor do contador é {int}")
	public void que_o_valor_do_contador_é(Integer int1) {
		contador = int1;
	}
	@Quando("eu incrementar em {int}")
	public void eu_incrementar_em(Integer int1) {
		contador = contador + int1;
	}

	@Então("o valor do contador será {int}")
	public void o_valor_do_contador_será(Integer int1) {
		Assert.assertEquals(Double.valueOf(contador), Double.valueOf(int1));
	}

	private static LocalDate data = LocalDate.now();

	@Dado("que a entrega é dia {int}\\/{int}\\/{int}")
	public void que_a_entrega_é_dia(Integer day, Integer month, Integer year) {
		data = LocalDate.of(year, month, day);
	}

	@Quando("a entrega atrasar em {int} dias")
	public void a_entrega_atrasar_em_dias(Integer int1) {
		data = data.plusDays(int1);
	}

	@Então("a entrega será efetuada em {int}\\/{int}\\/{int}")
	public void a_entrega_será_efetuada_em(Integer day, Integer month, Integer year) {
		Assert.assertEquals(data, LocalDate.of(year, month, day));
	}

	@Quando("a entrega atrasar em {int} meses")
	public void a_entrega_atrasar_em_meses(Integer int1) {
		data = data.plusMonths(int1);
	}



	@Dado("que o ticket é {string}")
	public void que_o_ticket_é(String arg1) {
	}

	@Dado("que o ticket especial é {string}")
	public void que_o_ticket_especial_é(String string) {
	}

	@Dado("que o valor da passagem é R$ {double}")
	public void que_o_valor_da_passagem_é_r$(Double double1) {
	}

	@Dado("que o nome do passageiro é {string}")
	public void que_o_nome_do_passageiro_é(String string) {
	}

	@Dado("que o telefone do passageiro é {string}")
	public void que_o_telefone_do_passageiro_é(String string) {
	}

	@Quando("criar os steps")
	public void criar_os_steps() {
	}

	@Então("o teste vai funcionar")
	public void o_teste_vai_funcionar() {
	}
}