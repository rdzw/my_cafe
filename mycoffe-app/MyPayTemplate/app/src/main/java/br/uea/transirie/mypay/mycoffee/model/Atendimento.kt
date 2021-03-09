package br.uea.transirie.mypay.mycoffee.model

import androidx.room.*
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ATENDIMENTO,
    foreignKeys = [
        ForeignKey(entity = Cliente::class,
                   parentColumns = [COLUMN_ID],
                   childColumns = [COLUMN_CLIENTE_ID])
    ])
data class Atendimento (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID, index = true) var id: Long = 0,
    @ColumnInfo(name = COLUMN_CLIENTE_ID) var clienteId: Long = 0,
    @ColumnInfo(name = COLUMN_DATA_RECEBIMENTO) var dataRecebimento: String = "",
    @ColumnInfo(name = COLUMN_DATA_PREVISAO_ENTREGA) var dataPrevisaoEntrega: String = "",
    @ColumnInfo(name = COLUMN_DATA_CONCLUSAO) var dataConclusao: String = "",
    @ColumnInfo(name = COLUMN_VALOR_TOTAL) var dataValorTotal: Float = 0f
)