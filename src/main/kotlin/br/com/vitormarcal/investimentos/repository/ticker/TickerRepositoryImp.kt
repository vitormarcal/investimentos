package br.com.vitormarcal.investimentos.repository.ticker

import br.com.vitormarcal.investimentos.input.dto.ticker.CreateTickerInput
import br.com.vitormarcal.investimentos.output.TickerOutput
import br.com.vitormarcal.investimentos.repository.TickerRepository
import org.springframework.stereotype.Service

@Service
class TickerRepositoryImp(
    private val tickerCrudRepository: TickerCrudRepository
): TickerRepository {
    override fun create(createTickerInput: CreateTickerInput): TickerOutput {
        return Ticker.fromInput(createTickerInput).let { newTicker ->
            tickerCrudRepository.save(newTicker).toOutput()
        }
    }

    override fun findById(id: String): TickerOutput? {
        return tickerCrudRepository.findById(id)
            .takeIf {it.isPresent }
            ?.get()
            ?.toOutput()
    }

    override fun existsById(id: String): Boolean {
        return tickerCrudRepository.existsById(id)
    }
}