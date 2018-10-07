/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import coopertaxi.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author PC-ASUS
 */
public class ControleLogin implements Initializable {

    @Override
    public void initialize(java.net.URL location,
            java.util.ResourceBundle resources) {

    }

    @FXML
    JFXTextField usuario;

    @FXML
    JFXPasswordField senha;

    @FXML
    private JFXButton fechar;

    @FXML
    private JFXButton entrar;

    @FXML
    private Text actiontarget;

    @FXML
    public void acao(ActionEvent event) {
        Stage stage = (Stage) entrar.getScene().getWindow();
        if (usuario.getText().equals("admin")
                && senha.getText().equals("123")) {
            try {
                new Principal().start(new Stage());
                stage.close();
            } catch (Exception e) {
            }

        } else {
            actiontarget.setText("credencias erradas");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("erro de credenciais!");
            alert.show();
            limparLogin();
        }
    }

    public void limparLogin() {
        senha.setText("");
        usuario.setText("");
    }

    @FXML
    private void limparAdvertencia() {

        actiontarget.setText("");

    }

    @FXML
    private void fecharTelaAction() {
        final Stage stage = (Stage) fechar.getScene().getWindow();
        entrar.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Node focusOwner = entrar.getParent();
                if (focusOwner instanceof Button) {
                    ((Button) focusOwner).fire();
                }
            }
        });
        //Obtendo a janela atual
        System.out.println("saindo");
        stage.close(); //Fechando o Stage
    }

}
