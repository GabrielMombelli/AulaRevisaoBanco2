package org.example.crud

import enumeradores.Material
import org.example.entidades.CaixaDAgua
import java.sql.Connection

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5432/postgres",
    usuario = "postgres",
    senha = "postgres"
)


fun criarTabelaCaixa(){

    //Colocar o nome da tabela o mesmo nome da entidade
    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY, " +
        "capacidade float, " +
        "cor varchar(255), "+
        "peso float, "+
        "preco varchar(255), "+
        "altura float, "+
        "largura float,"+
        "profundidade float, "+
        "tampa varchar(255), "+
        "material varchar(255), "+
        "marca varchar(255) "+
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)

    banco.close()

}

fun cadastrarCaixa() {

    println("Escolha o material do qual a caixa é composta: ")
    println("1 - POLIETILENO")
    println("2 - PLASTICO")
    println("3 - METAL")
    println("4 - ACO")
    val opcao = readln().toInt()
    var material: Material
    when (opcao) {
        1 -> material = Material.POLIETILENO
        2 -> material = Material.PLASTICO
        3 -> material = Material.METAL
        4 -> material = Material.ACO
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

    val c = CaixaDAgua(
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
    val banco = conectar.conectarComBanco()!!.prepareStatement(
        "INSERT INTO CaixaDAgua " +
                " (capacidade, cor, peso, preco, altura, largura, profundidade, tampa, material, marca)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )"

    )
    banco.setInt(1, c.capacidade)
    banco.setString(2, c.cor)
    banco.setDouble(3, c.peso)
    banco.setString(4, c.preco.toString())
    banco.setDouble(5, c.altura)
    banco.setDouble(6, c.largura)
    banco.setDouble(7, c.profundidade)
    banco.setString(8, c.tampa)
    banco.setString(9, c.material.name)
    banco.setString(10, c.marca)
    banco.executeUpdate() // Isso fará um COMMIT no banco
    banco.close()// Fecha a transação e a conexão com o banco

}
fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}