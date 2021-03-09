package br.uea.transirie.mypay.mycoffee.repository.room.dao

import androidx.room.Dao
import androidx.room.Query
import br.uea.transirie.mypay.mycoffee.model.Estabelecimento
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_EMAIL
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_SENHA_OBFUSCATED
import br.uea.transirie.mypay.mycoffee.repository.sqlite.TABLE_ESTABELECIMENTO

@Dao
interface EstabelecimentoDao: BaseDao<Estabelecimento> {

    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_ID = :id""")
    fun estabelecimentoById(id: Long): Estabelecimento

    /**
     * Realiza consulta por meio do email do estabelecimento
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email""")
    fun estabelecimentoByEmail(email: String): Estabelecimento

    /**
     * Consulta o valor por meio da coluna a senha do estabelecimento
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_SENHA_OBFUSCATED = :senha""")
    fun estabelecimentoBySenha(senha: String): Estabelecimento

    /**
     * Recupera um Estabelecendo através do email e senha
     */
    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO WHERE $COLUMN_EMAIL = :email AND $COLUMN_SENHA_OBFUSCATED = :senha""")
    fun estabelecimentoByEmailESenha(email: String, senha: String): Estabelecimento?

    @Query("""SELECT * FROM $TABLE_ESTABELECIMENTO""")
    fun getEstabelecimento(): Estabelecimento

    //Faz a consulta do id na tabela
    @Query("SELECT _id FROM $TABLE_ESTABELECIMENTO LIMIT 1")
    fun estabelecimentoIds(): Long
}