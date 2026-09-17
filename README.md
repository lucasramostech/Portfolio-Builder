# Portfolio Builder

Acesse: https://portfolio-builder-yva7.onrender.com/

Este projeto foi criado para solucionar uma dor real de investidores: entender como
aportes mensais, diferentes ativos e percentuais de alocação podem impactar o crescimento
de uma carteira ao longo do tempo. A proposta é transformar esses dados em uma simulação
simples e visual, ajudando o investidor a tomar decisões com mais clareza.

Calculadora de investimentos desenvolvida com Spring Boot.

A aplicação simula carteiras com capital inicial, aportes mensais, ativos americanos,
percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 1.2

Esta versão consolidada inclui correções de sincronização de ativos, ajuste do fluxo de persistência e atualização da lista de ações disponíveis para simulação.

## Funcionalidades

- Formulário para informar capital inicial, aporte mensal, período e ativos;
- Seleção de ativos e definição do percentual de cada posição;
- Ativos disponíveis na simulação: AAPL, MSFT, NVDA, AMZN, GOOGL, META, TSLA, JPM;
- Integração com a Twelve Data para consultar históricos mensais de ações dos EUA;
- Persistência dos ativos e das variações no PostgreSQL/Neon;
- Cálculo de juros compostos com aportes mensais e retorno ponderado;
- Retorno estruturado com capital total, total investido, multiplicador de capital e evolução mensal;
- Exibição dos indicadores calculados junto com o gráfico;
- Gráfico interativo com Chart.js para visualizar a evolução da carteira;
- Escala logarítmica, valores em reais e tooltip no gráfico;
- Atualização automática dos dados diariamente às 2h;
- Atualização inicial dos dados ao iniciar a aplicação;
- Ajustes de consistência de tickers e limpeza de dados legados;
- Maven Wrapper para compilação e execução do projeto.

## Tecnologias

- Java 17;
- Spring Boot 3.2.5;
- Spring Web e Spring Data JPA;
- Maven;
- PostgreSQL/Neon;
- Twelve Data;
- HTML, CSS, JavaScript e Chart.js.

## Como executar

Acesse: https://portfolio-builder-yva7.onrender.com/

O backend está hospedado no Render e utiliza o PostgreSQL do Neon para persistir os dados.


## Docker

O Dockerfile usa Java 17 e a variável `PORT`, com valor padrão `8081`.
Antes de criar a imagem, atualize no Dockerfile o nome do JAR para corresponder à versão
declarada no `pom.xml` (`demo-1.0.jar`).


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
│   │   ├── MainService.java
│   │   └── ResultadoInvestimento.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           ├── index.html
│           ├── style.css
│           ├── script.js
│           ├── MainChart.js
│           └── InfoRsults.js
└── test/
```

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
