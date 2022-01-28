package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.FindLastTickerPrice
import br.com.vitormarcal.investimentos.output.TickerLastPrice
import br.com.vitormarcal.investimentos.service.GetTickerInfoService
import org.springframework.stereotype.Service

@Service
class FindLastTickerPriceUseCase(
    private val tickerInfoService: GetTickerInfoService
): FindLastTickerPrice {
    override fun execute(ticker: String): TickerLastPrice {
        val tickerInfoOutput = tickerInfoService.execute(ticker)
        return TickerLastPrice(
            ticker = tickerInfoOutput.ticker,
            price = tickerInfoOutput.lastUnitValue
        )
    }
}