const carteiraService = new CarteiraService()
var app = new Vue({
    el: '#app',
    data: {
        trades: [],
        tickerPrices: [],
        ticker: '',
        unit: 0,
        price: 0
    },
    methods: {
        findTickers() {
            carteiraService.buscarDados().then(result => {
                this.trades = result.trades
                this.tickerPrices = result.tickerPrices
            })
        },
        add() {
            const newTrade = {
                'ticker': this.ticker,
                'price': this.price,
                'unit': this.unit,
                'side': this.side
            }
            carteiraService.createTrade(newTrade).then(() => {
                this.ticker = '';
                this.unit = 0;
                this.price = 0;
                this.side = '';
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