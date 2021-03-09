package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.repository.AtendimentoDataSource
import br.uea.transirie.mypay.mycoffee.model.Atendimento

class AtendimentoRepository(database: AppDatabase): AtendimentoDataSource {
    private val atendimentoDao = database.atendimentoDao()

    override fun atendimentoById(id: Long): Atendimento {
        return atendimentoDao.atendimentoById(id)
    }

    override fun atendimentoByClienteId(clienteId: Long): List<Atendimento> {
        return atendimentoDao.atendimentoByClienteId(clienteId)
    }

    override fun save(obj: Atendimento) {
        if(obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
        } else {
            update(obj)
        }
    }

    override fun insert(obj: Atendimento): Long {
        return atendimentoDao.insert(obj)
    }

    override fun update(obj: Atendimento) {
        atendimentoDao.update(obj)
    }

    override fun delete(obj: Atendimento) {
        atendimentoDao.delete(obj)
    }

    fun getAllAtendimentos(): List<Atendimento> {
        return atendimentoDao.getAllAtendimentos()
    }
}