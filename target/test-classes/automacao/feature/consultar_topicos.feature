
@consultar
Feature: pegar topicos

Background: Definir URL

    Given url 'http://localhost:8080'

Scenario: pegar todos os topicos
    Given path '/topicos'
    When method get
    Then status 200
    And print response
    And match response.totalPages == 2
    #And match response.totalPages == '#Number'


