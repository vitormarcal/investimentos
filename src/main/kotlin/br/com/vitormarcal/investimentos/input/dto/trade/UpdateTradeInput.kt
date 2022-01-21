package br.com.vitormarcal.investimentos.input.dto.trade

import java.math.BigDecimal
import java.time.LocalDateTime

data class UpdateTradeInput(
    val ticker: String? = null,
    val unit: Int? = null,
    val price: BigDecimal? = null,
    val date: LocalDateTime? = null
)
