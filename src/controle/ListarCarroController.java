/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import dao.CarroDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Carro;

/**
 * FXML Controller class
 *
 * @author Isadora
 */
public class ListarCarroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    CarroDao car = new CarroDao();

    @FXML
    private TableView<Carro> tabelaCar;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn numeroCol;

    @FXML
    private Button deleteBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarColunas();
        atualizarTabela();
        deleteBtn.toFront();
    }
@FXML
    public void deletar(ActionEvent event) {
        Carro oi;
        try {
            
            ObservableList<Carro> usuarioSelecionado, allUsuario;
            allUsuario = tabelaCar.getItems();
            oi = car.carregarId(tabelaCar.getSelectionModel().getSelectedItem().getIdCarro());
            usuarioSelecionado = tabelaCar.getSelectionModel().getSelectedItems();
            usuarioSelecionado.forEach(allUsuario::remove);
            
            car.deletar(oi);
        } catch (Exception e) {
        }

    }
    void configurarColunas() {
        idCol.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("idCarro"));
        numeroCol.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("numeroOrdem"));
        tabelaCar.setItems(car.listarCarro());

    }

    void atualizarTabela() {
        tabelaCar.getItems().clear();
        tabelaCar.setItems(car.listarCarro());
        tabelaCar.refresh();
    }
}
