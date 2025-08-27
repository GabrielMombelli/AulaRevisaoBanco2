package org.example.entidades

import java.math.BigDecimal

class Servico(
    var tipo: String,
    val preco: BigDecimal,
    val funcao: String,
    val funcionario: Funcionario


    /*var localizacao: String = "",
    var capacidadeLitros: Int = 500,
    var alturaInstalacaoMetros: Double = 2.5,
    var materialCaixa: String = "Polietileno",
    var temTampaVedada: Boolean = true,
    var possuiLadrao: Boolean = true,
    var possuiSaidaLimpeza: Boolean = true,
    var ultimaManutencao: String = "",
    var estaFuncionando: Boolean = true,
    var frete : BigDecimal = BigDecimal.ZERO,
    val profissional : entidades.Funcionario,*/
)