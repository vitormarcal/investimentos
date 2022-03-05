package br.com.vitormarcal.investimentos.input.dto.trade

import br.com.vitormarcal.investimentos.input.dto.trade.SideTypeEnumInput.*
import java.math.BigDecimal

data class CreateTradeInput(
    val ticker: String,
    val market: String,
    val unit: Int,
    val price: BigDecimal,
    val side: SideTypeEnumInput = BUY
)

enum class SideTypeEnumInput {
    BUY,
    SELL
}
