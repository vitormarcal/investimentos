package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTed
import br.com.vitormarcal.investimentos.output.TedOutput
import br.com.vitormarcal.investimentos.repository.TedRepository
import org.springframework.stereotype.Service

@Service
class CreateTedUseCase(
    private val tedRepository: TedRepository
): CreateTed {
    override fun execute(createTed: CreateTedInput): TedOutput {
        return tedRepository.create(createTed)
    }
}