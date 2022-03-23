package br.com.vitormarcal.investimentos.repository.ted

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.output.SideTypeEnumOutput
import br.com.vitormarcal.investimentos.output.TedOutput
import br.com.vitormarcal.investimentos.repository.trade.SideType
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "ted")
data class Ted(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
    val amount: BigDecimal,
    @Enumerated(value = EnumType.STRING) val side: SideType
) {

    fun toOutput(): TedOutput = TedOutput(
        id = this.id!!,
        amount = this.amount,
        side = SideTypeEnumOutput.valueOf(this.side.name)
    )

    companion object {

        fun fromOutput(output: TedOutput): Ted = Ted(
            id = output.id,
            amount = output.amount,
            side = SideType.valueOf(output.side.name)
        )

        fun fromInput(input: CreateTedInput): Ted = Ted(
            amount = input.amount,
            side = SideType.valueOf(input.side.name)
        )
    }
}
