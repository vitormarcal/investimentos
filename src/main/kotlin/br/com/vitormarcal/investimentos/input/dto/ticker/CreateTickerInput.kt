package br.com.vitormarcal.investimentos.input.dto.ticker

import java.math.BigDecimal

data class CreateTickerInput(
    val ticker: String,
    val companyName: String,
    val description: String?
)
