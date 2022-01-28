const carteiraService = new CarteiraService()
var app = new Vue({
    el: '#app',
    data: {
        trades: [],
        averagePrices: [],
        ticker: '',
        unit: 0,
        price: 0
    },
    methods: {
        findTickers() {
            carteiraService.buscarDados().then(result => {
                this.trades = result.trades
                this.averagePrices = result.averagePrices

            })
        },
        add() {
            const newTrade = {
                'ticker': this.ticker,
                'price': this.price,
                'unit': this.unit
            }
            carteiraService.createTrade(newTrade).then(() => {
                this.ticker = '';
                this.unit = 0;
                this.price = 0;
                this.findTickers();
            })
        }
    },
    created() {
        this.findTickers()
    }
})