
const result = document.querySelector("#resultado");

let grafico;


function exibirChart(resposta) {
    const valores = Array.isArray(resposta)
        ? resposta.map(Number)
        : [];

    if (grafico) {
        grafico.destroy();
    }

    result.innerHTML = '<canvas id="grafico-investimentos"></canvas>';

    const canvas = document.querySelector("#grafico-investimentos");

    grafico = new Chart(canvas, {
        type: "line",
        data: {
            labels: valores.map((_, indice) => `Mês ${indice + 1}`),
            datasets: [{
                label: "Valor da carteira",
                data: valores,
                borderColor: "#1259f1",
                backgroundColor: "rgba(27, 93, 237, 0.15)",
                borderWidth: 2,
                fill: true,
                tension: 0.25
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    type: "logarithmic",
                    beginAtZero: false,
                    ticks: {
                        callback: valor =>
                            valor.toLocaleString("pt-BR", {
                                style: "currency",
                                currency: "BRL"
                            })
                    }
                }
            }
        }
    });

}