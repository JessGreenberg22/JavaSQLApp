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

public class AppointmentScreen implements Initializable {
    public Button returnbtnID;
    public Button scheduleAppointmentId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /** Navigate to the MainScreen */
    public void returnOnAction(ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnbtnID.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    /**Navigate to the Schedule Appointment Screen*/
    public void scheduleAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/scheduleAppointment.fxml")));
        Stage window = (Stage) scheduleAppointmentId.getScene().getWindow();
        window.setScene(new Scene(root, 640,520));
    }


}
