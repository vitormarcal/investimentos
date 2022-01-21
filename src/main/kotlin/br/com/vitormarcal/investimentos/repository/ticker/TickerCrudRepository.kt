package br.com.vitormarcal.investimentos.repository.ticker

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional
interface TickerCrudRepository: JpaRepository<Ticker, String> {
}