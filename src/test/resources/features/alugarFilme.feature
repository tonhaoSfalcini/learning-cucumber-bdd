#language:pt
@unitarios
Funcionalidade: Alugar filme
Como um usuario
Eu quero cadastrar aluguéis de filmes
Para controlar preços e datas de entregas

Cenário: Deve alugar um filme com sucesso
Dado um filme 
	| estoque | 2 			|
	| preco   | 3 			|
	| tipo    | Comum |
Quando alugar
Então o preço do aluguel será de R$ 3
E a data de entrega será após 1 dias
E o estoque do filme será 1 unidades

Cenário: Não deve alugar filmes sem estoque
Dado um filme com estoque de 0 unidades
Quando alugar
Então não será possível por falta de estoque
E o estoque do filme será 0 unidades


Esquema do Cenário: Deve dar condições conforme tipo do aluguel
Dado um filme com estoque de 2 unidades
E que o preço do aluguel seja de R$ <preco>
E que o tipo do aluguel seja <tipoAluguel>
Quando alugar
Então o preço do aluguel será de R$ <valorAluguel>
E a data de entrega será após <diasEntrega> dias
E a pontuação recebida será de <pontuacao> pontos

Exemplos:
|preco | tipoAluguel | valorAluguel | diasEntrega | pontuacao |
|  4   | "Extendido" |       8      |      3      |     2     |
|  4   |   "Comum"   |       4      |      1      |     1     |
|  5   |   "Semanal" |      15      |      7      |     3     |


