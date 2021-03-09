package br.uea.transirie.mypay.mycoffee.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.uea.transirie.mypay.mycoffee.R
import br.uea.transirie.mypay.mycoffee.databinding.FragmentAjustesBinding
import br.uea.transirie.mypay.mycoffee.ui.servicos.EditarServicosActivity

/**
 * Esse fragmento faz parte da Activity "Home"
 * A barra de navegação inferior vai determinar qual fragmento será carregado
 */
class AjustesFragment : Fragment() {

    // o view binding de fragmentos é feito utilizando esse artifício, com um "_binding" para tornar
    // a variável binding "non nullable"
    private var _binding: FragmentAjustesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAjustesBinding.inflate(inflater, container, false)

        // para iniciar uma nova activity, precisamos do contexto da activity pai, que é acessada
        // com a propriedade "activity"
        binding.rowServicos.setOnClickListener {
            startActivity(Intent(activity, EditarServicosActivity::class.java))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle(R.string.ajustes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}