package br.com.vitormarcal.investimentos.repository.ted

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.input.dto.trade.SideTypeEnumInput
import br.com.vitormarcal.investimentos.output.TedOutput
import br.com.vitormarcal.investimentos.repository.TedRepository
import br.com.vitormarcal.investimentos.repository.trade.SideType

class TedRepositoryImpl(private val tedCrudRepository: TedCrudRepository) : TedRepository {
    override fun create(tedInput: CreateTedInput): TedOutput {
        return Ted.fromInput(tedInput).let { newTed ->
            tedCrudRepository.save(newTed).toOutput()
        }
    }

    override fun findAllBySide(side: SideTypeEnumInput): List<TedOutput> {
        return SideType.valueOf(side.name).let { sideType ->
            tedCrudRepository.findAllBySide(sideType)
                .map { it.toOutput() }
        }
    }
}