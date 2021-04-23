package br.com.tonhao.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NotaAluguel {
	
	private double preco;
	private LocalDate dataEntrega;
	private Integer pontuacao;

}
