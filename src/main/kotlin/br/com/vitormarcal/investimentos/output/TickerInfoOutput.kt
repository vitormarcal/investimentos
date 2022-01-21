package br.com.vitormarcal.investimentos.output

import br.com.vitormarcal.investimentos.input.dto.ticker.CreateTickerInput
import java.math.BigDecimal

data class TickerInfoOutput(
    val ticker: String,
    val companyName: String,
    val description: String?,
    val lastUnitValue: BigDecimal
) {
    fun toTickerInput() = CreateTickerInput(
        ticker = this.ticker,
        companyName = this.companyName,
        description = this.description
    )
}
