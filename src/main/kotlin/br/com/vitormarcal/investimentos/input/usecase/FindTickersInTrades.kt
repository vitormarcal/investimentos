package br.com.vitormarcal.investimentos.input.usecase

interface FindTickersInTrades {
    fun execute(): List<String>
}