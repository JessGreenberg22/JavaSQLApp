package main;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Main Class Application
 * @Author Jessica Greenberg Student ID 001462404
 */

public class Main extends Application {
/*
Opens and closes connections to Database
 */
    public static void main(String[] args)
    {
        JDBC.openConnection();
        JDBC.closeConnection();
    }
    /*
    Loads Stage as Primary/Parent Scene
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }

}
