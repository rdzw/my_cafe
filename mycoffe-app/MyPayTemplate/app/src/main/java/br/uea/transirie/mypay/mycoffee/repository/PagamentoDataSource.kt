package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Pagamento

interface PagamentoDataSource: BaseDataSource<Pagamento> {
    fun getAllPagamentos(): List<Pagamento>
    fun pagamentoByAtendimentoId(atendimentoId: Long): List<Pagamento>
}