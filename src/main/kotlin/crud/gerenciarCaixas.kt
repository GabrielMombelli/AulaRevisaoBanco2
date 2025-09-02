package org.example.crud

import enumeradores.Material
import org.example.entidades.CaixaDAgua
import java.sql.Connection

fun criarTabelaCaixa(){
    val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5432/postgres",
        usuario = "postgres",
        senha = "postgres"
    )
    //Colocar o nome da tabela o mesmo nome da entidade
    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY, " +
        "capacidade float, " +
        "cor varchar(255), "+
        "peso float, "+
        "preco float, "+
        "altura float, "+
        "largura float,"+
        "profundidade float, "+
        "tampa float, "+
        "material float, "+
        "marca varchar(255) "+
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().executeQuery(sql)

    println(enviarParaBanco)

    banco.close()

}

fun cadastrarCaixa(){

    println("Escolha o material do qual a caixa é composta: ")
    println("1 - POLIETILENO")
    println("1 - PLASTICO")
    println("1 - METAL")
    println("1 - ACO")
    val opcao = readln().toInt()
    var material : Material
    when(opcao){
        1-> material = Material.POLIETILENO
        2-> material = Material.PLASTICO
        3-> material = Material.METAL
        4-> material = Material.ACO
        else -> material = Material.PLASTICO
    }

    println("Informe a capacidade: ")
    val capacidade = readln().toInt()

    println("Informe a cor: ")
    val cor = readln()

    println("Informe o peso: ")
    val peso = readln().toDouble()

    println("Informe o preco: ")
    val preco = readln().toBigDecimal()

    println("Informe a altura: ")
    val altura = readln().toDouble()

    println("Informe a largura: ")
    val largura = readln().toDouble()

    println("Informe a profundidade: ")
    val profundidade = readln().toDouble()

    println("Informe a tampa: ")
    val tampa = readln()

    println("Informe a marca: ")
    val marca = readln()

    //Salvar as variáveis agr dentro da classe
    CaixaDAgua(
        capacidade = capacidade,
        cor = cor,
        peso = peso,
        preco = preco,
        altura = altura,
        largura = largura,
        profundidade = profundidade,
        tampa = tampa,
        material = material,
        marca = marca
    )

}


fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}