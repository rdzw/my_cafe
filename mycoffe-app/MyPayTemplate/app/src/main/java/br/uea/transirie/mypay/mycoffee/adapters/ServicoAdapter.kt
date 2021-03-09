package br.uea.transirie.mypay.mycoffee.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.uea.transirie.mypay.mycoffee.databinding.ItemServicoBinding
import br.uea.transirie.mypay.mycoffee.model.Servico
import kotlin.reflect.KFunction1

/**
 * Adapter para gerenciar serviços cadastrados
 */
class ServicoAdapter(
    private val context: Context,
    private val listaServicos: MutableList<Servico>,
    private val itemEditCallback: KFunction1<Servico, Unit>,
    private val itemDeleteCallback: ((Servico) -> Unit)
) : RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder>() {

    /**
     * Classe ViewHolder que conterá cada item da lista de serviços
     */
    class ServicoViewHolder(val binding: ItemServicoBinding) : RecyclerView.ViewHolder(binding.root){
            val txtItemNome: TextView = binding.tvNomeServico
            val txtPreco: TextView = binding.tvPrecoServico
            val btnEditar: ImageView = binding.btnEdit
            val btnExcluir: ImageView = binding.btnDelete
    }

    /**
     * Atualiza lista de serviços
     */
    fun swapData(novaListaServicos: List<Servico>) {
        listaServicos.clear()
        listaServicos.addAll(novaListaServicos)
        notifyDataSetChanged()
    }

    /**
     * Cria novos ViewHolders quando necessário
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicoViewHolder {
        val binding = ItemServicoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ServicoViewHolder(binding)
    }

    /**
     * Preenche dados do ViewHolder
     */
    override fun onBindViewHolder(holder: ServicoViewHolder, position: Int) {
        val servico = listaServicos[position]

        // exibição do nome
        val tvNome = servico.descricao
        holder.txtItemNome.text = tvNome

        // exibição do preço
        var tvPreco = "R$ " + servico.preco.toString()
        tvPreco = tvPreco.replace('.', ',')
        if (tvPreco.length - tvPreco.indexOf(',') < 3)
            tvPreco += '0'
        holder.txtPreco.text = tvPreco

        // ação do botão editar
        holder.btnEditar.setOnClickListener {
            itemEditCallback(servico)
        }

        // ação do  botão excluir
        holder.btnExcluir.setOnClickListener{
            itemDeleteCallback(servico)
        }
    }

    override fun getItemCount(): Int = listaServicos.size

}