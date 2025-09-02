package org.example.crud

import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC(
    val url : String,
    val usuario : String,
    val senha : String
) {
    fun conectarComBanco() : Connection?{
        //quando precisa fazer algo que possa falhar
        try{
            val coneccao : Connection =
                // Cada banco tem seu driver
                DriverManager.getConnection(
                    //quando a Classe instanciar os atributos
                    this.url, this.usuario, this.senha
                )
            println("Conectou")
            return coneccao
        } catch (erro : Exception){
            println(erro.printStackTrace())
        }
        return null
    }

}