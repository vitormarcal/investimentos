package br.com.vitormarcal.investimentos.input.dto

import java.math.BigDecimal

data class CreateTradeInput(
    val ticker: String,
    val unit: Int,
    val price: BigDecimal
)
