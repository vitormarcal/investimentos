const carteiraService = new CarteiraService()
var app = new Vue({
    el: '#app',
    data: {
        trades: [],
        tickerPrices: [],
        market: 'BVMF',
        ticker: '',
        side: 'BUY',
        unit: 0,
        price: 0
    },
    methods: {
        findTickers() {
            carteiraService.buscarDados().then(result => {
                this.trades = result.trades
                this.tickerPrices = result.tickerPrices.sort((a, b) => b.price - a.price)
            })
        },
        add() {
            const newTrade = {
                'market': this.market,
                'ticker': this.ticker,
                'price': this.price,
                'unit': this.unit,
                'side': this.side
            }
            carteiraService.createTrade(newTrade).then(() => {
                this.market = 'BVMF';
                this.ticker = '';
                this.unit = 0;
                this.price = 0;
                this.side = 'BUY';
                this.findTickers();
            })
        }
    },
    created() {
        setInterval(() => {
            return this.findTickers();
        }, 10000)
    }
})