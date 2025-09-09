package org.example.ui

import org.example.crud.cadastrarCaixa
import org.example.crud.excluirCaixa
import org.example.crud.listarCaixas

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
            1 -> {
                println("Cadastrando caixa...")
                cadastrarCaixa()
            }
            2 -> println { "editando caixa..." }
            3 -> { println ("listar caixas...")
                listarCaixas()
            }
            4 -> {
                println("excluindo caixa...")
                excluirCaixa()
            }
            else -> println("Opcao invalida")
        }
    } while (opcao != 0)
}