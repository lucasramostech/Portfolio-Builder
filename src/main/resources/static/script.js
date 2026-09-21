const btn = document.querySelector("#press");

// Evento de click
btn.addEventListener("click", (event) => {
    event.preventDefault();
    enviarParaBack();
});

// Função para enviar os dados para o back
function enviarParaBack() {
    if (btn.disabled) {
        return;
    }
    btn.disabled = true;

    const dados = {
        capitalInicial: document.querySelector("#capital-inicial").value,
        aporteMensal: document.querySelector("#aporte-mensal").value,
        tempoEscala: document.querySelector("#periodo").value,
        ativos: [],
    };


    // var que armazena total das % pra validaçao
    let totalPercentual = 0;
    const taxaFixaItem = document.querySelector(".fix-rate-item input[name='taxa-fixa-anual']");

    document.querySelectorAll(".ativo").forEach((linha) => {
        const checkbox = linha.querySelector('input[type="checkbox"]');
        const percentual = linha.querySelector('input[type="number"]');

        if (!checkbox || !checkbox.checked) {
            return;
        }
        const valorPercentual = parseFloat(percentual.value) || 0;
        totalPercentual += valorPercentual;
        const item = {
            ticker: checkbox.value,
            percentual: percentual.value
        };

        // Se tiver renda fixa
        if (checkbox.value === "Fixed-Rate" && taxaFixaItem) {
            item.taxaAnual = taxaFixaItem.value;
        }
        dados.ativos.push(item);
    });



    // Chamada da funçao da APi + Validação de 100%
    if (totalPercentual !== 100) {
        alert("A soma dos percentuais deve ser igual a 100%.");
        btn.disabled = false;
        return;
    }

    calcularInvestimentos(dados);
}


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


    } catch (error) {
        console.error("Erro ao calcular investimentos:", error);
    } finally {
        btn.disabled = false;
    }

}

