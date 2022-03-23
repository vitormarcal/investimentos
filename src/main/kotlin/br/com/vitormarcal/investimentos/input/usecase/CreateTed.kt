package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.output.TedOutput
import br.com.vitormarcal.investimentos.repository.ted.Ted

interface CreateTed {

    fun execute(ted: Ted): TedOutput
}