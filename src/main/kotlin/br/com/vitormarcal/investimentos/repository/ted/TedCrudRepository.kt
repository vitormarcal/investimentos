package br.com.vitormarcal.investimentos.repository.ted

import br.com.vitormarcal.investimentos.repository.trade.SideType
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional
interface TedCrudRepository: JpaRepository<Ted, Long> {


    fun findAllBySide(side: SideType): List<Ted>

}