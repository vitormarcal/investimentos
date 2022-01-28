package br.com.vitormarcal.investimentos.output

import java.math.BigDecimal

data class TickerLastPrice(
    val ticker: String,
    val price: BigDecimal
)
