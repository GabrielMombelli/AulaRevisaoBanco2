package entidades

import java.math.BigDecimal

class Conta(
    var saldo: BigDecimal,
    val numeroConta: String,
    val titular: Pessoa,
    val agencia : String,
    val saque: BigDecimal,
    val deposito: BigDecimal,
    val senha: String,
    val tipoTransacao : String,
) {

}