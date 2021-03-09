package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Pagamento
import br.uea.transirie.mypay.mycoffee.repository.PagamentoDataSource

class PagamentoRepository(database: AppDatabase): PagamentoDataSource {
    private val pagamentoDao = database.pagamentoDao()

    override fun save(obj: Pagamento) {
        // se id == 0 significa que foi instanciado com o valor padrão
        if (obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
        } else {
            update(obj)
        }
    }

    override fun insert(obj: Pagamento): Long {
        return pagamentoDao.insert(obj)
    }

    override fun update(obj: Pagamento) {
        return pagamentoDao.update(obj)
    }

    override fun delete(obj: Pagamento) {
        return pagamentoDao.delete(obj)
    }

    override fun getAllPagamentos(): List<Pagamento> {
        return pagamentoDao.getAllPagamentos()
    }

    override fun pagamentoByAtendimentoId(atendimentoId: Long): List<Pagamento> {
        return pagamentoDao.pagamentoByAtendimentoId(atendimentoId)
    }
}