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
import utility.ListManager;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
/** Main Screen Controller
 * @Author Jessica Greenberg Student ID 001462404
 */
public class MainScreen implements Initializable{

    public Button custRecordsID;
    public Button appointmentBtnId;
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
        window.setScene(new Scene(root, 789,366));
    }
    /**Exit The Application, when you choose to exit the application a confirmation prompt will appear so that you can verify you want to exit*/
    public void exit(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Are you Sure?");
        alert.setContentText("Are you sure you want to exit the program?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentTable.setItems(DBAppointments.getAllAppointments());
        appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        appTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appContactCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        appStartCol.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        appEndCol.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        appCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        appUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }


}
