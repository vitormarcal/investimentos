package br.com.vitormarcal.investimentos.web

import br.com.vitormarcal.investimentos.input.dto.CreateTradeInput
import br.com.vitormarcal.investimentos.input.dto.UpdateTradeInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTrade
import br.com.vitormarcal.investimentos.input.usecase.UpdateTrade
import br.com.vitormarcal.investimentos.output.TradeOutput
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("trades")
class TradeController(
    private val createTrade: CreateTrade,
    private val updateTrade: UpdateTrade
) {


    @PostMapping
    fun create(@RequestBody input: CreateTradeInput): TradeOutput = createTrade.execute(input)

    @PutMapping("{id}")
    fun create(@PathVariable id: Long, @RequestBody input: UpdateTradeInput): TradeOutput =
        updateTrade.execute(id, input)
}