/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import coopertaxi.CadCarro;
import coopertaxi.PUsuario;
import coopertaxi.PagCota;
import coopertaxi.TabelaUser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Usuario;

/**
 *
 * @author PC-ASUS
 */
public class ControlPrincipal implements Initializable {

    UserSession usuario12;

    @FXML
    MenuItem fechar;

    @FXML
    MenuItem idCadUser;

    @FXML
    MenuItem idCadCota;

    @FXML
    MenuItem idCadCarro;

    @FXML
    Label lHora;

    @FXML
    Label lData;

    @FXML
    Label lOperador;

    @FXML
    BorderPane panel1;

    @Override
    public void initialize(java.net.URL location,
            java.util.ResourceBundle resources) {
        idCadUser.setAccelerator(
                KeyCombination.keyCombination("SHORTCUT+U")
        );

        idCadCota.setAccelerator(
                KeyCombination.keyCombination("SHORTCUT+C")
        );
        idCadCarro.setAccelerator(
                KeyCombination.keyCombination("SHORTCUT+M")
        );

        bindToTime();
        labelData();
        Usuario user13 = UserSession.getInstace().getUser();
        lOperador.setText(user13.getNome());
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

    private void labelData() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar time1 = Calendar.getInstance();
                        Date data = time1.getTime();
                        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
                        lData.setText(f.format(data));
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
    void cadCota(ActionEvent event) {
        try {
            new PagCota().start(new Stage());
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    void cadCarro(ActionEvent event) {
        try {
            new CadCarro().start(new Stage());

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    void cadusuario(ActionEvent event) {
        try {
            new PUsuario().start(new Stage());

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    void viewNomeUsuario() {
        lOperador.setText(usuario12.getUser().getSenha());
    }

    @FXML
    private void sairSistema() {
        System.exit(0);

    }

}
