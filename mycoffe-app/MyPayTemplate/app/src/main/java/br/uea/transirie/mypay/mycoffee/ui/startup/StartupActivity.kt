package br.uea.transirie.mypay.mycoffee.ui.startup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.uea.transirie.mypay.mycoffee.databinding.ActivityStartupBinding

/**
 * Activity que abre após o "splash" apenas se usuário não estiver logado.
 */
class StartupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastro.setOnClickListener {

        }

        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}