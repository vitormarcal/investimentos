package br.com.vitormarcal.investimentos.web

import br.com.vitormarcal.investimentos.input.dto.trade.CreateTradeInput
import br.com.vitormarcal.investimentos.input.dto.trade.UpdateTradeInput
import br.com.vitormarcal.investimentos.input.usecase.CreateTrade
import br.com.vitormarcal.investimentos.input.usecase.ListAllTrade
import br.com.vitormarcal.investimentos.input.usecase.UpdateTrade
import br.com.vitormarcal.investimentos.output.TradeOutput
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("trades")
class TradeController(
    private val createTrade: CreateTrade,
    private val updateTrade: UpdateTrade,
    private val listAllTrade: ListAllTrade
) {


    @PostMapping
    fun create(@RequestBody input: CreateTradeInput): TradeOutput = createTrade.execute(input)

    @PutMapping("{id}")
    fun create(@PathVariable id: Long, @RequestBody input: UpdateTradeInput): TradeOutput =
        updateTrade.execute(id, input)

    @GetMapping
    fun list(): List<TradeOutput> = listAllTrade.execute()
}