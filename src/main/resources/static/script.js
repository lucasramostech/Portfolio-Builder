
const btn = document.querySelector("#press");

// Evento de click
btn.addEventListener("click", (event) => {
    event.preventDefault();

    const dados = {
        capitalInicial: document.querySelector("#capital-inicial").value,
        aporteMensal: document.querySelector("#aporte-mensal").value,
        anos: document.querySelector("#periodo").value,
        ativos: [],
    };

    document.querySelectorAll(".ativo").forEach((linha) => {
        const checkbox = linha.querySelector('input[type="checkbox"]');
        const percentual = linha.querySelector('input[type="number"]');

        if (checkbox.checked) {
            dados.ativos.push({
                ticker: checkbox.value,
                percentual: percentual.value
            });

        }
    });


    // Chamada da funçao da APi 
    calcularInvestimentos(dados);

});



async function calcularInvestimentos(dados) {

    try {
    const response = await fetch("/api/hello", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    });

    const resposta = await response.json();
    verificar(resposta);

    } catch (error) {
        console.error("Erro ao calcular investimentos:", error);
    }

}



function verificar(resposta) {
    console.log(resposta);
}