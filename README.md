# Portfolio Builder

Projeto incremental de uma calculadora de investimentos desenvolvida com Spring Boot.

A aplicação será evoluída para simular carteiras com capital inicial, aportes mensais,
ações americanas, percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 0.5

A versão 0.5 contém:

- aplicação Spring Boot com Java 17, executada na porta `8081`;
- formulário para montar uma carteira com capital, aportes, período e ativos;
- endpoint `POST /api/hello` para consultar o histórico mensal dos ativos;
- lista fixa de ativos consultados pela API: `AAPL`, `MSFT`, `NVDA`, `AMZN` e `GOOGL`;
- integração com a API Twelve Data para buscar os dados históricos mensais;
- banco de dados online Neon configurado e Maven Wrapper para executar o projeto.


## Tecnologias

- Java 17;
- Spring Boot;
- Spring Web;
- Maven;
- Neon Database (PostgreSQL);
- HTML, CSS e JavaScript.

## Como executar

Deploy disponível na versão 1.0 (In soon)

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
