/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CarroDao;
import dao.CotaDao;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Carro;
import modelo.Cota;

/**
 * FXML Controller class
 *
 * @author Isadora
 */
public class CotaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    CarroDao carro = new CarroDao();

    @FXML
    DatePicker dataCota;

    @FXML
    ComboBox comboBox;

    @FXML
    TextField valorCota;

    @FXML
    Button btnGravarCota;

    ObservableList carroSelecionado = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        popularComboBOx();
    }

    public void popularComboBOx() {

        List<Carro> eList = carro.listarCarro();
        for (Carro car : eList) {
            carroSelecionado.add(car);

        }

        comboBox.getItems().addAll(carroSelecionado);
    }



    @FXML
    private void cadCota(ActionEvent t) {
        Stage stage = (Stage) btnGravarCota.getScene().getWindow();

        try {
            Cota cota = new Cota();
            CotaDao gravarCota = new CotaDao();
            LocalDate date1 = dataCota.getValue();
            Date datacerta = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
            cota.setDataCota(datacerta);
            cota.setValorCota(Float.parseFloat(valorCota.getText()));
            Carro car4 = (Carro) comboBox.getValue();
            cota.setCarro(carro.carregarIdCarro(car4.getIdCarro()));
            gravarCota.SalvarCota(cota);
        } catch (Exception e) {
            System.out.println("erro " + e);
        }

        stage.close();
    }

}
