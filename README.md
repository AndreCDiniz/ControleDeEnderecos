
# API REST para controle de uma lista de endereços por usuário

### Link do artigo explicando detalhadamente como tudo foi criado do zero:
* **[Medium](https://andrefcd23.medium.com/criando-uma-api-rest-para-controle-de-uma-lista-de-endere%C3%A7os-por-usu%C3%A1rio-utilizando-spring-26783c9be1fe)**

## Objetivo

* **Primeiro passo** deve ser a construção de um cadastro de usuários, sendo obrigatório dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos. Construir a API em um banco de dados local

* **Segundo passo** é criar um cadastro de endereços, sendo obrigatório dados mínimos para cadastro como: logradouro, número, complemento, bairro, cidade, estado e CEP, associando este endereço ao usuário.

* **Terceiro passo** é criar um endpoint que retornará um usuário com a lista de todos seus endereços cadastrados.

Devemos construir 3 endpoints neste sistema, o cadastro do usuário, o cadastro de endereços e a listagem dos endereços de um usuário específico.
\- Caso os cadastros estejam corretos, **é necessário** voltar o Status 201, caso haja erros de preenchimento de dados, o Status deve ser 400.
\- Caso a busca esteja correta, **é necessário** voltar o status 200, caso haja erro na busca, retornar o Status adequado e uma mensagem de erro amigável.

## Tecnologias Utilizadas:

* :computer: ECLIPSE Java EE
* :space_invader: Maven
* :heavy_check_mark: Spring boot 
* :black_circle: Insomnia
* :books: MySQL Database




