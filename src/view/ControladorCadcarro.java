/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CarroDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Carro;

/**
 * FXML Controller class
 *
 * @author Isadora
 */
public class ControladorCadcarro implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button enviarBtn;

    @FXML
    TextField idNumeroOrdem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cadCarro(ActionEvent t) {
        Stage stage = (Stage) enviarBtn.getScene().getWindow();
        try {
            int numero = Integer.parseInt(idNumeroOrdem.getText());
            Carro carro = new Carro();
            CarroDao n = new CarroDao();
            carro.setNumeroOrdem(numero);
            n.Salvar(carro);
        } catch (Exception e) {
            System.out.println("" + e);
        }
        stage.close();
    }
}
