package br.com.vitormarcal.investimentos.repository.ticker

import br.com.vitormarcal.investimentos.input.dto.ticker.CreateTickerInput
import br.com.vitormarcal.investimentos.output.TickerOutput
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "ticker")
data class Ticker(
    @Id val ticker: String,
    val companyName: String,
    @Lob val description: String? = null
) {
    fun toOutput(): TickerOutput = TickerOutput(
        ticker = this.ticker,
        companyName = this.companyName,
        description = this.description
    )

    companion object {
        fun fromInput(input: CreateTickerInput): Ticker = Ticker(
            ticker = input.ticker,
            companyName = input.companyName,
            description = input.description
        )
    }
}
