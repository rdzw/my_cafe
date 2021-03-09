package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_CLIENTE)
data class Cliente (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID, index = true) var id: Long = 0,
    @ColumnInfo(name = COLUMN_NOME) var nome: String = "",
    @ColumnInfo(name = COLUMN_EMAIL) var email: String = "",
    @ColumnInfo(name = COLUMN_TELEFONE) var telefone: String = "",
    @ColumnInfo(name = COLUMN_DATA_NASCIMENTO) var dataNascimento: String = "",
    @ColumnInfo(name = COLUMN_CPF) var cpf: String = ""
)