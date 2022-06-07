package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerRecords implements Initializable {
    public Button returnButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    /** Navigate to the MainScreen */
    public void returnToMainScreenAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root, 800,500));
    }
}
