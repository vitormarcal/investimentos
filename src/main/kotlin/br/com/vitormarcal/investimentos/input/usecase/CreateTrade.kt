package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.output.TradeOutput

interface CreateTrade {

    fun execute(createTradeInput: CreateTradeInput): TradeOutput

}