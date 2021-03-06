package br.com.vitormarcal.investimentos.repository.trade

import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.input.dto.trade.UpdateTradeInput
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.TradeRepository
import org.springframework.stereotype.Service

@Service
class TradeRepositoryImpl(
    private val tradeCrudRepository: TradeCrudRepository
): TradeRepository {
    override fun create(createTradeInput: CreateTradeInput): TradeOutput {
        return Trade.fromInput(createTradeInput).let { newTrade ->
            val tradeSaved = tradeCrudRepository.save(newTrade)
            tradeSaved.toOutput()
        }
    }

    override fun update(id: Long, updateTradeInput: UpdateTradeInput): TradeOutput {
        return tradeCrudRepository.findById(id).get().let { trade ->
            val tradeToUpdate = Trade.fromInput(updateTradeInput, trade)
            val tradeUpdated = tradeCrudRepository.save(tradeToUpdate)
            tradeUpdated.toOutput()
        }
    }

    override fun findById(id: Long): TradeOutput {
        return tradeCrudRepository.findById(id).get().toOutput()
    }

    override fun findByTicker(ticker: String): Sequence<TradeOutput> {
        return tradeCrudRepository.findByTicker(ticker).asSequence().map { it.toOutput() }
    }

    override fun findAllTickers(): List<String> {
        return tradeCrudRepository.findDistinctAllTickers()
    }

    override fun findAllTrades(): List<TradeOutput> {
        return tradeCrudRepository.findAll().map { it.toOutput() }
    }
}