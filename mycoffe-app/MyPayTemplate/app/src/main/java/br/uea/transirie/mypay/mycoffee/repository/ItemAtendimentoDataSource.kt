package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.ItemAtendimento

interface ItemAtendimentoDataSource: BaseDataSource<ItemAtendimento> {
    fun itemAtendimentoById(id: Long): ItemAtendimento
    fun itemAtendimentoByAtendimentoId(atendimentoId: Long): List<ItemAtendimento>
    fun itemAtendimentoByServicoId(servicoId: Long): List<ItemAtendimento>
}