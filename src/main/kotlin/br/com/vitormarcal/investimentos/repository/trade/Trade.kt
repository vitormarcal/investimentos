package br.com.vitormarcal.investimentos.repository.trade

import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.input.dto.trade.UpdateTradeInput
import br.com.vitormarcal.investimentos.output.SideTypeEnumOutput
import br.com.vitormarcal.investimentos.output.TradeOutput
import br.com.vitormarcal.investimentos.repository.trade.SideType.*
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "trade")
data class Trade(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
    @JoinColumn(name = "ticker") val ticker: String,
    val unit: Int,
    val price: BigDecimal,
    val date: LocalDateTime,
    @Enumerated(value = EnumType.STRING) val side: SideType
) {
    fun toOutput(): TradeOutput = TradeOutput(
        id = this.id!!,
        ticker = this.ticker,
        unit = this.unit,
        price = this.price,
        date = this.date,
        side = SideTypeEnumOutput.valueOf(this.side.name)
    )

    companion object {
        fun fromOutput(output: TradeOutput): Trade = Trade(
            id = output.id,
            ticker = output.ticker,
            unit = output.unit,
            price = output.price,
            date = output.date,
            side = SideType.valueOf(output.side.name)
        )

        fun fromInput(input: CreateTradeInput): Trade = Trade(
            ticker = input.ticker,
            unit = input.unit,
            price = input.price,
            date = LocalDateTime.now(),
            side = SideType.valueOf(input.side.name)
        )

        fun fromInput(input: UpdateTradeInput, defaultTrade: Trade) = Trade(
            id = defaultTrade.id!!,
            ticker = input.ticker ?: defaultTrade.ticker,
            unit = input.unit ?: defaultTrade.unit,
            price = input.price ?: defaultTrade.price,
            date = input.date ?: defaultTrade.date,
            side = input.side?.let { SideType.valueOf(input.side.name) } ?: defaultTrade.side
        )
    }
}

enum class SideType {
    BUY,
    SELL
}
