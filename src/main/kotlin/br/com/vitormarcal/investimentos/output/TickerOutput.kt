package br.com.vitormarcal.investimentos.output

data class TickerOutput(
    val ticker: String,
    val market: String,
    val companyName: String,
    val description: String?
)
