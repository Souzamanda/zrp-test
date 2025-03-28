# Pokedex Back-end

![SpringBoot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![Java](https://camo.githubusercontent.com/bea90da226e09b503e6c8fde824f4816b98dcf30cd31e803006bf6335af06890/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465) ![Junit](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)

## Sobre

App, desenvolvido como teste para ZRP, que consome a PokeAPI(https://pokeapi.co) e retorna algumas informações do
pokemon quando colocado o nome ou o número na URL. Também possui alguns testes unitários.
As informações retornadas são:

- Nome do pokemon
- Id do pokemon
- Habilidades (em ordem alfabética)
- Tipos do pokemon
- Imagem do pokemon versão normal e versão shiny

Essa parte do projeto foi construído com:

- Springboot
- Maven
- Junit
- Mockito

## Pre-requisitos

- Java 17

## Instrução de instalação

1. Clone o repositório
```bash
git clone https://github.com/your-username/project-name.git
```
2. Instale as dependências com o Maven

## Instrução de uso

1. Inicie a aplicação com Maven
2. A API estará acessível em http://localhost:8080

## API Endpoint

```
GET /pokemon/{pokemonName} - retorna um pokemon específico pelo nome
GET /pokemon/{pokemonId} - retorna um pokemon específico pelo id
```

