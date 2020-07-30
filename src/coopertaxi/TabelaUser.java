/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coopertaxi;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Isadora
 */
public class TabelaUser extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("/view/viewUsuario.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Listar Usuarios!");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setMaximized(true);
        primaryStage.show();

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    primaryStage.close();
                }
//               
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
