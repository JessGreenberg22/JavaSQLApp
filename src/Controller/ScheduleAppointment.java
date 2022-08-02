package Controller;

import dao.DBContact;
import dao.DBCountry;
import dao.DBUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Contact;
import model.Country;
import model.User;
import utility.Helper;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
/** Schedule Appointment Controller
 * @Author Jessica Greenberg Student ID 001462404
 */
public class ScheduleAppointment implements Initializable {
    public Button ReturnToAppointmentScreenId;
    public Button returnToMainScreenId;
    public ComboBox contactComboBox;
    public ComboBox locationComboBox;
    public ComboBox startComboBox;
    public ComboBox endComboBox;
    public ComboBox typeComboBox;
    private ObservableList<String> types = FXCollections.observableArrayList("Product", "Engineering", "Marketing", "Sales");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            ObservableList<Contact> contacts = DBContact.getAllContacts();
            contactComboBox.setItems(contacts);

            ObservableList<Country> countries = DBCountry.getAllCountries();
            locationComboBox.setItems(countries);

            startComboBox.setItems(Helper.getStartTimeList());

            endComboBox.setItems(Helper.getEndTimeList());

            typeComboBox.setItems(types);

        }

/**Navigation to return to Appointment Screen*/
    public void ReturnToAppointmentScreenBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/appointmentScreen.fxml")));
        Stage window = (Stage) ReturnToAppointmentScreenId.getScene().getWindow();
        window.setScene(new Scene(root, 800,500));
    }
/**Navigation to return to Main Menu*/
    public void returnToMainScreenBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnToMainScreenId.getScene().getWindow();
        window.setScene(new Scene(root, 812,363));
    }
}
