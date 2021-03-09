package br.uea.transirie.mypay.mycoffee.repository.room

import br.uea.transirie.mypay.mycoffee.model.Estabelecimento
import br.uea.transirie.mypay.mycoffee.repository.EstabelecimentoDataSource

class EstabelecimentoRepository(database: AppDatabase): EstabelecimentoDataSource {
    private val estabelecimentoDao = database.estabelecimentoDao()

    //Função que recebe o valor do id do estabelecimento
    override fun estabelecimentoId(): Long = estabelecimentoDao.estabelecimentoIds()

    override fun estabelecimentoByEmailESenha(email: String, senha: String): Estabelecimento? {
        return estabelecimentoDao.estabelecimentoByEmailESenha(email, senha)
    }

    override fun getEstabelecimento(): Estabelecimento {
        return estabelecimentoDao.getEstabelecimento()
    }

    override fun save(obj: Estabelecimento) {
        if(obj.id == 0L){
            val id = insert(obj)
            obj.id = id
        } else{
            update(obj)
        }
    }

    override fun insert(obj: Estabelecimento): Long {
        return estabelecimentoDao.insert(obj)
    }

    override fun update(obj: Estabelecimento) {
        return estabelecimentoDao.update(obj)
    }

    override fun delete(obj: Estabelecimento) {
        return estabelecimentoDao.delete(obj)
    }
}