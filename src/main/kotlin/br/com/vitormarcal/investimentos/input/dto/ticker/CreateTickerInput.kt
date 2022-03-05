package br.com.vitormarcal.investimentos.input.dto.ticker

data class CreateTickerInput(
    val ticker: String,
    val market: String,
    val companyName: String,
    val description: String?
)
