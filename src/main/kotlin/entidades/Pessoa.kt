package org.example.entidades

import org.enumeradores.Sexo
import java.math.BigDecimal

open class Pessoa (
    val nome : String,
    val cpf : Long,
    val sexo : Sexo,
    val idade : Int
){
    //Comportamento
    open fun receberConta(conta:Conta, aPagar : BigDecimal) {
    conta.saldo = conta.saldo.subtract(aPagar)
    }
}