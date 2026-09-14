# Portfolio Builder

Projeto incremental de uma calculadora de investimentos desenvolvida com Spring Boot.

A aplicação será evoluída para simular carteiras com capital inicial, aportes mensais,
ações americanas, percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 0.9

A versão 0.9 contém:

- formulário para configurar capital, aportes, período e ativos;
- integração com a Twelve Data e persistência no PostgreSQL/Neon;
- histórico mensal das variações dos ativos;
- cálculo mensal da carteira com percentuais de alocação;
- aplicação dos aportes e retorno do histórico do capital no campo `resultado`;
- atualização automática do histórico no banco com `@Scheduled`;
- classe `UpScheduled` para buscar os dados da Twelve Data e atualizar os ativos;
- Maven Wrapper para execução do projeto.


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
│   │   ├── ApiRequest.java
│   │   ├── Ativo.java
│   │   ├── AtivoRepository.java
│   │   ├── SalvarDados.java
│   │   ├── UpScheduled.java
│   │   └── MainService.java
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
- Permitir ler o historico diretamente do banco sem consultar a API a cada requisicao;
- Exibir a evolução da carteira em tabela e gráfico.

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
