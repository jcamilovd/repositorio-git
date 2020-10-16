package co.edu.uniquindio.compiladores.controladores

import co.edu.uniquindio.compiladores.lexico.AnalizadorLexico
import co.edu.uniquindio.compiladores.lexico.Token
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextArea
import javafx.scene.control.cell.PropertyValueFactory
import java.net.URL
import java.util.*

class inicioContoller {


    @FXML lateinit var codigoFuente:TextArea
    @FXML lateinit var tablaTokens: TableView<Token>;
    @FXML lateinit var colLexema: TableColumn<Token,String>;
    @FXML lateinit var colCategoria: TableColumn<Token,String>;
    @FXML lateinit var colFila: TableColumn<Token,String>;
    @FXML lateinit var columna: TableColumn<Token,String>;

    @FXML lateinit var tokens:ObservableList<Token>


    @FXML
    fun analizarCodigo (e:ActionEvent){

        if(codigoFuente.text.length > 0) {
            val lexico = AnalizadorLexico(codigoFuente.text)

            lexico.analizar()
            print(lexico.listaTokens)

            tokens=FXCollections.observableArrayList();
            colLexema.cellValueFactory= PropertyValueFactory<Token,String>("Lexema")
            colCategoria.cellValueFactory= PropertyValueFactory<Token,String>("Categoria")
            colFila.cellValueFactory= PropertyValueFactory<Token,String>("Fila")
            columna.cellValueFactory= PropertyValueFactory<Token,String>("Columna")

        tablaTokens.items.clear()

      for (i in lexico.listaTokens) {
          tablaTokens.items.addAll(i)
      }
            lexico.listaTokens.clear()
        }

    }

}