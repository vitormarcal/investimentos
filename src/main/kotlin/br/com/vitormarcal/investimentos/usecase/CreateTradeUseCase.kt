package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.dto.CreateTradeInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTrade
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CreateTradeUseCase(
    private val tradeRepository: TradeRepository
): CreateTrade {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun execute(createTradeInput: CreateTradeInput): TradeOutput {
        logger.info("c=${this.javaClass.simpleName} m=execute input=$createTradeInput")
        return tradeRepository.create(createTradeInput)
    }

}