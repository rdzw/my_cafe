package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_SERVICO)
data class Servico(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
    @ColumnInfo(name = COLUMN_DESCRICAO) var descricao: String = "",
    @ColumnInfo(name = COLUMN_PRECO) var preco: Float = 0f
)