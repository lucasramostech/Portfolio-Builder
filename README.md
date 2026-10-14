# Portfolio Builder

Acesse a aplicação: https://portfolio-builder-yva7.onrender.com/

Este projeto foi criado para solucionar uma dor real de investidores: entender como
aportes mensais, diferentes ativos e percentuais de alocação podem impactar o crescimento
de uma carteira ao longo do tempo. A proposta é transformar esses dados em uma simulação
simples e visual, ajudando o investidor a tomar decisões com mais clareza.

Calculadora de investimentos desenvolvida com Spring Boot.

A aplicação simula carteiras com capital inicial, aportes mensais, ativos americanos,
percentuais de alocação e evolução do patrimônio ao longo do tempo.

## Versão atual: 1.9

Esta versão mantém a seleção de intervalos de tempo da simulação (3, 5, 7 e 10 anos ou "Máximo disponível") e o ativo de renda fixa `Fixed-Rate`. Também adiciona pares das principais criptomoedas à lista consultada pela Twelve Data e atualiza o visual do cabeçalho da aplicação.

## Funcionalidades

- Simulação de carteiras com períodos de 3, 5, 7, 10 anos ou máximo disponível;
- Seleção de ativos por ticker e definição de percentuais de alocação;
- Suporte a ações americanas, pares de criptomoedas e renda fixa personalizada;
- Validação da alocação total da carteira, que deve somar 100%;
- Cálculo de juros compostos, aportes mensais e retorno ponderado;
- Exibição de total investido, patrimônio projetado e evolução mensal;
- Gráfico interativo com Chart.js, escala logarítmica e valores em reais;
- Atualização automática dos históricos de mercado por meio da Twelve Data;
- Persistência de ativos e variações em PostgreSQL/Neon.

## Tecnologias

- Java 17;
- Spring Boot 3.2.5;
- Spring Web e Spring Data JPA;
- Maven;
- PostgreSQL/Neon;
- Twelve Data;
- HTML, CSS, JavaScript e Chart.js.

## Como executar

A aplicação está disponível no Render e utiliza o PostgreSQL do Neon para persistência.

Para executar localmente, use o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
./mvnw.cmd spring-boot:run
```


## Docker

O Dockerfile usa Java 17 e a variável `PORT`, com valor padrão `8081`.
Antes de criar a imagem, atualize no Dockerfile o nome do JAR para corresponder à versão
declarada no `pom.xml` (`demo-1.0.jar`).


## Estrutura principal

```text
demo/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/example/demo/
    │   │   ├── Main.java
    │   │   ├── Clients/ApiRequest.java
    │   │   ├── Controllers/Controller.java
    │   │   ├── Databases/
    │   │   │   ├── Ativo.java
    │   │   │   └── AtivoRepository.java
    │   │   ├── dto/
    │   │   │   ├── DatasRequest.java
    │   │   │   └── ResultadoInvestimento.java
    │   │   ├── Scheduled/UpScheduled.java
    │   │   └── Services/
    │   │       ├── MainService.java
    │   │       └── SalvarDados.java
    │   └── resources/
    │       ├── application.properties
    │       └── static/
    │           ├── index.html
    │           ├── style.css
    │           ├── Assets/bull-logo.png
    │           └── Javascript/
    │               ├── UI.js
    │               ├── script.js
    │               ├── MainChart.js
    │               └── InfoRsults.js
    └── test/
```

## Licença

Este projeto está disponível sob a [Licença MIT](LICENSE).
