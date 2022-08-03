package Controller;

import dao.DBCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
/** Customer Records Controller
 * @Author Jessica Greenberg Student ID 001462404
 */
public class CustomerRecords implements Initializable {
    public Button returnButton;
    public Button deleteButton;
    /**Customer Table*/
    public TableView customerTable;
    public TableColumn customerIDCol;
    public TableColumn customerNameCol;
    public TableColumn customerAddressCol;
    public TableColumn customerStateCol;
    public TableColumn customerPostalCol;
    public TableColumn customerPhoneCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        customerTable.setItems(DBCustomer.getAllCustomers());
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerStateCol.setCellValueFactory(new PropertyValueFactory<>("division"));
        customerPostalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }
    /** Navigate to the MainScreen */
    public void returnToMainScreenAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root, 800,555));
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
}