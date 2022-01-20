package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.CalculatesTickerAveragePrice
import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class CalculatesTickerAveragePriceUseCase(
    private val tradeRepository: TradeRepository
): CalculatesTickerAveragePrice {
    override fun execute(ticker: String): TickerAveragePriceOutput {
        return tradeRepository.findByTicker(ticker)
            .fold(TickerAveragePriceOutput(), TickerAveragePriceOutput::add)
    }


}