
// Campo de busca de ativos
const busca = document.querySelector("#busca-ativo");
const resultados = document.querySelector("#sugestoes-ativos");

const tickers = ["MSFT", "AAPL", "AMZN", "QQQ", "KO"];

busca.addEventListener("input", () => {
    const texto = busca.value.toUpperCase();

    const encontrados = tickers.filter((ticker) =>
        ticker.includes(texto)
    );

    resultados.innerHTML = encontrados
        .map((ticker) => `<button type="button" class="sugestao-ativo" data-ticker="${ticker}">${ticker}</button>`)
        .join("");
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
    } else {
        document.querySelector(".lista-ativos").insertAdjacentHTML("beforeend", `
            <label class="ativo">
                <input type="checkbox" name="ativos" value="${ticker}" checked>
                <span>${ticker}</span>
                <input type="number" name="percentuais" min="0" max="100" step="0.01" placeholder="%">
            </label>
        `);
    }

    busca.value = "";
    resultados.innerHTML = "";
});