
const btn = document.querySelector("#press");

// Evento de click
btn.addEventListener("click", (event) => {
    event.preventDefault();

    if (btn.disabled) {
        return;
    }

    btn.disabled = true;

    const dados = {
        capitalInicial: document.querySelector("#capital-inicial").value,
        aporteMensal: document.querySelector("#aporte-mensal").value,
        anos: document.querySelector("#periodo").value,
        ativos: [],
    };

    // var que armazena total das % pra validaçao
    let totalPercentual = 0;
    document.querySelectorAll(".ativo").forEach((linha) => {
        const checkbox = linha.querySelector('input[type="checkbox"]');
        const percentual = linha.querySelector('input[type="number"]');

        if (checkbox.checked) {
            totalPercentual += parseFloat(percentual.value) || 0;
            dados.ativos.push({
                ticker: checkbox.value,
                percentual: percentual.value
            });

        }
    });


    // Chamada da funçao da APi + Validação de 100%
    if (totalPercentual !== 100) {
        alert("A soma dos percentuais deve ser igual a 100%.");
        btn.disabled = false;
        return;
    }

    calcularInvestimentos(dados);

});


// Funçao para puxar do back 
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
    
    exibirChart(resposta);
    mostrarResultado(resposta)

    print(resposta);

    } catch (error) {
        console.error("Erro ao calcular investimentos:", error);
    } finally {
        btn.disabled = false;
    }

}


function print(resposta) {
    console.log(resposta);

}
