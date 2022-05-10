package br.com.vitormarcal.investimentos.input.usecase

import java.math.BigDecimal

interface GetTotalMoneyBooked {

    fun execute(): BigDecimal

}