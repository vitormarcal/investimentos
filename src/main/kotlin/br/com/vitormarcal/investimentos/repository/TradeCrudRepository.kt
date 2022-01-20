package br.com.vitormarcal.investimentos.repository

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional
interface TradeCrudRepository: JpaRepository<Trade, Long> {
    fun findByTicker(ticker: String): List<Trade>
}