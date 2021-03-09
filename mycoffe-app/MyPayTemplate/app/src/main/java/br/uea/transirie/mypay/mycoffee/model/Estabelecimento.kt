package br.uea.transirie.mypay.mycoffee.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.uea.transirie.mypay.mycoffee.repository.sqlite.*

@Entity(tableName = TABLE_ESTABELECIMENTO)
data class Estabelecimento (@PrimaryKey(autoGenerate = true)
                            @ColumnInfo(name = COLUMN_ID) var id: Long = 0,
                            @ColumnInfo(name = COLUMN_EMAIL) var email: String = "",
                            @ColumnInfo(name = COLUMN_SENHA_OBFUSCATED) var senhaObfuscated: String = "",
                            @ColumnInfo(name = COLUMN_NOME_FANTASIA) var nomeFantasia: String = "",
                            @ColumnInfo(name = COLUMN_RAZAO_SOCIAL) var razaoSocial: String = "",
                            @ColumnInfo(name = COLUMN_CNPJ) var cnpj: String = "",
                            @ColumnInfo(name = COLUMN_TELEFONE) var telefone: String = "",
                            @ColumnInfo(name = COLUMN_ENDERECO) var endereco: String = "")
