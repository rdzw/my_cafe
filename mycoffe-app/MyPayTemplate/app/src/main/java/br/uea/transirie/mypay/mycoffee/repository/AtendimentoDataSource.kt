package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Atendimento

interface AtendimentoDataSource: BaseDataSource<Atendimento> {
    fun atendimentoById(id: Long): Atendimento
    fun atendimentoByClienteId(clienteId: Long): List<Atendimento>
}