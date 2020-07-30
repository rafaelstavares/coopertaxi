/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coopertaxi;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Isadora
 */
public class CotaDiaria extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url = getClass().getResource("/view/cotaDiaria.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("cadastro cota Diaria");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
