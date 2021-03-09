package br.uea.transirie.mypay.mycoffee.repository

import br.uea.transirie.mypay.mycoffee.model.Estabelecimento

interface EstabelecimentoDataSource: BaseDataSource<Estabelecimento> {
    fun getEstabelecimento(): Estabelecimento
    fun estabelecimentoId(): Long
    fun estabelecimentoByEmailESenha(email: String, senha: String): Estabelecimento?
}