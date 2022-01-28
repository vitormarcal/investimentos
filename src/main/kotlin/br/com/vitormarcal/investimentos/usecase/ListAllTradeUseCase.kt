package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.ListAllTrade
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class ListAllTradeUseCase(
    private val tradeRepository: TradeRepository
): ListAllTrade {
    override fun execute(): List<TradeOutput> {
        return tradeRepository.findAllTrades()
    }
}