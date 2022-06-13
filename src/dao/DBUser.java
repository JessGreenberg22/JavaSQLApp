package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser {
    public static ObservableList<User> getAllUsers() throws SQLException {
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from users";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int userId = rs.getInt("userId");
            String userName = rs.getString("username");
            String userPassword = rs.getString("password");
            User user = new User(userId, userName, userPassword);
            userObservableList.add(user);
        }return userObservableList;
    }
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
