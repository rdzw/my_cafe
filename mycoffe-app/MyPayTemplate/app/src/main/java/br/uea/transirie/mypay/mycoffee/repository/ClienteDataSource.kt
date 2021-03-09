package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Cliente
//import br.uea.transirie.mypay.mypaytemplate2.model.ClienteComAtendimentos
import br.uea.transirie.mypay.mycoffee.model.ClienteMinimal

interface ClienteDataSource: BaseDataSource<Cliente> {
    fun clienteById(id: Long): Cliente
    fun getClientesMinimal(): List<ClienteMinimal>
//    fun getClienteComAtendimentosById(id: Long): List<ClienteComAtendimentos>
}