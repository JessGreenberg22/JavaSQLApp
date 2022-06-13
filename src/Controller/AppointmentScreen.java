package Controller;

import dao.DBAppointments;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
        appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("APT ID"));
        appTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        appDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        appLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        appTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        appContactCol.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        appStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        appEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        appCustIdCol.setCellValueFactory(new PropertyValueFactory<>("Cust Id"));
        appUserIdCol.setCellValueFactory(new PropertyValueFactory<>("User Id"));
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
}
