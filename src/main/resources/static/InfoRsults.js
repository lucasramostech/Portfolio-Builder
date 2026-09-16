



function mostrarResultado(resposta) {

    const resultadoDiv = document.querySelector("#resultado-texto");

    resultadoDiv.innerHTML = `
        <h2>Capital Final: ${resposta.capitalTotal.toLocaleString("pt-BR", {
            style: "currency",
            currency: "BRL"
        })}</h2>
        <p>Total Investido: ${resposta.totalInvestido.toLocaleString("pt-BR", {
            style: "currency",
            currency: "BRL"
        })}</p>
        <p>Multiplicador de Capital: ${resposta.multiplicadorCapital.toFixed(2)}</p>
    `;

}