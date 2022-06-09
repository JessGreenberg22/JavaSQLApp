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

public class UpdateAppointment implements Initializable {
    public Button ReturnToAppointmentScreenId;
    public Button returnToMainScreenId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
/*Navigation to Appointment Screen*/
    public void ReturnToAppointmentScreenBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/appointmentScreen.fxml")));
        Stage window = (Stage) ReturnToAppointmentScreenId.getScene().getWindow();
        window.setScene(new Scene(root, 800,500));
    }
/*Navifation to MainScreen*/
    public void returnToMainScreenBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnToMainScreenId.getScene().getWindow();
        window.setScene(new Scene(root, 800,555));
    }
}
