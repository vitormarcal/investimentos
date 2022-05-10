package br.com.vitormarcal.investimentos.repository

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.input.dto.trade.SideTypeEnumInput
import br.com.vitormarcal.investimentos.output.TedOutput

interface TedRepository {
    fun create(tedInput: CreateTedInput): TedOutput
    fun findAllBySide(side: SideTypeEnumInput): List<TedOutput>
    fun findAll(): List<TedOutput>
}