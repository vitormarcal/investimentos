package br.com.vitormarcal.investimentos.output

data class TickerOutput(
    val ticker: String,
    val companyName: String,
    val description: String?
)
