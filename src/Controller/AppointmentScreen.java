package Controller;

import dao.DBAppointments;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointment;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
/** Appointment Screen Controller
 * @Author Jessica Greenberg Student ID 001462404
 */
public class AppointmentScreen implements Initializable {
    public Button returnbtnID;
    public Button scheduleAppointmentId;
    public Button updateAppointmetnId;
    
    /*AppointmentTable*/
    public TableView appointmentTable;
    public TableColumn appointmentIdCol;
    public TableColumn appTitleCol;
    public TableColumn appDescriptionCol;
    public TableColumn appLocationCol;
    public TableColumn appTypeCol;
    public TableColumn appContactCol;
    public TableColumn appStartCol;
    public TableColumn appEndCol;
    public TableColumn appCustIdCol;
    public TableColumn appUserIdCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentTable.setItems(DBAppointments.getAllAppointments());
        appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        appDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appContactCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        appStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        appEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        appCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
    }

    /** Navigate to the MainScreen */
    public void returnOnAction(ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnbtnID.getScene().getWindow();
        window.setScene(new Scene(root, 800,555));
    }
    /**Navigate to the Schedule Appointment Screen*/
    public void scheduleAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/scheduleAppointment.fxml")));
        Stage window = (Stage) scheduleAppointmentId.getScene().getWindow();
        window.setScene(new Scene(root, 640,520));
    }

    public void UpdateApptBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/updateAppointment.fxml")));
        Stage window = (Stage) updateAppointmetnId.getScene().getWindow();
        window.setScene(new Scene(root, 640,520));
    }

    /**method to delete appointment*/
    public void cancelAppt(ActionEvent actionEvent) throws IOException {

        Appointment selection = (Appointment) appointmentTable.getSelectionModel().getSelectedItem();

        if (selection == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error;please select an appointment");
            alert.setContentText("Select appointment to delete");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Are You Sure?");
            alert.setContentText("Are you sure you want to cancel this appointment? " + "\n" + "ID: " + selection.getAppointmentID() + " " + selection.getType());
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK){
                DBAppointments.deleteAppointment(selection.getAppointmentID());
                appointmentTable.setItems(DBAppointments.getAllAppointments());
                appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
                appTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
                appDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
                appLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
                appTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                appContactCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));
                appStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
                appEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
                appCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
                appUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
            }
        }
    }
}
