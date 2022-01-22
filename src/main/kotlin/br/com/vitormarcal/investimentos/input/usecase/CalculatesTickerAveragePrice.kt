package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput
import br.com.vitormarcal.investimentos.output.TradeOutput

interface CalculatesTickerAveragePrice {

    fun execute(ticker: String): TickerAveragePriceOutput
    fun execute(tradeList: List<TradeOutput>): TickerAveragePriceOutput
}