package br.uea.transirie.mypay.mycoffee.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.uea.transirie.mypay.mycoffee.R
import br.uea.transirie.mypay.mycoffee.databinding.FragmentHistoricoBinding

/**
 * Esse fragmento faz parte da Activity "Home"
 * A barra de navegação inferior vai determinar qual fragmento será carregado
 */
class HistoricoFragment : Fragment() {

    // o view binding de fragmentos é feito utilizando esse artifício, com um "_binding" para tornar
    // a variável binding "non nullable"
    private var _binding: FragmentHistoricoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoricoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle(R.string.historico)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}