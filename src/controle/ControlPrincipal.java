/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import coopertaxi.PUsuario;
import coopertaxi.TabelaUser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author PC-ASUS
 */
public class ControlPrincipal implements Initializable {

/*    @FXML
    MenuItem fechar;

    @FXML
    MenuItem idCadUser;
*/
    @FXML
    Label lHora;
    
    @FXML
    BorderPane panel1;

    @Override
    public void initialize(java.net.URL location,
            java.util.ResourceBundle resources) {
        /*idCadUser.setAccelerator(
                KeyCombination.keyCombination("SHORTCUT+U")
        );*/
        bindToTime();
       
 
    }

    @FXML
    void cadusuario(ActionEvent event) {
        try {
            new PUsuario().start(new Stage());

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar time = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                        lHora.setText(simpleDateFormat.format(time.getTime()));
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    void viewUsuario(ActionEvent event) {
        try {
            new TabelaUser().start(new Stage());
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    private void sairSistema() {
        Platform.exit();
    }

}
