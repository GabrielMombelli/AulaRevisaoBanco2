package org.example.ui

fun menu(){
    do {

        println("1 - Cadastrar Caixa D' Água")
        println("2 - Editar Caixa D' Água")
        println("3 - Listar Caixa D' Água")
        println("4 - Excluir Caixa D' Água")
        println("0 - Sair")

        var opcao = readln().toInt()

        when (opcao) {
            0-> println("Adeus!!")
            1 -> println("Cadastrando caixa...")
            2 -> println("editando caixa...")
            3 -> println("listar caixas...")
            4 -> println("excluindo caixa...")
            else -> println("Opcao invalida")
        }
    } while (opcao != 0)
}