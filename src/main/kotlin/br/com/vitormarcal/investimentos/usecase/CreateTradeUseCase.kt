package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.dto.ticker.TickerIdentificationInput
import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTrade
import br.com.vitormarcal.investimentos.output.TickerInfoOutput
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TickerRepository
import br.com.vitormarcal.investimentos.repository.TradeRepository
import br.com.vitormarcal.investimentos.service.GetTickerInfoService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CreateTradeUseCase(
    private val tradeRepository: TradeRepository,
    private val tickerRepository: TickerRepository,
    private val getTickerInfoService: GetTickerInfoService
) : CreateTrade {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun execute(createTradeInput: CreateTradeInput): TradeOutput {
        logger.info("c=${this.javaClass.simpleName} m=create input=$createTradeInput")
        createTickerIfNotExists(createTradeInput)
        return tradeRepository.create(createTradeInput)
    }

    private fun createTickerIfNotExists(createTradeInput: CreateTradeInput) {
        createTradeInput.takeUnless { tickerRepository.existsById(createTradeInput.ticker) }
            ?.let { TickerIdentificationInput(it.ticker, it.market) }
            ?.let(getTickerInfoService::execute)
            ?.let(TickerInfoOutput::toTickerInput)
            ?.let(tickerRepository::create)
    }

}