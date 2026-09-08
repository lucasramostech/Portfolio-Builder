# Portfolio Builder

Projeto incremental de uma calculadora de investimentos desenvolvida com Spring Boot.

A aplicação será evoluída em versões para simular carteiras com capital inicial, aportes mensais, ações, ETFs e evolução do patrimônio ao longo do tempo.

## Versão atual: 0.1

Esta primeira versão contém o esqueleto funcional do servidor (apenas o básico para começar)

- Aplicação Spring Boot configurada;
- Java 17;
- Servidor HTTP na porta `8081`;
- Endpoint de teste `GET /api/hello`;
- Maven Wrapper para executar o projeto;
- Configuração inicial do banco H2.

O endpoint de teste também pode ser acessado pela rota `/`.

## Tecnologias

- Java 17;
- Spring Boot;
- Spring Web;
- Maven;
- H2 Database.

## Como executar

Deploy disponível no lançamento da versão 1.0 


## Estrutura principal

```text
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── Main.java
│   │   └── Controller.java
│   └── resources/
│       ├── application.properties
│       └── static/index.html
└── test/
```

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
