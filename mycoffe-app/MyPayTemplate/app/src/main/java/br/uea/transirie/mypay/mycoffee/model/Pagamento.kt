package br.uea.transirie.mypay.mycoffee.model

import androidx.room.*
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_PAGAMENTO,
    foreignKeys = [
        ForeignKey(entity = Atendimento::class,
            parentColumns = [COLUMN_ID],
            childColumns = [COLUMN_ATENDIMENTO_ID])
    ])
class Pagamento (@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
                 @ColumnInfo(name = COLUMN_ATENDIMENTO_ID) var atendimentoId: Long = 0,
                 @ColumnInfo(name = COLUMN_VALOR) var valor: Float = 0f,
                 @ColumnInfo(name = COLUMN_DATA_PAGAMENTO) var dataPagamento: String = "",
                 @ColumnInfo(name = COLUMN_TIPO_PAGAMENTO) var tipoPagamento: TipoPagamento
)