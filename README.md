# Portfolio Builder

Acesse: https://portfolio-builder-yva7.onrender.com/

Este projeto foi criado para solucionar uma dor real de investidores: entender como
aportes mensais, diferentes ativos e percentuais de alocação podem impactar o crescimento
de uma carteira ao longo do tempo. A proposta é transformar esses dados em uma simulação
simples e visual, ajudando o investidor a tomar decisões com mais clareza.

Calculadora de investimentos desenvolvida com Spring Boot.

A aplicação simula carteiras com capital inicial, aportes mensais, ativos americanos,
percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 1.6

Esta versão inclui a seleção de intervalos de tempo da simulação, permitindo comparar resultados em 3, 5, 7 e 10 anos, além da opção de "Máximo disponível", e exibe os anos no eixo e no tooltip do gráfico.

## Funcionalidades

- Formulário para informar capital inicial, aporte mensal, período e ativos;
- Seleção de intervalo de simulação: 3, 5, 7, 10 anos ou máximo disponível;
- Busca de ativos por ticker;
- Seleção, definição do percentual e remoção de cada posição da carteira;
- Validação da soma dos percentuais antes da simulação, exigindo exatamente 100%;
- Ativos disponíveis configurados no `application.properties`;
- Integração com a Twelve Data para consultar históricos mensais de ações dos EUA;
- Persistência dos ativos e das variações no PostgreSQL/Neon;
- Cálculo de juros compostos com aportes mensais e retorno ponderado;
- Retorno estruturado com capital total, total investido, multiplicador de capital e evolução mensal;
- Exibição dos indicadores calculados junto com o gráfico;
- Gráfico interativo com Chart.js para visualizar a evolução da carteira;
- Exibição dos anos da simulação no eixo e no tooltip do gráfico;
- Escala logarítmica, valores em reais e tooltip no gráfico;
- Atualização automática dos dados por intervalo configurado no `UpScheduled`;
- Consulta de um ticker por vez na Twelve Data;
- Atualização inicial dos dados ao iniciar a aplicação;
- Interface com tema preto, verde e branco inspirado no Xbox;
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
│       ├── static/
│           ├── index.html
│           ├── style.css
│           ├── UI.js
│           ├── script.js
│           ├── MainChart.js
│           └── InfoRsults.js
└── test/
```

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
