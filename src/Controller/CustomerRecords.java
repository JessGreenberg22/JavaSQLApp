package Controller;

import dao.DBCountry;
import dao.DBCustomer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Country;
import model.Customer;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
/** Customer Records Controller
 * @Author Jessica Greenberg Student ID 001462404
 */
public class CustomerRecords implements Initializable {
   /*TextField and ComboBox Ids*/
   public ComboBox countryComboBox;
    public ComboBox stateComboBox;
    public TextField customerIDFIeld;
    public TextField customerNameField;
    public TextField customerAddressField;
    public TextField postalCodeField;
    public TextField phoneNumberField;

    /**Customer Table*/
    public TableView customerTable;
    public TableColumn customerIdCol;
    public TableColumn customerNameCol;
    public TableColumn customerAddressCol;
    public TableColumn customerCountryCol;
    public TableColumn customerStateCol;
    public TableColumn customerPostalCol;
    public TableColumn customerPhoneCol;

    /*Ids for buttons*/
    public Button returnButton;
    public Button deleteButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)

    /*set Values in the customer Table*/
    {
        ObservableList<Country> countries = DBCountry.getAllCountries();
        countryComboBox.setItems(countries);

        customerTable.setItems(DBCustomer.getAllCustomers());
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerCountryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
        customerStateCol.setCellValueFactory(new PropertyValueFactory<>("division"));
        customerPostalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


    }

    /**handler for the state combo box*/
    public void onCountryComboBox(ActionEvent actionEvent) throws SQLException {
        Country selectedCountry = (Country) countryComboBox.getSelectionModel().getSelectedItem();
        if (selectedCountry != null) {
            ObservableList Division = DBCountry.getFirstLevelDivision(selectedCountry.getCountryID());
            stateComboBox.setItems(Division);
        }
    }

    public void onStateComboBox(ActionEvent actionEvent) {

    }
    /**Add a customer to the Database*/
    public void addCustomer(ActionEvent actionEvent) throws IOException {String name = customerNameField.getText();
        String address = customerAddressField.getText();
        String division = stateComboBox.getSelectionModel().getSelectedItem().toString();
        int divisionID = DBCountry.getDivisionId(division);
        String postalCode = postalCodeField.getText();
        String phoneNumber = phoneNumberField.getText();

        if(!verifyInput(name) || !verifyInput(address) || !verifyInput(postalCode)|| !verifyInput(phoneNumber)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please enter values for each field");
            alert.showAndWait();
            return;
        }

        Customer newCustomer = new Customer(-1, name, address, divisionID, postalCode, phoneNumber);
        DBCustomer.addCustomer(newCustomer);

        JOptionPane.showMessageDialog(null, "You have Successfully added a Customer");
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

    }
    /*Validate input data*/
    public static Boolean verifyInput(String string) {
        if (string.isEmpty() || string.isBlank()) {
            return false;
        } else {
            return true;
        }

    }
    /**Delete Customer from Customer Table & all upcoming appointments that customer has in record*/
    public void deleteCustomer(ActionEvent actionEvent) {
        Customer selection = (Customer) customerTable.getSelectionModel().getSelectedItem();

        if (selection == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setContentText("A customer must be selected to delete");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setContentText("Deleting this customer will also delete any upcoming appointments. Delete this customer?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                DBCustomer.deleteCustomer(selection.getId());
                customerTable.setItems(DBCustomer.getAllCustomers());

            }
        }
    }

    /** Navigate to the MainScreen */
    public void returnToMainScreenAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root, 800,555));
    }
}