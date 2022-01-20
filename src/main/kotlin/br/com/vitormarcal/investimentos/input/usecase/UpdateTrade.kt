package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.input.dto.UpdateTradeInput
import br.com.vitormarcal.investimentos.output.TradeOutput

interface UpdateTrade {

    fun execute(id: Long, updateTradeInput: UpdateTradeInput): TradeOutput
}