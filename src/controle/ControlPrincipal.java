/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.Usuario;

/**
 *
 * @author PC-ASUS
 */
public class ControlPrincipal implements Initializable {
    
    Usuario user;
    @FXML
    Label ola;
    
    @Override
    public void initialize(java.net.URL location,
            java.util.ResourceBundle resources) {
        ola.setText("ola");
    }
    
}
