package br.com.tonhao.entities;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoAluguel {

	
	COMUM("Comum"),
	EXTENDIDO("Extendido"),
	SEMANAL("Semanal");
	
	@Getter
	private String descricao;
	
	
	public static TipoAluguel getByDescricao(String descricao) {
		TipoAluguel t = Arrays.asList(TipoAluguel.values()).stream()
		.filter(x -> x.getDescricao().equalsIgnoreCase(descricao))
		.findFirst()
		.orElse(null);
				
		return t;
	}
}
