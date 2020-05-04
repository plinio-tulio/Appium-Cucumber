@appium
Feature: Produtos
  Eu como usuário quero manter os registros de produtos cadastrados e manter seu estoque.

   Scenario: Cadastrar Produto
    Given que acesso o aplicativo
    When realizo o cadastro de um produto
    Then visualizo todos os dados do produto cadastrado na tela de detalhes do produto
    
  Scenario: Acrescentar quantidade no estoque do produto
    Given que acesso o aplicativo
    And possuo um produto cadastrado
    When realizo uma adicao na quantidade de estoque do produto
    Then visualizo corretamente os dados do produto e estoque atualizado com a inclusao
    
  Scenario: Retirar quantidade no estoque do produto
    Given que acesso o aplicativo
    And possuo um produto cadastrado
    When realizo uma retirada na quantidade de estoque do produto
    Then visualizo corretamente os dados do produto e estoque atualizado com a retirada