package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Cliente
//import br.uea.transirie.mypay.mypaytemplate2.model.ClienteComAtendimentos
import br.uea.transirie.mypay.mycoffee.model.ClienteMinimal
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_NOME
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_CLIENTE

@Dao
interface ClienteDao: BaseDao<Cliente> {

    /**
     * Obtém um Cliente utilizando o id
     *
     * @param id é o id do Cliente a ser buscado
     */
    @Query("""SELECT * FROM $TABLE_CLIENTE WHERE $COLUMN_ID = :id""")
    fun clienteById(id: Long): Cliente

    /**
     * Obtém apenas os dados mínimos de um cliente para exibição em lista
     *
     */
    @Query("SELECT $COLUMN_ID, $COLUMN_NOME FROM $TABLE_CLIENTE")
    fun getClientesMinimal(): List<ClienteMinimal>

    /**
     * Obtém uma lista de todos os atendimentos de um determinado cliente
     * com uma referência à tabela Cliente e também Atendimento.
     * Serão feitas duas consultas e o Room junta tudo em um só objeto por conta
     * da annotation "Relation" presente em ClienteComAtendimento
     *
     * @param :id id do cliente do qual se deseja obter os atendimentos
     */
    /*@Transaction
    @Query("SELECT * FROM $TABLE_CLIENTE WHERE $COLUMN_ID = :id")
    fun getClienteComAtendimentosById(id: Long): List<ClienteComAtendimentos>*/
}