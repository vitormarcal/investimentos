package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.FindTickersInTrades
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class FindTickersInTradesUseCase(
    private val tradeRepository: TradeRepository
): FindTickersInTrades {
    override fun execute(): List<String> = tradeRepository.findAllTickers()
}