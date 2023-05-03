package com.example.assignment2;

import com.twilio.Twilio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * A JavaFX application that uses the Twilio API to send text messages.
 */
public class HelloApplication extends Application {

    /** The Twilio account SID used to authenticate API requests. */
    public static final String ACCOUNT_SID = "AC85b9b777544d49d5bf939d392484f17e";

    /** The Twilio auth token used to authenticate API requests. */
    public static final String AUTH_TOKEN = "dd6f9791a42b20f385cbbd63740bc239";

    /**
     * Initializes the Twilio API with the account SID and auth token and launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); // Initialize Twilio API with credentials
        launch(args);
    }

    /**
     * Starts the JavaFX application by loading the FXML view, setting the Twilio credentials, and showing the stage.
     *
     * @param stage the primary stage for this application
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Get the controller instance from the FXMLLoader
        HelloController controller = loader.getController();

        // Set the Twilio credentials
        controller.setCredentials(ACCOUNT_SID, AUTH_TOKEN);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}