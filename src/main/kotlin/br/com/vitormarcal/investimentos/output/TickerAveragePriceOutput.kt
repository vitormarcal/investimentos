package br.com.vitormarcal.investimentos.output

import java.math.BigDecimal

data class TickerAveragePriceOutput(
    val ticker: String? = null,
    val market: String? = null,
    val unit: Long = 0,
    val price: BigDecimal = BigDecimal.ZERO,
    val unitSell: Long = 0,
    val priceSell: BigDecimal = BigDecimal.ZERO,
) {

    val averagePrice = if (price == BigDecimal.ZERO || unit == 0L) BigDecimal.ZERO else price / unit.toBigDecimal()

    fun add(trade: TradeOutput): TickerAveragePriceOutput {
        val newUnit = this.unit + trade.unit
        val priceTotal = this.price + (trade.price * trade.unit.toBigDecimal())

        return TickerAveragePriceOutput(
            ticker = trade.ticker,
            market = trade.market,
            unit = newUnit,
            price = priceTotal
        )
    }
}
