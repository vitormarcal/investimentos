package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.dto.ticker.TickerIdentificationInput
import br.com.vitormarcal.investimentos.input.usecase.FindLastTickerPrice
import br.com.vitormarcal.investimentos.output.TickerLastPrice
import br.com.vitormarcal.investimentos.repository.TickerRepository
import br.com.vitormarcal.investimentos.service.GetTickerInfoService
import org.springframework.stereotype.Service

@Service
class FindLastTickerPriceUseCase(
    private val tickerInfoService: GetTickerInfoService,
    private val tickerRepository: TickerRepository
): FindLastTickerPrice {
    override fun execute(ticker: String): TickerLastPrice {
       return tickerRepository.findById(ticker)!!.let {
            val input = TickerIdentificationInput(ticker = it.ticker, market = it.market)
            val tickerInfoOutput = tickerInfoService.execute(input)
            TickerLastPrice(
                ticker = tickerInfoOutput.ticker,
                price = tickerInfoOutput.lastUnitValue
            )
        }
    }
}