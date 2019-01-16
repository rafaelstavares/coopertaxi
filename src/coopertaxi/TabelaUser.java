/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coopertaxi;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PC-ASUS
 */
public class TabelaUser extends Application{
    
    
     @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("/view/viewUsuario.fxml");
        Parent root = FXMLLoader.load(url);
        Scene oi = new Scene(root);

        primaryStage.setScene(oi);
        primaryStage.setTitle("cadatro usuario");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        
    }
    
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
}
