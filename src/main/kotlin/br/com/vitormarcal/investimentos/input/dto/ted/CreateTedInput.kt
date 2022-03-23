package br.com.vitormarcal.investimentos.input.dto.ted

import br.com.vitormarcal.investimentos.input.dto.trade.SideTypeEnumInput
import java.math.BigDecimal

data class CreateTedInput(
    val amount: BigDecimal,
    val side: SideTypeEnumInput = SideTypeEnumInput.BUY
)
