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

public class MainScreen implements Initializable{

    public Button custRecordsID;
    public Button appointmentBtnId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
/**Navigation to customer Records*/
    public void custRecordsAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/customerRecords.fxml")));
        Stage window = (Stage) custRecordsID.getScene().getWindow();
        window.setScene(new Scene(root, 650,455));
    }
    /**Navigation to Appointment Screen*/
    public void appointmentBtnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/appointmentScreen.fxml")));
        Stage window = (Stage) appointmentBtnId.getScene().getWindow();
        window.setScene(new Scene(root, 500,400));
    }
}
