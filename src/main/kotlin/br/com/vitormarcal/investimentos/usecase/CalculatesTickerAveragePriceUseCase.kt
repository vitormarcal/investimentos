package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.CalculatesTickerAveragePrice
import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class CalculatesTickerAveragePriceUseCase(
    private val tradeRepository: TradeRepository
): CalculatesTickerAveragePrice {

    override fun execute(ticker: String): TickerAveragePriceOutput {
        return execute(tradeRepository.findByTicker(ticker).toList())

    }

    override fun execute(tradeList: List<TradeOutput>): TickerAveragePriceOutput {
        return tradeList.fold(TickerAveragePriceOutput(), TickerAveragePriceOutput::add)
    }


}