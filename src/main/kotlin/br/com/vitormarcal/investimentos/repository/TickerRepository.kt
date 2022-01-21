package br.com.vitormarcal.investimentos.repository

import br.com.vitormarcal.investimentos.input.dto.ticker.CreateTickerInput
import br.com.vitormarcal.investimentos.output.TickerOutput

interface TickerRepository {
    fun create(createTickerInput: CreateTickerInput): TickerOutput
    fun findById(id: String): TickerOutput?
    fun existsById(id: String): Boolean
}