package co.edu.uniquindio.compiladores.lexico

class AnalizadorLexico(var codigoFuente: String) {

    var posicionActual = 0;
    var caracterActual = codigoFuente[0]
    var listaTokens = ArrayList<Token>()
    var finCodigo = 0.toChar()
    var filaActual = 0
    var columnaActual = 0

    fun almacenarToken(lexema: String, categoria: Categoria, fila: Int, columna: Int) = listaTokens.add(Token(lexema, categoria, fila, columna))

    fun hacerBT(posicionInicial: Int, filaInicial: Int, columnaInicial: Int) {
        posicionActual = posicionInicial
        filaActual = filaInicial
        columnaActual = columnaInicial
        caracterActual = codigoFuente[posicionActual]
    }

    fun analizar() {
        while (caracterActual != finCodigo) {
            if (caracterActual == ' ' || caracterActual == '\t' || caracterActual == '\n') {
                obtenerSiguienteCaracter()
                continue
            }

            if (esEntero()) continue
            if (esDecimal()) continue
            if (esIdentificadorV()) continue
            if (esIdentificadorM()) continue
            if (esPalabraEntero()) continue
            if (esPalabraCadenaCaracter()) continue
            if (esPalabraCaracteres()) continue
            if (esPalabraFloat()) continue
            if (esPalabraDouble()) continue
            if (esOperadorTerminal()) continue
            if (esOperadorAritmetico()) continue
            if (esIncremental()) continue
            if (esDecremental()) continue
            if (esOperadorLogico()) continue
            if (esParentesisIzq()) continue
            if (esParentesisDerecho()) continue
            if (esLlaveIzq()) continue
            if (esLlaveDerecha()) continue
            if (esPalabaraMetodoPrincipal()) continue
            if (esCadenaCaracteres()) continue
            if (esCaracter()) continue
            if (esOperadorAsignacion()) continue
            if (esBucle()) continue
            if (esDecision()) continue
            if (esOperadorRelacional()) continue



            almacenarToken("" + caracterActual, Categoria.DESCONOCIDO, filaActual, columnaActual)
            obtenerSiguienteCaracter()
        }
    }

