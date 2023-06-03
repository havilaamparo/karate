Feature:Cadastrar topicos

@auth
Scenario: cadastrar post
    Given url 'http://localhost:8080/auth'
    And request {"email": "#(email)", "senha": "#(senha)"}
    When method post
    Then status 200
