package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.FindTradeByTicker
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class FindTradeByTickerUseCase(
    private val tradeRepository: TradeRepository
): FindTradeByTicker {
    override fun execute(ticker: String): Sequence<TradeOutput> {
        return tradeRepository.findByTicker(ticker)
    }
}