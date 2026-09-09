# Portfolio Builder

Projeto incremental de uma calculadora de investimentos desenvolvida com Spring Boot.

A aplicação será evoluída para simular carteiras com capital inicial, aportes mensais,
ações americanas, percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 0.3

A versão 0.3 contém:

- aplicação Spring Boot configurada;
- Java 17;
- servidor HTTP na porta `8081`;
- formulário HTML para capital inicial, aporte mensal e período;
- seleção de várias ações americanas;
- campo de percentual para cada ação selecionada;
- JavaScript que coleta os dados e envia a carteira com `fetch` usando `POST`;
- endpoint `GET /` para verificar a aplicação;
- endpoint `POST /api/hello` para receber os dados da carteira;
- classe `DatasRequest` para receber os dados enviados pelo frontend;
- integração inicial com a API Twelve Data para buscar o histórico mensal do primeiro ativo;
- configuração inicial do banco H2;
- Maven Wrapper para executar o projeto.


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
│   │   ├── Controller.java
│   │   ├── DatasRequest.java
│   │   └── ApiRequest.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           ├── index.html
│           ├── style.css
│           └── script.js
└── test/
```

## Próximas versões

- Validar campos obrigatórios e percentuais da carteira;
- Permitir consultar o histórico de todos os ativos selecionados;
- Salvar históricos mensais no H2;
- Calcular variações e retorno da carteira;
- Exibir a evolução da carteira em tabela e gráfico.

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
