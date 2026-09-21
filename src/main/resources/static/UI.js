
// Campo de busca de ativos
const busca = document.querySelector("#busca-ativo");
const resultados = document.querySelector("#sugestoes-ativos");

// Todas as ações ou tickers
const tickers = [
    "MSFT", "NVDA", "GOOGL", "META", "AAPL", "TSLA", "JPM", "AMZN",
    "INTC", "PG", "AMD", "UNH", "CRM", "DIS", "QQQ", "KO",
    "SPY", "IWM", "VTI", "DIA", "WMT", "XOM", "LLY", "MA",
    "V", "HD", "COST", "CVX", "ABBV", "PEP", "BAC", "AVGO",
    "WFC", "TMO", "CSCO", "MCD", "ABT", "MRK", "ACN", "ORCL",
    "IBM", "GE", "CAT", "NFLX", "ADBE", "QCOM", "TXN", "AMAT",
    "HON", "LOW", "BKNG", "NKE", "SBUX", "AMGN", "PFE", "UPS",
    "MS", "GS", "BLK", "SCHW", "MDT", "DE", "LMT", "NOW",
    "ISRG", "SCHD", "VOE", "XLK", "XLF", "XLE", "Fixed-Rate"
];

busca.addEventListener("input", () => {
    const texto = busca.value.toUpperCase();

    const encontrados = tickers.filter((ticker) =>
        ticker.includes(texto)
    );

    resultados.innerHTML = encontrados.map((ticker) => `<button type="button" class="sugestao-ativo" data-ticker="${ticker}">${ticker}</button>`).join("");
});


// Caso clicado add na div e no value
resultados.addEventListener("click", (event) => {
    const botao = event.target.closest(".sugestao-ativo");

    if (!botao) {
        return;
    }

    const ticker = botao.dataset.ticker;
    const ativoExistente = document.querySelector(`.ativo input[value="${ticker}"]`);

    if (ativoExistente) {
        ativoExistente.checked = true;
        ativoExistente.closest(".ativo").querySelector('input[type="number"]').focus();
        busca.value = "";
        resultados.innerHTML = "";
        return;
    }

    const campo = document.querySelector(".lista-ativos");

    campo.insertAdjacentHTML("beforeend", `
        <label class="ativo">
            <input type="checkbox" name="ativos" value="${ticker}" checked>
            <span>${ticker}</span>
            <input type="number" name="percentuais" min="0" max="100" step="0.01" placeholder="%">
            <button type="button" class="remover-ativo">X</button>
        </label>
    `);

    if (ticker === "Fixed-Rate") {
        campo.insertAdjacentHTML("beforeend", `
            <label class="ativo fix-rate-item">
                <span>Taxa anual</span>
                <input type="number" name="taxa-fixa-anual" min="0" max="100" step="0.01" placeholder="% a.a">
                <button type="button" class="remover-ativo">X</button>
            </label>
        `);
    }

    busca.value = "";
    resultados.innerHTML = "";
});


// Botão de fechar/tirar o ativo da tela
document.querySelector(".lista-ativos").addEventListener("click", (event) => {
    const botao = event.target.closest(".remover-ativo");

    if (!botao) {
        return;
    }
    botao.closest(".ativo").remove();
});