    fun esDecision(): Boolean {
        if (caracterActual == 'R') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'e') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == 'a') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()


                    if (caracterActual == 'd') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()


                        if (caracterActual == 'y') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()


                            almacenarToken(lexema, Categoria.DESICION, filaInicial, columnaInicial)
                            return true
                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }
                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }
                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }

        } else {
            if (caracterActual == 'N') {
                var lexema = ""
                var filaInicial = filaActual
                var columnaInicial = columnaActual
                var posicionInicial = posicionActual

                lexema += caracterActual
                obtenerSiguienteCaracter()

                if (caracterActual == 'R') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()


                    if (caracterActual == 'e') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()


                        if (caracterActual == 'a') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()


                            if (caracterActual == 'd') {
                                lexema += caracterActual
                                obtenerSiguienteCaracter()


                                if (caracterActual == 'y') {
                                    lexema += caracterActual
                                    obtenerSiguienteCaracter()


                                    almacenarToken(lexema, Categoria.DESICION, filaInicial, columnaInicial)
                                    return true

                                } else {
                                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                                    return false
                                }
                            } else {
                                hacerBT(posicionInicial, filaInicial, columnaInicial)
                                return false
                            }
                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }
                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }
                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            }
        }

        return false
    }


    fun esParentesisIzq(): Boolean {
        if (caracterActual == '-') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == ':') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == '>') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.PARENTESIS_IZQ, filaInicial, columnaInicial)
                    return true


                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esPalabaraMetodoPrincipal(): Boolean {
        if (caracterActual == 'e') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'u') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == 's') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()


                    if (caracterActual == 'a') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()


                        if (caracterActual == 'n') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()
                            almacenarToken(lexema, Categoria.PALABRA_RESERVADA_METODO_PRINCIPAL, filaInicial, columnaInicial)
                            return true

                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }

                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }
                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esOperadorAsignacion(): Boolean {
        if (caracterActual == ':') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'I') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                if (caracterActual == '=') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.OPERADOR_ASIGNACION, filaInicial, columnaInicial)
                    return true


                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            } else {

                if (caracterActual == 'M') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()


                    if (caracterActual == 'a' || caracterActual == 'i') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()


                        if (caracterActual == '=') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()




                            almacenarToken(lexema, Categoria.OPERADOR_ASIGNACION, filaInicial, columnaInicial)
                            return true


                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }
                    } else {
                        if (caracterActual == 'u') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()

                            if (caracterActual == 'l') {
                                lexema += caracterActual
                                obtenerSiguienteCaracter()


                                if (caracterActual == '=') {
                                    lexema += caracterActual
                                    obtenerSiguienteCaracter()

                                    almacenarToken(lexema, Categoria.OPERADOR_ASIGNACION, filaInicial, columnaInicial)
                                    return true


                                } else {
                                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                                    return false
                                }
                            } else {
                                hacerBT(posicionInicial, filaInicial, columnaInicial)
                                return false
                            }


                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }


                    }
                } else {
                    if (caracterActual == 'D') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()

                        if (caracterActual == 'i') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()


                            if (caracterActual == 'v') {
                                lexema += caracterActual
                                obtenerSiguienteCaracter()

                                if (caracterActual == '=') {
                                    lexema += caracterActual
                                    obtenerSiguienteCaracter()

                                    almacenarToken(lexema, Categoria.OPERADOR_ASIGNACION, filaInicial, columnaInicial)
                                    return true


                                } else {
                                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                                    return false
                                }
                            } else {
                                hacerBT(posicionInicial, filaInicial, columnaInicial)
                                return false
                            }
                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }

                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }
                }
            }
        }
        return false
    }


    fun esParentesisDerecho(): Boolean {
        if (caracterActual == '<') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == ':') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == '-') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.PARENTESIS_DER, filaInicial, columnaInicial)
                    return true


                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esOperadorRelacional(): Boolean {
        if (caracterActual == 'M') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'i') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == ':') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    if (caracterActual == ':') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()
                        almacenarToken(lexema, Categoria.OPERADOR_RELACIONAL, filaInicial, columnaInicial)
                        return true

                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }

                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        } else {

            if (caracterActual == ':') {
                var lexema = ""
                var filaInicial = filaActual
                var columnaInicial = columnaActual
                var posicionInicial = posicionActual

                lexema += caracterActual
                obtenerSiguienteCaracter()



                if (caracterActual == ':') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()



                    if (caracterActual == 'M') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()



                        if (caracterActual == 'a') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()

                            almacenarToken(lexema, Categoria.OPERADOR_RELACIONAL, filaInicial, columnaInicial)
                            return true


                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }
                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }
                } else {

                    if (caracterActual == 'I') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()

                        if (caracterActual == ':') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()

                            almacenarToken(lexema, Categoria.OPERADOR_RELACIONAL, filaInicial, columnaInicial)
                            return true

                        } else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }
                    } else {

                        if (caracterActual == 'D') {
                            lexema += caracterActual
                            obtenerSiguienteCaracter()

                            if (caracterActual == 'I') {
                                lexema += caracterActual
                                obtenerSiguienteCaracter()

                                if (caracterActual == ':') {
                                    lexema += caracterActual
                                    obtenerSiguienteCaracter()

                                    almacenarToken(lexema, Categoria.OPERADOR_RELACIONAL, filaInicial, columnaInicial)
                                    return true


                                }else {
                                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                                    return false
                                }

                            }else {
                                hacerBT(posicionInicial, filaInicial, columnaInicial)
                                return false
                            }


                        }else {
                            hacerBT(posicionInicial, filaInicial, columnaInicial)
                            return false
                        }


                    }

                }
            }


        }

        return false
    }


    fun esBucle(): Boolean {
        if (caracterActual == 'r') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'e') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == 'p') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.BUCLE, filaInicial, columnaInicial)
                    return true


                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }


    fun esDecremental(): Boolean {
        if (caracterActual == '-') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '-') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.DECREMENTO, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false


            }
        }

        return false
    }

    fun esLlaveDerecha(): Boolean {
        if (caracterActual == '+') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '¬') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.LLAVE_DER, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false


            }
        }

        return false
    }

    fun esLlaveIzq(): Boolean {
        if (caracterActual == '¬') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '+') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.LLAVE_IZQ, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false


            }
        }

        return false
    }


    fun esOperadorLogico(): Boolean {
        if (caracterActual == ':') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == 'Y' || caracterActual == 'O' || caracterActual == 'N') {
                lexema += caracterActual
                obtenerSiguienteCaracter()


                if (caracterActual == ':') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.OPERADOR_LOGICO, filaInicial, columnaInicial)
                    return true


                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false


                }

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false


            }
        }

        return false
    }

    fun esIncremental(): Boolean {
        if (caracterActual == '+') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '+') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.INCREMENTO, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false


            }
        }

        return false
    }

    fun esPalabraEntero(): Boolean {
        if (caracterActual == 'n') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '$') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.PALABRA_RESERVADA_ENTERO, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esPalabraFloat(): Boolean {
        if (caracterActual == 'n') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '&') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                if (caracterActual == '&') {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }

                almacenarToken(lexema, Categoria.PALABRA_RESERVADA_FLOAT, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esPalabraDouble(): Boolean {
        if (caracterActual == 'n') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '&') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                if (caracterActual == '&') {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()

                    almacenarToken(lexema, Categoria.PALABRA_RESERVADA_DOUBLE, filaInicial, columnaInicial)
                    return true

                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }


            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esOperadorTerminal(): Boolean {
        if (caracterActual == '*') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == ',') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.OPERADOR_TERMINAL, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esPalabraCaracteres(): Boolean {
        if (caracterActual == 'C') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '@') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.PALABRA_RESERVADA_CARACTERES, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    //Dudosoo
    fun esComentario(): Boolean {
        if (caracterActual == '#') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '#') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.COMENTARIO, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esPalabraCadenaCaracter(): Boolean {
        if (caracterActual == 'S') {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            if (caracterActual == '@') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.PALABRA_RESERVADA_CADENA_CARACTERES, filaInicial, columnaInicial)
                return true

            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }

        return false
    }

    fun esOperadorAritmetico(): Boolean {
        if (caracterActual == '*' || caracterActual == '-' || caracterActual == '+'
                || caracterActual == '/') {


            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual


            lexema += caracterActual
            obtenerSiguienteCaracter()


            if (caracterActual == '+') {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
            if (caracterActual == '-') {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }

            almacenarToken(lexema, Categoria.OPERADOR_ARITMETICO, filaInicial, columnaInicial)
            return true


        }


        return false
    }


    fun esDecimal(): Boolean {
        if (caracterActual.isDigit()) {
            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            while (caracterActual.isDigit()) {
                lexema += caracterActual
                obtenerSiguienteCaracter()
            }
            if (caracterActual == '.') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                if (caracterActual.isDigit()) {

                    while (caracterActual.isDigit()) {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()
                    }


                    if (caracterActual == '&') {
                        lexema += caracterActual
                        obtenerSiguienteCaracter()
                        almacenarToken(lexema, Categoria.DECIMAL, filaInicial, columnaInicial)
                        return true
                    } else {
                        hacerBT(posicionInicial, filaInicial, columnaInicial)
                        return false
                    }

                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false

            }
        }

        return false
    }

    fun esEntero(): Boolean {


        if (caracterActual.isDigit()) {

            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            while (caracterActual.isDigit()) {
                lexema += caracterActual
                obtenerSiguienteCaracter()
            }

            if (caracterActual == '.') {

                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
            if (caracterActual == '$') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.ENTERO, filaInicial, columnaInicial)
                return true
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false

            }
        }

        return false
    }

    fun esCadenaCaracteres(): Boolean {


        if (caracterActual == '{') {

            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()


            while (caracterActual.isLetterOrDigit()) {
                lexema += caracterActual
                obtenerSiguienteCaracter()
            }


            if (caracterActual == '}') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.CADENA_CARACTERES, filaInicial, columnaInicial)
                return true
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false

            }
        }

        return false
    }

    fun esCaracter(): Boolean {


        if (caracterActual == '<') {

            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            //mal
            while (caracterActual.isLetterOrDigit()) {
                lexema += caracterActual
                obtenerSiguienteCaracter()
            }


            if (caracterActual == '>') {
                lexema += caracterActual
                obtenerSiguienteCaracter()

                almacenarToken(lexema, Categoria.CADENA_CARACTERES, filaInicial, columnaInicial)
                return true
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false

            }
        }

        return false
    }

    fun esIdentificadorV(): Boolean {

        if (caracterActual.isLowerCase()) {


            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()

            while (caracterActual.isLowerCase()) {
                lexema += caracterActual
                obtenerSiguienteCaracter()
            }
            if (caracterActual.isUpperCase()) {

                lexema += caracterActual
                obtenerSiguienteCaracter()
                almacenarToken(lexema, Categoria.IDENTIFICADORV, filaInicial, columnaInicial)
                return true
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }
        return false
    }

    fun esIdentificadorM(): Boolean {

        if (caracterActual.isUpperCase()) {

            var lexema = ""
            var filaInicial = filaActual
            var columnaInicial = columnaActual
            var posicionInicial = posicionActual

            lexema += caracterActual
            obtenerSiguienteCaracter()


            if (caracterActual.isLowerCase()) {
                while (caracterActual.isLowerCase()) {
                    lexema += caracterActual
                    obtenerSiguienteCaracter()
                }
                if (caracterActual == '%') {

                    lexema += caracterActual
                    obtenerSiguienteCaracter()
                    almacenarToken(lexema, Categoria.IDENTIFICADORM, filaInicial, columnaInicial)
                    return true
                } else {
                    hacerBT(posicionInicial, filaInicial, columnaInicial)
                    return false
                }
            } else {
                hacerBT(posicionInicial, filaInicial, columnaInicial)
                return false
            }
        }
        return false
    }

    fun obtenerSiguienteCaracter() {

        if (posicionActual == codigoFuente.length - 1) {
            caracterActual = finCodigo
        } else {
            if (caracterActual == '\n') {
                filaActual++
                columnaActual = 0
            } else {
                columnaActual++
            }
            posicionActual++
            caracterActual = codigoFuente[posicionActual]
        }
    }
}