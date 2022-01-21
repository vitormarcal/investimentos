package br.com.vitormarcal.investimentos.service.ticker

import br.com.vitormarcal.investimentos.output.TickerInfoOutput
import br.com.vitormarcal.investimentos.service.GetTickerInfoService
import org.jsoup.Jsoup
import org.springframework.stereotype.Service


@Service
class GetTickerInfoServiceImpl: GetTickerInfoService {

    override fun execute(ticker: String): TickerInfoOutput {
        val webPage = Jsoup
            .connect("https://www.google.com/finance/quote/${ticker.uppercase()}:BVMF?hl=pt")
            .get()

        val companyName = webPage.getElementsByClass("zzDege").first().text()
        val description = webPage.getElementsByClass("bLLb2d").takeIf { it.isNotEmpty() }?.first()?.text()
        val lastValue = webPage.getElementsByTag("c-wiz")[3].allElements[3].attr("data-last-price").toBigDecimal()

        return TickerInfoOutput(
            ticker = ticker,
            companyName = companyName,
            description = description,
            lastUnitValue = lastValue
        )
    }
}