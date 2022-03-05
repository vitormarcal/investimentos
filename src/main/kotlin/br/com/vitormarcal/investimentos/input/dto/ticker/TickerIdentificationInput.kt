package br.com.vitormarcal.investimentos.input.dto.ticker

data class TickerIdentificationInput(
    val ticker: String,
    val market: String
) {
    val tickerWithMarket = "${ticker.uppercase()}:${market.uppercase()}"
}




