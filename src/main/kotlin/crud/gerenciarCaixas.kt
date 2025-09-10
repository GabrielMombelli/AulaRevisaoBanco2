package org.example.crud

import enumeradores.Material
import org.example.entidades.CaixaDAgua
import java.sql.Connection
import java.sql.ResultSet

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

fun cadastrarCaixa(id : Int) {

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
    val banco = conectar.conectarComBanco()!!
    if (id == 0){
        val salvar = banco.prepareStatement(
            "INSERT INTO CaixaDAgua " +
                    " (capacidade, cor, peso, preco, altura, largura, profundidade, tampa, material, marca)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )"

        )
        salvar.setInt(1, c.capacidade)
        salvar.setString(2, c.cor)
        salvar.setDouble(3, c.peso)
        salvar.setString(4, c.preco.toString())
        salvar.setDouble(5, c.altura)
        salvar.setDouble(6, c.largura)
        salvar.setDouble(7, c.profundidade)
        salvar.setString(8, c.tampa)
        salvar.setString(9, c.material.name)
        salvar.setString(10, c.marca)
        salvar.executeUpdate() // Isso fará um COMMIT no banco
        salvar.close()
    }else{
        val sql = "UPDATE CaixaDAgua SET " +
                " capacidade = ?, " +
                " cor = ?, " +
                " peso = ?, " +
                " preco = ?, " +
                " altura = ?, " +
                " largura = ?, " +
                " profundidade = ?, " +
                " tampa = ?, " +
                " material = ?, " +
                " marca = ? " +
                " WHERE id = ?"

            val editar = banco.prepareStatement(sql)
            editar.setInt(11, id)
            editar.setInt(1, c.capacidade)
            editar.setString(2, c.cor)
            editar.setDouble(3, c.peso)
            editar.setString(4, c.preco.toString())
            editar.setDouble(5, c.altura)
            editar.setDouble(6, c.largura)
            editar.setDouble(7, c.profundidade)
            editar.setString(8, c.tampa)
            editar.setString(9, c.material.name)
            editar.setString(10, c.marca)
            editar.executeUpdate() // Isso fará um COMMIT no banco
            editar.close()
    }
    banco.close()// Fecha a transação e a conexão com o banco


}
fun editarCaixa(){
    println("Digite o ID que deseja editar")
    var id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1,id)
    val retorno = resultados.executeQuery()


    while (retorno.next()){
        println("----------------------------------------------------------------------------------------")
        println("ID: ${retorno.getString("id")}")
        id = retorno.getString("id").toInt()
        println("capacidade: ${retorno.getString("capacidade")}")
        println("cor: ${retorno.getString("cor")}")
        println("peso: ${retorno.getString("peso")}")
        println("preco: ${retorno.getString("preco")}")
        println("altura: ${retorno.getString("altura")}")
        println("largura: ${retorno.getString("largura")}")
        println("profundidade: ${retorno.getString("profundidade")}")
        println("tampa: ${retorno.getString("tampa")}")
        println("material: ${retorno.getString("material")}")
        println("marca: ${retorno.getString("marca")}")
    }
    println("Faça suas alterações: ")
    cadastrarCaixa(id)
    banco.close()

}

fun listarCaixas(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    val resultados : ResultSet = banco!!.createStatement().executeQuery(sql)

    while (resultados.next()){
        println("ID: ${resultados.getString("id")}")
        println("capacidade: ${resultados.getString("capacidade")}")
        println("cor: ${resultados.getString("cor")}")
        println("peso: ${resultados.getString("peso")}")
        println("preco: ${resultados.getString("preco")}")
        println("altura: ${resultados.getString("altura")}")
        println("largura: ${resultados.getString("largura")}")
        println("profundidade: ${resultados.getString("profundidade")}")
        println("tampa: ${resultados.getString("tampa")}")
        println("material: ${resultados.getString("material")}")
        println("marca: ${resultados.getString("marca")}")
    }

}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir")
    val id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "DELETE FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1,id)
    val retorno = resultados.executeQuery()
    while (retorno.next()){
    println("----------------------------------------------------------------------------------------")
    println("ID: ${retorno.getString("id")}")
    println("capacidade: ${retorno.getString("capacidade")}")
    println("cor: ${retorno.getString("cor")}")
    println("peso: ${retorno.getString("peso")}")
    println("preco: ${retorno.getString("preco")}")
    println("altura: ${retorno.getString("altura")}")
    println("largura: ${retorno.getString("largura")}")
    println("profundidade: ${retorno.getString("profundidade")}")
    println("tampa: ${retorno.getString("tampa")}")
    println("material: ${retorno.getString("material")}")
    println("marca: ${retorno.getString("marca")}")
    }
    println("Tem certeza que deseja excluir esse registro?")

    val resposta = readln().lowercase()
    when(resposta) {
        "sim" -> {
            val deletar = banco.prepareStatement( "DELETE FROM CaixaDAgua WHERE id = ?")
                deletar.setInt(1, id)
                deletar.executeUpdate()
                deletar.close()

        }
        else -> {
            println("Operação cancelada!")
        }
    }
    val sqlDeleta = "DELETE FROM CaixaDAgua WHERE id = ?"
    banco.close()

}
