package br.uea.transirie.mypay.mycoffee.ui.startup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.uea.transirie.mypay.mycoffee.databinding.ActivityLoginBinding
import br.uea.transirie.mypay.mycoffee.ui.home.HomeActivity

/**
 * Activity responsável por fazer o login do usuário. Antecede a "Startup"
 */
class LoginActivity : AppCompatActivity() {
    // variável responsável pelo **view binding**, isolando o acesso às views (elementos visuais)
    // ---------
    // De outro modo, sempre que fôssemos referenciar, por exemplo, um campo de texto, o
    // autocompletar retornaria botões, caixas de texto, etc. de outras telas
    private lateinit var binding: ActivityLoginBinding

    /**
     * Executado ao criar Activity (tela)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Imediatamente após iniciar a Activity devemos inicializar o layout.
        // A variável "binding" passará a ter uma referência para cada elemento do layout
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // essa linha é apenas para manter um padrão, você poderia passar "binding.root" diretamente
        val view = binding.root

        // nessa linha associamos o layout à activity e, ao terminar o "onCreate", a tela estará
        // montada
        setContentView(view)

        // o título afeta a barra superior do aplicativo
        title = "Login"

        // acessamos o botão btLogin e configuramos o evento de clique para executar o código logo
        // abaixo
        binding.btLogin.setOnClickListener {

            // quando desejamos abrir uma nova Activity, devemos primeiro criar um "Intent"
            // aqui, após apertar em "login", abrimos a tela de Home, mas normalmente precisaríamos
            // validar os dados do usuário
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}