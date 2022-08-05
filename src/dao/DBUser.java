package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUser {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    private static final String SELECT_QUERY = "SELECT * FROM users WHERE user_name = ? and password = ?";

    /**
     * method to validate login credentials and write attempts to login_activity.txt
     */
    public static boolean validate(String username, String password) throws SQLException {
        try {
            Connection connection = JDBC.getConnection();

            PreparedStatement preparedStatement = ((Connection) connection).prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //System.out.println("...valid login");
                //DBConnection.closeConnection();
                return true;
            } else {

                //DBConnection.closeConnection();
                //System.out.println("...invalid login");
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBUser.class.getName()).log(Level.SEVERE, null, e);
            //e.printStackTrace();

        }

        return false;
    }

    /**
     * method to get list of users
     * @return
     */
    public static ObservableList<User> getAllUsers() {

        ObservableList<User> userList = FXCollections.observableArrayList();

        try {

            String sql = "SELECT * FROM users";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("user_ID");
                String userName = rs.getString("User_Name");
                String password = rs.getString("password");
                User u = new User(userID, userName,password);
                userList.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    /*** method to get user ID*/
    public static User getUserId(String username) {

        User user = null;

        try {

            String sql = "SELECT * from users where User_Name = ?";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("user_ID");
                String userName = rs.getString("User_Name");
                String password = rs.getString("password");
                user = new User(userID, userName, password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}
