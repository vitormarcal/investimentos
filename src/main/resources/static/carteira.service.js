class CarteiraService {

    async  buscarDados() {

        return Promise.all([this.findAllTrades(), this.findTickerPriceInfos()]).then(results => {
            return {
                'trades': results[0],
                'tickerPrices': results[1],
            }
        })
    }

    async  findTickers() {
        return fetch('/tickers')
            .then(response => this.handleResponse(response));
    }

    async  findAllTrades() {
        return fetch('/trades')
            .then(response => this.handleResponse(response));
    }

    async  createTrade(newTrade) {
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTrade)
        };

        return fetch('/trades', requestOptions)
            .then(response => this.handleResponse(response));
    }

    async findTickerPriceInfos() {
        return this.findTickers().then(results =>
            Promise.all(
                [
                    this.findAveragePrices(results),
                    this.findLastPrices(results)
                ]
            ).then(p => {
                let [averagePriceList, lastPriceList] = p;

                return [...new Set([...averagePriceList, ...lastPriceList].map(i => i.ticker))]
                    .map(i => averagePriceList.find(o => o.ticker === i))
                    .map(data => {
                        data['lastPrice'] = lastPriceList.find(o => o.ticker === data.ticker).price
                        data['sellPrice'] = data.lastPrice * data.unit
                        return data
                    })
            }))
    }

    async findLastPrices(tickers) {
        const path = tickers.join(',')
        return fetch(`/tickers/${path}/last-price`)
            .then(response => this.handleResponse(response));
    }

    handleResponse(response) {
        if (response.status === 200) {
            return response.json();
        } else {
            throw new Error(response.status);
        }
    }

    async findAveragePrices(tickers) {
        const path = tickers.join(',')
        return fetch(`/tickers/${path}/average-price`)
            .then(response => this.handleResponse(response));
    }
}