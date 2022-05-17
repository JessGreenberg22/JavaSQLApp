package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/** Main Class Application
 * @Author Jessica Greenberg Student ID 001462404
 */

public class Main extends Application {
/*
Opens and closes connections to Database
 */

    /*
    Loads Stage as Primary/Parent Scene
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("/view/loginScreen.fxml")));
        primaryStage.setTitle("Customer Scheduling System/CRM");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }
    public static void main(String[] args)
    {launch(args); }
}
