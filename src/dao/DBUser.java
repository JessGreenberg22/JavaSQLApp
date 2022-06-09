package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

}
