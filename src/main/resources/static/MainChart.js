
const result = document.querySelector("#resultado");

let grafico;

// FUnção pra exibir o chart com base nos dados do back resposta
function exibirChart(resposta) {
    const valores = Array.isArray(resposta?.evolucaoFeedBack) ? resposta.evolucaoFeedBack.map(Number): [];

    if (grafico) {
        grafico.destroy();
        grafico = null;
    }

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
                borderWidth: 2.5,
                pointRadius: 0,
                pointHoverRadius: 6,
                pointHoverBackgroundColor: "#1259f1",
                fill: true,
                tension: 0.25
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            interaction: {
                intersect: false,
                mode: "index"
            },
            plugins: {
                tooltip: {
                    callbacks: {
                        title: itens => `Mês ${itens[0].dataIndex + 1}`,
                        label: item => `Valor: ${item.parsed.y.toLocaleString("pt-BR", {
                            style: "currency",
                            currency: "BRL"
                        })}`
                    }
                }
            },
            scales: {
                x: {
                    grid: {
                        display: false
                    },
                    ticks: {
                        autoSkip: true,
                        maxTicksLimit: 8,
                        maxRotation: 0,
                        minRotation: 0
                    }
                },
                y: {
                    type: "logarithmic",
                    beginAtZero: false,
                    grid: {
                        color: "rgba(148, 163, 184, 0.2)"
                    },
                    ticks: {
                        maxTicksLimit: 8,
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