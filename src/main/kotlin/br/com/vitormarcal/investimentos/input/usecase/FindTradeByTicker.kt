package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TradeOutput

interface FindTradeByTicker {

    fun execute(ticker: String): Sequence<TradeOutput>
}