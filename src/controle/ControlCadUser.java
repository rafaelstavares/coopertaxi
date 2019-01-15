/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 *
 * @author PC-ASUS
 */
public class ControlCadUser implements Initializable {

    @Override
    public void initialize(java.net.URL location,
            java.util.ResourceBundle resources) {

    }
    @FXML
    JFXTextField nome;

    @FXML
    JFXTextField usuario;

    @FXML
    JFXPasswordField senha;

    @FXML
    JFXButton enviarBtn;

    @FXML
    private void cadUser(ActionEvent t) {
        Stage stage = (Stage)enviarBtn.getScene().getWindow();
        try {
            Usuario user = new Usuario();
            UsuarioDao n = new UsuarioDao();
            user.setNome(nome.getText());
            user.setSenha(senha.getText());
            user.setUsuario(usuario.getText());
            n.Salvar(user);
        
        } catch (Exception e) {
            System.out.println("" + e);
        }
    stage.close();
    }

}
