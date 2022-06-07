package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainScreen implements Initializable{

    public Button custRecordsID;
    public Button appointmentBtnId;
    
    /**Appointment Table*/
    public TableView apptTable;
    public TableColumn ApptIdColumn;
    public TableColumn TitleColumn;
    public TableColumn descriptionColumn;
    public TableColumn locationColumn;
    public TableColumn contactColumn;
    public TableColumn typeColumn;
    public TableColumn startDateAndTimeCol;
    public TableColumn endDateAndTimeCol;
    public TableColumn customerIdCol;
    public TableColumn userIdCol;



    /**Navigation to customer Records*/
    public void custRecordsAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/customerRecords.fxml")));
        Stage window = (Stage) custRecordsID.getScene().getWindow();
        window.setScene(new Scene(root, 800,455));
    }
    /**Navigation to Appointment Screen*/
    public void appointmentBtnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/appointmentScreen.fxml")));
        Stage window = (Stage) appointmentBtnId.getScene().getWindow();
        window.setScene(new Scene(root, 500,400));
    } @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
/*This sets up the AppointmentTable on the Mainscreen*/
        apptTable.setItems(Appointments.getAllAppointments)
    }
}
