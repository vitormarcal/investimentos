package br.com.vitormarcal.investimentos.usecase

import br.com.vitormarcal.investimentos.input.usecase.GetTotalMoneyBooked
import br.com.vitormarcal.investimentos.output.SideTypeEnumOutput
import br.com.vitormarcal.investimentos.repository.TedRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class GetTotalMoneyBookedUseCase(
    private val tedRepository: TedRepository
): GetTotalMoneyBooked {
    override fun execute(): BigDecimal {
        return tedRepository.findAll().fold(BigDecimal.ZERO) {moneyInvested, ted ->
            return@fold when(ted.side) {
                SideTypeEnumOutput.BUY -> moneyInvested + ted.amount
                SideTypeEnumOutput.SELL -> moneyInvested - ted.amount
            }
        }
    }
}