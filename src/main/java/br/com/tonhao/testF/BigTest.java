package br.com.tonhao.testF;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class BigTest {

	
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.format(DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss")));		
		;		
	}
	
}
