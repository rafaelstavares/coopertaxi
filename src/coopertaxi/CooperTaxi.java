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
import javafx.stage.StageStyle;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author PC-ASUS
 */
public class CooperTaxi extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("/view/login.fxml");
        Parent root = FXMLLoader.load(url);
        Scene oi = new Scene(root);

        primaryStage.setScene(oi);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Inicio");
        primaryStage.show();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

}
