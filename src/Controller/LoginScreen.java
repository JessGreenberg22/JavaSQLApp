package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {


    public Button LogInButton;
    public Label welcomeLabel;
    public Label enterUserIdLabel;
    public Label userLocationLabel;
    public TextField userIdLabel;
    public TextField passwordLabel;

/**retrieves users zoneID and sets User location label on Login Screen
 * Based on users Zone Id the language will be set to users locale**/
public void setLocation(){
    ZoneId currentLocation = ZoneId.systemDefault();
    userLocationLabel.setText("User Location: " + currentLocation);
    Locale French = new Locale("fr","FR");
    ResourceBundle lf = ResourceBundle.getBundle("login_fr",Locale.getDefault());

    if(Locale.getDefault().getLanguage().equals("fr"))
    {
        Locale.setDefault(French);
        welcomeLabel.setText((lf.getString("Welcome!")).replaceAll("",""));
        enterUserIdLabel.setText((lf.getString("enter")).replaceAll("",""));
        userIdLabel.setPromptText(((lf.getString("UserId")).replaceAll("","")));
        passwordLabel.setPromptText((lf.getString("Password")).replaceAll("",""));
        LogInButton.setText(lf.getString("Login"));

        int indexOfSeperation = (currentLocation.toString()).indexOf("/");
        String countryToPrint = (currentLocation.toString()).substring(0,indexOfSeperation);
        String countryToPrintFR;

        if (countryToPrint.equals("Pacific")||countryToPrint.equals("United States of America") || countryToPrint.equals("Europe"))
        {
            countryToPrintFR = (lf.getString(countryToPrint));
            int indexOfEnd =(currentLocation.toString().length());
            String locationToPrint = (currentLocation.toString().substring(indexOfSeperation,indexOfEnd));
            userLocationLabel.setText((lf.getString("Users location")).replaceAll(",","") + ": " + countryToPrintFR + locationToPrint);
        }
        else
        {
            userLocationLabel.setText(lf.getString("Users location").replaceAll("","") + ": " + currentLocation);
    }
        logInErrorMessage = lf.getString("Incorrect user Id or Password").replaceAll("","");
        logInErrorTitle = lf.getString("Log-In, Failed").replaceAll("","");

    }
}

String logInErrorMessage ="Incorrect user Id or Password";
String logInErrorTitle = "Log-In Failed";

    /** Navigate to the MainScreen */
    public void logInBtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainScreen.fxml")));
        Stage window = (Stage) LogInButton.getScene().getWindow();
        window.setScene(new Scene(root, 800,500));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
       setLocation();




}}
