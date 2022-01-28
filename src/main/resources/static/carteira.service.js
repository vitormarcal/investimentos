class CarteiraService {

    async  buscarDados() {

        return Promise.all([this.findAllTrades(), this.findAveragePricesInTickers()]).then(results => {
            return {
                'trades': results[0],
                'averagePrices': results[1]
            }
        })



    }

    async  findTickers() {
        return fetch('/tickers')
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(response.status);
                }
            });
    }

    async  findAllTrades() {
        return fetch('/trades')
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(response.status);
                }
            });
    }

    async  createTrade(newTrade) {
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTrade)
        };

        return fetch('/trades', requestOptions)
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(response.status);
                }
            });
    }

    async findAveragePricesInTickers() {
        return this.findTickers().then(results => this.findAveragePrices(results))
    }

    async findAveragePrices(tickers) {
        const path = tickers.join(',')
        return fetch(`/tickers/${path}/average-price`)
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    throw new Error(response.status);
                }
            });
    }
}