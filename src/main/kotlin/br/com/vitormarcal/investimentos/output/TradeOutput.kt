package br.com.vitormarcal.investimentos.output

import java.math.BigDecimal
import java.time.LocalDateTime

data class TradeOutput(
    val id: Long,
    val ticker: String,
    val unit: Int,
    val price: BigDecimal,
    val date: LocalDateTime,
    val side: SideTypeEnumOutput
)

enum class SideTypeEnumOutput {
    BUY,
    SELL
}
