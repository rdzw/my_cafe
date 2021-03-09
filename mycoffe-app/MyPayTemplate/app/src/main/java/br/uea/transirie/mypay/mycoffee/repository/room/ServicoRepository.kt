package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Servico
import br.uea.transirie.mypay.mycoffee.repository.ServicoDataSource

class ServicoRepository(database: AppDatabase): ServicoDataSource {
    private val servicoDao = database.servicoDao()

    /**
     * Salva um serviço no banco. Se for um novo, altera o objeto de origem
     * atribuindo ao id dele. Se já existir, apenas atualiza dados.
     *
     * @param obj o serviço a ser inserido ou atualizado
     */
    override fun save(obj: Servico) {
        // se id == 0 significa que foi instanciado com o valor padrão
        if(obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
        } else {
            update(obj)
        }
    }

    override fun insert(obj: Servico): Long {
        return servicoDao.insert(obj)
    }

    override fun update(obj: Servico) {
        return servicoDao.update(obj)
    }

    override fun delete(obj: Servico) {
        return servicoDao.delete(obj)
    }

    override fun servicoById(id: Long): Servico {
        return servicoDao.servicoById(id)
    }

    override fun searchByDescricao(termoBusca: String): List<Servico> {
        return servicoDao.searchByDescricao(termoBusca)
    }

    fun getAllServicos(): List<Servico> {
        return servicoDao.getAllServicos()
    }
}