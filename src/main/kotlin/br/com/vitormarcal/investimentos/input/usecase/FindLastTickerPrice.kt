package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TickerLastPrice

interface FindLastTickerPrice {
    fun execute(ticker: String): TickerLastPrice
}