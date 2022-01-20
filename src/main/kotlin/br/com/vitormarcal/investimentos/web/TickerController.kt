package br.com.vitormarcal.investimentos.web

import br.com.vitormarcal.investimentos.input.usecase.CalculatesTickerAveragePrice
import br.com.vitormarcal.investimentos.output.TickerAveragePriceOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("ticker")
class TickerController(
    private val calculatesTickerAveragePrice: CalculatesTickerAveragePrice
) {

    @GetMapping("{ticker}/average-price")
    fun averagePrice(@PathVariable ticker: String): TickerAveragePriceOutput =
        calculatesTickerAveragePrice.execute(ticker)

}