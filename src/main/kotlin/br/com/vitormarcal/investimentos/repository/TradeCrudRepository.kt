package br.com.vitormarcal.investimentos.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

@Transactional
interface TradeCrudRepository: JpaRepository<Trade, Long> {
    fun findByTicker(ticker: String): List<Trade>
    @Query("SELECT DISTINCT t.ticker FROM Trade t ")
    fun findDistinctAllTickers(): List<String>
}