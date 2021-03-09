package br.uea.transirie.mypay.mycoffee.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import br.uea.transirie.mypay.mycoffee.model.*
import br.uea.transirie.mypay.mycoffee.repository.room.converters.TipoPagamentoConverter
import br.uea.transirie.mypay.mycoffee.repository.room.dao.*
import br.uea.transirie.mypay.mycoffee.repository.sqlite.DATABASE_NAME
import br.uea.transirie.mypay.mycoffee.repository.sqlite.DATABASE_VERSION
import org.jetbrains.anko.doAsync

@Database(entities = [
    Servico::class,
    Pagamento::class,
    ItemAtendimento::class,
    Estabelecimento::class,
    Cliente::class,
    Atendimento::class,
], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(TipoPagamentoConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun servicoDao(): ServicoDao
    abstract fun pagamentoDao(): PagamentoDao
    abstract fun itemAtendimentoDao(): ItemAtendimentoDao
    abstract fun estabelecimentoDao(): EstabelecimentoDao
    abstract fun clienteDao(): ClienteDao
    abstract fun atendimentoDao(): AtendimentoDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if(instance == null) {
                synchronized(this) {
                    instance =
                            Room.databaseBuilder(
                                    context.applicationContext,
                                    AppDatabase::class.java,
                                    DATABASE_NAME
                            )
                                    .addCallback(object: Callback(){
                                        override fun onCreate(db: SupportSQLiteDatabase) {
                                            super.onCreate(db)
                                            doAsync {
                                                PREPOPULATE_SERVICO.forEach {
                                                    getDatabase(context).servicoDao().insert(it)
                                                }
                                                PREPOPULATE_CLIENTE.forEach {
                                                    getDatabase(context).clienteDao().insert(it)
                                                }
                                                PREPOPULATE_ATENDIMENTO.forEach {
                                                    getDatabase(context).atendimentoDao().insert(it)
                                                }
                                                PREPOPULATE_PAGAMENTO.forEach {
                                                    getDatabase(context).pagamentoDao().insert(it)
                                                }
                                            }
                                        }
                                    }).build()
                }
            }
            return instance as AppDatabase
        }

        val PREPOPULATE_SERVICO = listOf(
                Servico(1, "Lavagem Simples", 15f),
                Servico(2, "Lavagem Especial", 20f),
        )

        val PREPOPULATE_CLIENTE = listOf(
                Cliente(
                        1, "João",
                        "joão@meunegocio.com.br", "+55 (92) 987654321",
                        "01/01/1980", "001.002.003-04"
                )
        )

        val PREPOPULATE_ATENDIMENTO = listOf(
                Atendimento(
                        1, 1,
                        "5/9/2000", "8/4/7899",
                        "9/9/2020", 60.50f
                ),
                Atendimento(
                        2, 1,
                        "9/5/2000", "8/4/2021",
                        "19/9/2020", 100f
                )
        )

        val PREPOPULATE_PAGAMENTO = listOf(
                Pagamento(
                        1, 1,
                        60.50f, "9/9/2020", TipoPagamento.CREDITO
                ),
                Pagamento(
                        2, 2,
                        100f, "19/9/2020", TipoPagamento.DINHEIRO
                )
        )

        fun destroyInstance() {
            instance = null
        }
    }
}