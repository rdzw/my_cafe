package br.uea.transirie.mypay.mycoffee.model

/**
 * Esta classe é utilizada para simplificar o retorno de uma consulta por clientes. Ao invés de
 * retornar a classe completa, retorna apenas os atributos mais relevantes.
 * O nome das propriedades deve casar com o nome da classe que ela simplifica (nesse caso, Cliente)
 *
 */
data class ClienteMinimal(val _id: String, val nome: String)