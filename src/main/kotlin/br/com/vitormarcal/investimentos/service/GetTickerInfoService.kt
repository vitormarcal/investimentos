package br.com.vitormarcal.investimentos.service

import br.com.vitormarcal.investimentos.output.TickerInfoOutput

interface GetTickerInfoService {

    fun execute(ticker: String): TickerInfoOutput
}
