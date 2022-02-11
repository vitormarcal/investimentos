package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.CalculatesTickerAveragePrice
import br.com.vitormarcal.investimentos.output.SideTypeEnumOutput
import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CalculatesTickerAveragePriceUseCase(
    private val tradeRepository: TradeRepository
): CalculatesTickerAveragePrice {

    override fun execute(ticker: String): TickerAveragePriceOutput {
        return execute(tradeRepository.findByTicker(ticker).toList())

    }

    override fun execute(tradeList: List<TradeOutput>): TickerAveragePriceOutput {

        val tradeSell = tradeList.filter { it.side == SideTypeEnumOutput.SELL }.fold(TickerAveragePriceOutput(), TickerAveragePriceOutput::add)

        val tradeBuy = tradeList.filter { it.side == SideTypeEnumOutput.BUY }.fold(TickerAveragePriceOutput(
            unitSell = tradeSell.unit,
            priceSell = tradeSell.price
        ), TickerAveragePriceOutput::add)

        val unit = tradeBuy.unit - tradeSell.unit
        val price = tradeBuy.price - tradeSell.price

        return TickerAveragePriceOutput(
            ticker = tradeList.first().ticker,
            unit = unit,
            price = price.takeIf { it > BigDecimal.ZERO } ?: BigDecimal.ZERO
        )
    }


}