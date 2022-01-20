package br.com.vitormarcal.investimentos.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
interface TradeCrudRepository: JpaRepository<Trade, Long> {
}