
const result = document.querySelector("#resultado");

let grafico;

// FUnção pra exibir o chart com base nos dados do back resposta
function exibirChart(resposta) {
    const valores = Array.isArray(resposta?.evolucaoFeedBack) ? resposta.evolucaoFeedBack.map(Number): [];
    const anoAtual = new Date().getFullYear();
    const anoInicial = anoAtual - Math.ceil(valores.length / 12) + 1;
    const anos = valores.map((_, indice) =>
        anoInicial + Math.floor(indice / 12)
    );

    if (grafico) {
        grafico.destroy();
        grafico = null;
    }

    const canvas = document.querySelector("#grafico-investimentos");

    grafico = new Chart(canvas, {
        type: "line",
        data: {
            labels: anos,
            datasets: [{
                label: "Valor da carteira",
                data: valores,
                borderColor: "#1da7ff",
                backgroundColor: "rgba(29, 167, 255, 0.16)",
                borderWidth: 2.5,
                pointRadius: 0,
                pointHoverRadius: 6,
                pointHoverBackgroundColor: "#7dd3ff",
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
                legend: {
                    labels: {
                        color: "#d9ead2"
                    }
                },
                tooltip: {
                    backgroundColor: "#121813",
                    borderColor: "#1da7ff",
                    borderWidth: 1,
                    titleColor: "#7dd3ff",
                    bodyColor: "#f3f7ef",
                    callbacks: {
                        title: itens => `Ano ${anos[itens[0].dataIndex]}`,
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
                        minRotation: 0,
                        color: "#9eac9f"
                    }
                },
                y: {
                    type: "logarithmic",
                    beginAtZero: false,
                    grid: {
                        color: "rgba(29, 167, 255, 0.16)"
                    },
                    ticks: {
                        maxTicksLimit: 8,
                        color: "#9eac9f",
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