package co.edu.uniquindio.compiladores.Main

import co.edu.uniquindio.compiladores.lexico.AnalizadorLexico

fun main(){

    val lexico = AnalizadorLexico("123213123123213$6566 $ 1$ 1.2")
    lexico.analizar()
    print(lexico.listaTokens)
}