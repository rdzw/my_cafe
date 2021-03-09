package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Atendimento
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_CLIENTE_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_ATENDIMENTO

@Dao
interface AtendimentoDao: BaseDao<Atendimento> {

    /**
     * Obtém todos os atendimento cadastrados
     *
     */
    @Query("""SELECT * FROM $TABLE_ATENDIMENTO""")
    fun getAllAtendimentos(): List<Atendimento>

    /**
    * Obtém um Atendimento utilizando o id
    *
    * @param id id do atendimento a ser buscado
    */
    @Query("""SELECT * FROM $TABLE_ATENDIMENTO WHERE $COLUMN_ID = :id""")
    fun atendimentoById(id: Long): Atendimento

    /**
     * Obtém todos os atendimento associados a um veículo
     *
     * @param clienteId o id do veículo onde o atendimento foi feito
     */
    @Query("""SELECT * FROM $TABLE_ATENDIMENTO WHERE $COLUMN_CLIENTE_ID = :clienteId""")
    fun atendimentoByClienteId(clienteId: Long): List<Atendimento>

}