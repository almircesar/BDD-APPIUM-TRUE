#language: pt
Funcionalidade: Pesquisar produtos pela Home

  Cenario: Pesquisar produto pela Home
    Dado que estou na tela principal
    Quando escolho a categoria desejado
    E escolho o produto desejado
    Entao deve estar na tela do produto desejado

  Cenario: Pesquisa produto pela Home com filtros invalidos
    Dado que estou na tela principal
    Quando escolho a categoria desejado
    E aplico os filtros invalidos
    Entao deve estar na tela de produto nao encontrado
