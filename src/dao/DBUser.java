package dao;

import com.mysql.cj.jdbc.JdbcConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser {
    public static ObservableList<user> getAllUsers() throws SQLException {
        ObservableList<user> userObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from users";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int userId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            String userPassword = rs.getString("Password");
            user user = new user(userId, userName, userPassword);
            userObservableList.add(user);
        }return userObservableList;
    }

}
