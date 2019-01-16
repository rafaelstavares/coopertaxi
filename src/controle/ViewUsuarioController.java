/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author COOPERATIVA
 */
public class ViewUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    UsuarioDao user = new UsuarioDao();
    @FXML
    private TableView<Usuario> tabelaUser;
    @FXML
    private TableColumn nomeCol;
    @FXML
    private TableColumn usuarioCol;
    @FXML
    private TableColumn senhaCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        usuarioCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("usuario"));
                senhaCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("senha"));
                tabelaUser.setItems(user.ListarUser());
    }

}
