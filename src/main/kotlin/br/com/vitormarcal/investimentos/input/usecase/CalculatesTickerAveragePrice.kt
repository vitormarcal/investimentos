package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput

interface CalculatesTickerAveragePrice {

    fun execute(ticker: String): TickerAveragePriceOutput
}