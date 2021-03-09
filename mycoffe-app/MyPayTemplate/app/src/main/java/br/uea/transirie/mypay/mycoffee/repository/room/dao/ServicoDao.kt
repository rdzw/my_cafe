package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.*
import br.uea.transirie.mypay.mycoffee.model.Servico
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_DESCRICAO
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_SERVICO

@Dao
interface ServicoDao: BaseDao<Servico> {

    /**
     * Obtém um Servico utilizando o id
     *
     * @param id o id do usuário a ser buscado
     */
    @Query("SELECT * FROM $TABLE_SERVICO WHERE $COLUMN_ID = :id")
    fun servicoById(id: Long): Servico

    /**
     * Busca um Servico utilizando a descrição (nome) dele
     *
     * @param query a string de busca com a descrição completa ou parcial
     */
    @Query("""SELECT * FROM $TABLE_SERVICO WHERE $COLUMN_DESCRICAO LIKE :query""")
    fun searchByDescricao(query: String): List<Servico>

    /**
     * Obtém todos os serviços cadastrados
     *
     */
    @Query("""SELECT * FROM $TABLE_SERVICO""")
    fun getAllServicos(): List<Servico>
}