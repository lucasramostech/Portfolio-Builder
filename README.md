# Portfolio Builder

Projeto incremental de uma calculadora de investimentos desenvolvida com Spring Boot.

A aplicação será evoluída para simular carteiras com capital inicial, aportes mensais,
ações americanas, percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 0.2

A versão 0.2 contém:

- aplicação Spring Boot configurada;
- Java 17;
- servidor HTTP na porta `8081`;
- formulário HTML para capital inicial, aporte mensal e período;
- seleção de várias ações americanas;
- campo de percentual para cada ação selecionada;
- JavaScript que coleta os dados da carteira;
- endpoint de teste `GET /` e `GET /api/hello`;
- configuração inicial do banco H2;
- Maven Wrapper para executar o projeto.

O JavaScript ainda exibe os dados no console do navegador. O envio para o backend
será implementado nas próximas versões.

## Tecnologias

- Java 17;
- Spring Boot;
- Spring Web;
- Maven;
- H2 Database;
- HTML, CSS e JavaScript.

## Como executar

Deploy disponível na versão 1.0 

## Estrutura principal

```text
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── Main.java
│   │   └── Controller.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           ├── index.html
│           ├── style.css
│           └── script.js
└── test/
```

## Próximas versões

- Enviar os dados para o backend usando `fetch` e `await`;
- Criar o endpoint `POST /api/simular`;
- Criar os DTOs da requisição e da resposta;
- Integrar a API Twelve Data;
- Salvar históricos mensais no H2;
- Calcular variações e retorno da carteira;
- Exibir a evolução da carteira em tabela e gráfico.

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
