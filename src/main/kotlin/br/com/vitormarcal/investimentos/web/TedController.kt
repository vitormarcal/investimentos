package br.com.vitormarcal.investimentos.web

import br.com.vitormarcal.investimentos.input.dto.ted.CreateTedInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTed
import br.com.vitormarcal.investimentos.input.usecase.GetTotalMoneyBooked
import br.com.vitormarcal.investimentos.output.TedOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("teds")
class TedController(
    private val getTotalMoneyBooked: GetTotalMoneyBooked,
    private val createTed: CreateTed
) {

    @PostMapping
    fun createNew(@RequestBody input: CreateTedInput): TedOutput {
        return createTed.execute(input)
    }

    @GetMapping("booked")
    fun findTotalInvested():BigDecimal  {
        return getTotalMoneyBooked.execute()
    }
}