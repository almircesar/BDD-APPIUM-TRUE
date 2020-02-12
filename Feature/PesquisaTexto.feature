#language: pt
Funcionalidade: Pesquisar produtos pela Barra de Pesquisa

  Cenario: Pesquisar produto pela Barra de Pesquisa
    Dado que estou na tela principal
    Quando digito o produto desejado
    E escolho o produto desejado
    Entao deve estar na tela do produto desejado

  Cenario: Pesquisa produto invalido pela Barra de Pesquisa
    Dado que estou na tela principal
    Quando digito o produto invalido
    Entao deve estar na tela de produto nao encontrado
