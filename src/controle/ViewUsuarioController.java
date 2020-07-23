/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import dao.UsuarioDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    
    @FXML
    private JFXButton deleteBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColunas();
        atualizarTabela();

    }

    @FXML
    public void deletar(ActionEvent event) {
        Usuario oi;
        try {
            
            ObservableList<Usuario> usuarioSelecionado, allUsuario;
            allUsuario = tabelaUser.getItems();
            oi = user.carregarId(tabelaUser.getSelectionModel().getSelectedItem().getIdUsuario());
            usuarioSelecionado = tabelaUser.getSelectionModel().getSelectedItems();
            usuarioSelecionado.forEach(allUsuario::remove);
            
            user.deletar(oi);
        } catch (Exception e) {
        }

    }

    void configurarColunas() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        usuarioCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("usuario"));
        senhaCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("senha"));
        tabelaUser.setItems(user.ListarUser());

    }

    void atualizarTabela() {
        tabelaUser.getItems().clear();
        tabelaUser.setItems(user.ListarUser());
        tabelaUser.refresh();
    }
}
