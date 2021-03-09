package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Servico

interface ServicoDataSource: BaseDataSource<Servico> {
    fun servicoById(id: Long): Servico
    fun searchByDescricao(termoBusca: String): List<Servico>
}