package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Cliente
//import br.uea.transirie.mypay.mypaytemplate2.model.ClienteComAtendimentos
import br.uea.transirie.mypay.mycoffee.model.ClienteMinimal
import br.uea.transirie.mypay.mycoffee.repository.ClienteDataSource

class ClienteRepository(database: AppDatabase) : ClienteDataSource {
    private val clienteDao = database.clienteDao()

    override fun clienteById(id: Long): Cliente {
        return clienteDao.clienteById(id)
    }

    override fun save(obj: Cliente) {
        // se id == 0 significa que foi instanciado com o valor padrão
        if (obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
        } else {
            update(obj)
        }
    }

    override fun insert(obj: Cliente): Long {
        return clienteDao.insert(obj)
    }

    override fun update(obj: Cliente) {
        return clienteDao.update(obj)
    }

    override fun delete(obj: Cliente) {
        return clienteDao.delete(obj)
    }

    override fun getClientesMinimal(): List<ClienteMinimal> {
        return clienteDao.getClientesMinimal()
    }

    /*override fun getClienteComAtendimentosById(id: Long): List<ClienteComAtendimentos> {
        return clienteDao.getClienteComAtendimentosById(id)
    }*/
}