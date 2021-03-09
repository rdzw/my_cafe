package br.uea.transirie.mypay.mycoffee.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.uea.transirie.mypay.mycoffee.R
import br.uea.transirie.mypay.mycoffee.databinding.ActivityHomeBinding

/**
 * Activity responsável por manter o bottom navigation e fazer a troca de fragmentos para cada
 * seleção do usuário
 */
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // carrega o fragmento principal, inicial, "HOME"
        loadFragment(HomeFragment(), FRAGMENT_HOME)

        // configura ações de clique em cada uma das opções do bottom navigation
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> {
                    loadFragment(HomeFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_caixa -> {
                    loadFragment(CaixaFragment(), FRAGMENT_CAIXA)
                    true
                }
                R.id.ic_historico -> {
                    loadFragment(HistoricoFragment(), FRAGMENT_HISTORICO)
                    true
                }
                R.id.ic_ajustes -> {
                    loadFragment(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else -> false
            }
        }
    }

    /**
     * Função criada para deixar código mais enxuto e centralizar o carregamento de fragmentos
     */
    private fun loadFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment, tag)
            .commit()
    }

    /**
     * "tags" dos fragmentos
     */
    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_CAIXA = "FRAGMENT_CAIXA"
        private const val FRAGMENT_HISTORICO = "FRAGMENT_HISTORICO"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
    }
}