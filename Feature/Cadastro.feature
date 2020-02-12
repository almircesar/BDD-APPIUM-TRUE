#language: pt
Funcionalidade: Cadastro de novas contas

  Cenario: Cadastro de conta valida
    Dado que estou na tela de cadastro
    Quando eu preencho todos os campos obrigatorios
    Entao deve retornar para a pagina inicial logado na conta criada

  Cenario: Cadastro de conta invalida
    Dado que estou na tela de cadastro
    Quando eu preencho todos os campos obrigatorios, exceto o email
    Entao o botao de registrar deve estar indisponivel para cliques
