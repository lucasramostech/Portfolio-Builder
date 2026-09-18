// vars
let ativo = false;

// Função que organiza as info base
function mostrarResultado(resposta) {

    const resultadoDiv = document.querySelector("#resultado-texto-1");
    const resultadoDiv2 = document.querySelector("#resultado-texto-2");

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

    resultadoDiv2.innerHTML = `
        <button id="btn-rebalancear" class="btn-rebalancear" type="button">
            <span class="btn-circulo"></span>
        </button>
    `;
    

    // Botão de rebalançear
    const btn = document.querySelector("#btn-rebalancear");
    btn.addEventListener("click", () => {
        ativo = !ativo;
        
        if (ativo) {
            btn.style.backgroundColor = "#1259f1";
            btn.style.justifyContent = "flex-end";
            
        } else {
            btn.style.backgroundColor = "#292828";
            btn.style.justifyContent = "flex-start";  
        }

        console.log("Rebalanceamento acionado");
    });
}
