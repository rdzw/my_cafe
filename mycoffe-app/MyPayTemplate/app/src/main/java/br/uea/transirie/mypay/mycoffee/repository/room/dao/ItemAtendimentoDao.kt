package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.ItemAtendimento
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ATENDIMENTO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_SERVICO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_ITEM_ATENDIMENTO

@Dao
interface ItemAtendimentoDao: BaseDao<ItemAtendimento> {

    /**
     * Obtém todos os itemAtendimentos cadastrados
     *
     */
    @Query("""SELECT * FROM $TABLE_ITEM_ATENDIMENTO""")
    fun getAllItemAtendimentos(): List<ItemAtendimento>

    /**
     * Obtém um itemAtendimento utilizando o id
     *
     * @param id id do itemAtendimento a ser buscado
     */
    @Query("""SELECT * FROM $TABLE_ITEM_ATENDIMENTO WHERE $COLUMN_ID = :id""")
    fun itemAtendimentoById(id: Long): ItemAtendimento

    /**
     *  Obtém uma lista de itemAtendimentos utilizando atendimentoId
     *
     * @param atendimentoId atendimentoId do Atendimento relacionado ao itemAtendimento
     */
    @Query("""SELECT * FROM $TABLE_ITEM_ATENDIMENTO WHERE $COLUMN_ATENDIMENTO_ID = :atendimentoId""")
    fun itemAtendimentoByAtendimentoId(atendimentoId: Long): List<ItemAtendimento>

    /**
     *  Obtém uma lista de itemAtendimentos utilizando servicoId
     *
     * @param servicoId servicoId do Servico relacionado ao itemAtendimento
     */
    @Query("""SELECT * FROM $TABLE_ITEM_ATENDIMENTO WHERE $COLUMN_SERVICO_ID = :servicoId""")
    fun itemAtendimentoByServicoId(servicoId: Long): List<ItemAtendimento>

}