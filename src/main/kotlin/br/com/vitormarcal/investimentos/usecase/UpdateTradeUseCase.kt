package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.dto.UpdateTradeInput
import br.com.vitormarcal.investimentos.input.usecase.UpdateTrade
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UpdateTradeUseCase(
    private val tradeRepository: TradeRepository
): UpdateTrade {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun execute(id: Long, updateTradeInput: UpdateTradeInput): TradeOutput {
        logger.info("c=${this.javaClass.simpleName} m=execute input=$updateTradeInput")
        return tradeRepository.update(id, updateTradeInput)
    }
}