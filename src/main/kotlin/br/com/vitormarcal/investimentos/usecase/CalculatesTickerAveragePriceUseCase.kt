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
) : CalculatesTickerAveragePrice {

    override fun execute(ticker: String): TickerAveragePriceOutput {
        return execute(tradeRepository.findByTicker(ticker).toList())

    }

    override fun execute(tradeList: List<TradeOutput>): TickerAveragePriceOutput {

        val newTradeList = TradeOutput.getTradeStartWithZeroUnit(tradeList)

        val tradeSell = newTradeList.filterBySellSide()
            .fold(TickerAveragePriceOutput(), TickerAveragePriceOutput::add)

        val tradeBuy = newTradeList.filterByBuySide().fold(
            TickerAveragePriceOutput(
                unitSell = tradeSell.unit,
                priceSell = tradeSell.price
            ), TickerAveragePriceOutput::add
        )

        val unit = tradeBuy.unit - tradeSell.unit
        val price = tradeBuy.price - tradeSell.price

        return TickerAveragePriceOutput(
            ticker = tradeList.first().ticker,
            unit = unit,
            price = price.takeIf { it > BigDecimal.ZERO } ?: BigDecimal.ZERO
        )
    }

    private fun List<TradeOutput>.filterByBuySide() = this.filter { it.side == SideTypeEnumOutput.BUY }
    private fun List<TradeOutput>.filterBySellSide() = this.filter { it.side == SideTypeEnumOutput.SELL }

}