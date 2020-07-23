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
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PC-ASUS
 */
public class PUsuario extends Application{
    
    
     @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("/view/cad-user.fxml");
        Parent root = FXMLLoader.load(url);
        Scene oi = new Scene(root);

        primaryStage.setScene(oi);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("cadatro usuario");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
         oi.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.ESCAPE) {
                   primaryStage.close();
                }
            if (event.getCode() == KeyCode.ENTER) {
                    Button teste1 = (Button) root.lookup("#enviarBtn");
                    teste1.fire();
                    event.consume();
                }
            }
        });
    }
    
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
}
