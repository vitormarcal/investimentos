package br.com.vitormarcal.investimentos.input.usecase

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.output.TedOutput

interface CreateTed {

    fun execute(createTed: CreateTedInput): TedOutput
}