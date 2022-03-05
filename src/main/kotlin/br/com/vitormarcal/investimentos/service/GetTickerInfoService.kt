package br.com.vitormarcal.investimentos.service

import br.com.vitormarcal.investimentos.input.dto.ticker.TickerIdentificationInput
import br.com.vitormarcal.investimentos.output.TickerInfoOutput

interface GetTickerInfoService {

    fun execute(tickerIdentification: TickerIdentificationInput): TickerInfoOutput
}
