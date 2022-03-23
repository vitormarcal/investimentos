package br.com.vitormarcal.investimentos.output

import java.math.BigDecimal

data class TedOutput(
    val id: Long,
    val amount: BigDecimal,
    val side: SideTypeEnumOutput
)
