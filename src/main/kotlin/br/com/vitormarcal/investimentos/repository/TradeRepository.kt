package br.com.vitormarcal.investimentos.repository

import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.input.dto.trade.UpdateTradeInput
import br.com.vitormarcal.investimentos.output.TradeOutput

interface TradeRepository {

    fun create(createTradeInput: CreateTradeInput): TradeOutput
    fun update(id: Long, updateTradeInput: UpdateTradeInput): TradeOutput
    fun findById(id: Long): TradeOutput
    fun findByTicker(ticker: String): Sequence<TradeOutput>
    fun findAllTickers(): List<String>
    fun findAllTrades(): List<TradeOutput>

}