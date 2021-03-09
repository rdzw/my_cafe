package br.uea.transirie.mypay.mycoffee.model

import androidx.room.Embedded
import androidx.room.Relation
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ATENDIMENTO_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ID
import br.uea.transirie.mypay.mycoffee.repository.sqlite.COLUMN_ITEM_ATENDIMENTO_ID

/**
 * Esta classe é utilizada como retorno de uma consulta "informações de um atendimento com todos
 * os seus pagamentos e itens".
 * O Room mapeia automaticamente a relação e preenche os objetos
 */
data class AtendimentoComPagamentosEItens (
    @Embedded var atendimento: Atendimento,

    @Relation(parentColumn = COLUMN_ID,
              entityColumn = COLUMN_ATENDIMENTO_ID)
    var pagamentoList: List<Pagamento>,

    @Relation(parentColumn = COLUMN_ID,
    entityColumn = COLUMN_ITEM_ATENDIMENTO_ID)
    var itemAtendimentoList: List<ItemAtendimento>
)