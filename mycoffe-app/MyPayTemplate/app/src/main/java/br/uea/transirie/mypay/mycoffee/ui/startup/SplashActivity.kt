package br.uea.transirie.mypay.mycoffee.ui.startup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import br.uea.transirie.mypay.mycoffee.R
import br.uea.transirie.mypay.mycoffee.repository.room.AppDatabase
import br.uea.transirie.mypay.mycoffee.ui.home.HomeActivity
import br.uea.transirie.mypay.mycoffee.utils.Constants
import org.jetbrains.anko.doAsync

/**
 * Esta Activity implementa uma tela de Splash, mostrando a logo da solução seguida da tela de login
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Esconde a barra no topo da aplicação
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
            Log.d("Erro", "Não foi possível esconder toolbar")
        }

        // não utilizamos view binding poque não precisamos interagir com a tela, configurar
        // elementos, etc. Ver "LoginActivity" para mais sobre view binding
        setContentView(R.layout.activity_splash)

        // Shared Preferences armazenam configurações de sessão do usuário. Aqui é usado para checar
        // se usuário já fez login. Caso tenha feito, vai para tela de Home, não tendo feito vai
        // para tela de login
        val sharedPreferences = getSharedPreferences(Constants.PREF_USER_DATA, Context.MODE_PRIVATE)
        val login = sharedPreferences.getString("login", "")

        // inicializa banco de dados, quando será adicionado os "serviços padrão"
        // escolhi "getAllServicos" de forma arbitrária, apenas para finalizar a inicialização,
        // quando ele insere também valores padrão, em AppDatabase.getDatabase() --> onCreate(db)
        doAsync {
            AppDatabase.getDatabase(applicationContext).servicoDao().getAllServicos()
        }

        // uma maneira de atrasar a execução em X milisegundos, ideal para a tela de splash
        // o código dentro de "postDelayed" será executar após o tempo "delayMillis", aqui sendo 2000 ms
        Handler(Looper.getMainLooper()).postDelayed({
            when (login) {
                "" -> startActivity(Intent(this, StartupActivity::class.java))
                else -> startActivity(Intent(this, HomeActivity::class.java))
            }

            // note que após abrir a Activity é preciso encerrar essa, tirando ela da pilha
            finish()
        }, 2000)
    }
}