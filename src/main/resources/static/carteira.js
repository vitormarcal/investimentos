const carteiraService = new CarteiraService()
var app = new Vue({
    el: '#app',
    data: {
        trades: [],
        tickerPrices: [],
        amountBooked: 0,
        newTedValue: 0,
        market: 'BVMF',
        ticker: '',
        side: 'BUY',
        unit: 0,
        price: 0
    },
    computed: {
        investedValue() {
            return this.tickerPrices.reduce((a, b) => {
                return a +  b.price || 0;
            }, 0)
        },
        liquidValue() {
            return this.tickerPrices.reduce((a, b) => {
                return a +  b.sellPrice || 0;
            }, 0)
        },
        diff() {
           return Math.round((this.investedValue - this.amountBooked) * 100) / 100
        },
        diffLiquidValue() {
            return Math.round((this.liquidValue - this.amountBooked) * 100) / 100
        }
    },
    methods: {
        findTickers() {
            carteiraService.buscarDados().then(result => {
                this.trades = result.trades
                this.tickerPrices = result.tickerPrices.sort((a, b) => b.price - a.price)
                this.amountBooked = result.amountBooked
            })
        },
        addNewTed() {
            carteiraService.addNewTed(this.newTedValue).then(result => {
                this.amountBooked += result
            }).finally(() => this.newTedValue = 0)
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