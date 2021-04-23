#language: pt
@funcionais
Funcionalidade: Cadastro de contas
Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Contexto:
Dado que desejo adicionar uma conta

Esquema do Cenário: Deve validar regras de cadastro de contas
Quando adiciono a conta <conta>
Então recebo a mensagem <mensagem>

Exemplos:
|conta 						| mensagem														|
|"Conta de Teste"	| "Conta adicionada com sucesso!"			|
|""								| "Informe o nome da conta"						|
|"Conta de Teste"	| "Já existe uma conta com esse nome!"|

#Contexto:
#Dado que estou acessando a aplicação
#Quando informo o usuário "tonhaosfalcini@gmail.com"
#E a senha "123456"
#E seleciono entrar
#Então visualizo a página inicial
#Quando seleciono Contas
#E seleciono Adicionar
#
#Esquema do Cenário: Deve validar regras de cadastro de contas
#Quando informo a conta <conta>
#E seleciono Salvar
#Então recebo a mensagem <mensagem>
#
#Exemplos:
#|conta 						| mensagem														|
#|"Conta de Teste"	| "Conta adicionada com sucesso!"			|
#|""								| "Informe o nome da conta"						|
#|"Conta de Teste"	| "Já existe uma conta com esse nome!"|

#Cenário: Deve inserir uma conta com sucesso
#E informo a conta "Conta de Teste"
#E seleciono Salvar
#Então a conta é inserida com sucesso

#Cenário: Não deve inserir uma conta sem nome
#E informo a conta ""
#E seleciono Salvar
#Então sou notificado que o nome da conta é obrigatório

#Cenário: Não deve inserir uma conta com nome já existente
#E informo a conta "Conta de Teste"
#E seleciono Salvar
#Então sou notificado que já existe uma conta com esse nome