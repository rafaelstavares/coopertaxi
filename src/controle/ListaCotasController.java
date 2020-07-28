/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CotaDao;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cota;

/**
 * FXML Controller class
 *
 * @author Isadora
 */
public class ListaCotasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    CotaDao cota = new CotaDao();
            
    @FXML
    TableView  tabelaCotas;
    
    @FXML
    TableColumn carCol;
    
    @FXML
    TableColumn dataCota;
    
    @FXML
    TableColumn valorCota;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarColunas();
        atualizarTabela();
    }    
    
    void configurarColunas() {

        carCol.setCellValueFactory(new PropertyValueFactory<>("carro"));
        dataCota.setCellValueFactory(new PropertyValueFactory<>("dataCota"));
        valorCota.setCellValueFactory(new PropertyValueFactory<Cota, Float>("valorCota"));
        tabelaCotas.setItems(cota.listarCotasData());

    }

    void atualizarTabela() {
        tabelaCotas.getItems().clear();
        tabelaCotas.setItems(cota.listarCotasData());
        tabelaCotas.refresh();
    }
    
}
