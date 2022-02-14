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
) {
    companion object {
        fun getTradeStartWithZeroUnit(tradeList: List<TradeOutput>): List<TradeOutput> {
            val newTradeList = tradeList.fold(0 to mutableListOf<TradeOutput>()) { pair, tradeOutput ->
                pair.second.add(tradeOutput)
                val unit = when (tradeOutput.side) {
                    SideTypeEnumOutput.BUY -> {
                        pair.first + tradeOutput.unit
                    }
                    SideTypeEnumOutput.SELL -> {
                        pair.first - tradeOutput.unit
                    }
                }
                if (unit == 0) pair.second.clear()
                unit to pair.second
            }.second
            return newTradeList
        }
    }
}

enum class SideTypeEnumOutput {
    BUY,
    SELL
}
