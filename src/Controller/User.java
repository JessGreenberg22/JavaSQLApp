package Controller;

import dao.DBUser;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Initializable {

    public TableView userTable;
    public TableColumn userId;
    public TableColumn username;
    public TableColumn password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle ) {

    }
}
