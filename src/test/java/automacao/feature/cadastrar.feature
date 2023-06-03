@cadastrar
Feature:

Background: 
    * def auth = call read('classpath:automacao/feature/auth.feature'){"email": "aluno@gmail.com", "senha": 123456}
    * def gerador = Java.type('automacao.support.gerador')
    * def body = read('classpath:automacao/feature/payload/cadastrarTopicos.json')
    * def titulo = gerador.getRandomTitulo()
    * def mensagem = gerador.getRandomMensagem()
    * def nome = gerador.getRandomNome()
    Scenario Outline: Cadastrar topicos
    * set body.titulo = titulo
    * set body.mensagem = mensagem
    * set body.nomeCurso = nome

    Given url urlApi
    And path '/topicos'
    And request body
    And header Authorization = 'Bearer ' + auth.response.token
    When method post
    Then status <statusCode>

    Examples: 
    |statusCode|
    |201|
