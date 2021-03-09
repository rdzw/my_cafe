package br.uea.transirie.mypay.mycoffee.ui.servicos

import br.uea.transirie.mypay.mycoffee.model.Servico
import br.uea.transirie.mypay.mycoffee.repository.room.AppDatabase
import br.uea.transirie.mypay.mycoffee.repository.room.ServicoRepository

/**
 * A ideia dessa classe é manter todos os dados da tela e também fazer a ponte com o banco de dados.
 * Isso facilita entender e organizar todos os dados necessários por uma tela
 */
class EditarServicosViewModel(appDatabase: AppDatabase) {
    private var servicoRepository = ServicoRepository(appDatabase)
    private var servicoList: List<Servico>

    // logo após executar as inicializações acima (repositório), executa o bloco abaixo,
    // inicializando também a lista de serviços.
    // Observe que se você comentar o bloco abaixo o Android Studio irá reclamar que servicoList
    // não foi inicializado.
    init {
        servicoList = servicoRepository.getAllServicos()
    }

    /**
     * Acessa repositório de serviço para adicionar um novo.
     */
    fun adicionarServico(servico: Servico) {
        servicoRepository.save(servico)
        servicoList = servicoRepository.getAllServicos()
    }

    /**
     * Acessa repositório de serviço para atualizar um existente.
     */
    fun atualizarServico(servico: Servico) {
        servicoRepository.update(servico)
    }

    /**
     * Acessa repositório de serviço para deletar um existente.
     */
    fun deletarServico(servico: Servico) {
        servicoRepository.delete(servico)
    }

    /**
     * Acessa repositório de serviço para obter todos os existentes.
     */
    fun getAllServicos(): List<Servico> {
        return servicoRepository.getAllServicos()
    }
}