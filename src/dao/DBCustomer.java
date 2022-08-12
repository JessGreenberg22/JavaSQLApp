package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCustomer {

    /*** displays customer data to tableview on CustomerScreen*/

public static ObservableList<Customer> getAllCustomers() {

    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    try {

        String sql = "SELECT * from customers INNER JOIN first_level_divisions AS d ON d.division_ID = customers.Division_ID";

        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int customerID = rs.getInt("Customer_ID");
            String name = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            int divisionID = rs.getInt("Division_ID");
            Country thisCountry = DBCountry.getCountryByDivisionID(divisionID);
            String country = "";
            if (thisCountry != null) {
                country = thisCountry.getCountryName();
            }
            String division = rs.getString("Division");
            String postalCode = rs.getString("Postal_Code");
            String phoneNumber = rs.getString("Phone");

            Customer nc = new Customer(customerID, name, address, divisionID, postalCode, phoneNumber);
            nc.setDivision(division);
            nc.setCountry(country);
            customerList.add(nc);
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    return customerList;
}

    /**add customer*/
    public static void addCustomer(Customer customer) {

        try {

            String sql = "INSERT INTO customers (Customer_Name, Address, Postal_Code,Phone, Division_ID) VALUES (?,?,?,?,?)";
            PreparedStatement cust = JDBC.getConnection().prepareStatement(sql);
            cust.setString(1, customer.getName());
            cust.setString(2, customer.getAddress());
            cust.setString(3,customer.getPostalCode());
            cust.setString(4,customer.getPhoneNumber());
            cust.setInt(5, customer.getDivisionID());

            int status = cust.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**update customer*/
    public static void modifyCustomer(Customer customer) {

        try {

            String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? Where Customer_ID = ?";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3,customer.getPostalCode());
            ps.setString(4,customer.getPhoneNumber());
            ps.setInt(5, customer.getDivisionID());
            ps.setInt(6, customer.getId());

            int status = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**delete customer and associated appointments*/
    public static void deleteCustomer(int customerId) {

        try {

            String sql = "DELETE FROM customers where customer_id = ?";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, customerId);

            String sql2 = "DELETE FROM appointment where customer_id = ?";
            PreparedStatement pStatement = JDBC.getConnection().prepareStatement(sql2);
            pStatement.setInt(1, customerId);

            int status = ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

