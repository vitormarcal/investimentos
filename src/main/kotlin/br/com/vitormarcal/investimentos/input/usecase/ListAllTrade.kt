package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TradeOutput

interface ListAllTrade {
    fun execute(): List<TradeOutput>
}