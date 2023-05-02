/** @author aidanelliot, quintontysick
 * Controller file for application
 */

package com.example.assignment2;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.http.TwilioRestClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for the Hello application that sends SMS messages using Twilio API.
 */
public class HelloController {
    // Private instance variables to hold Twilio account information and client object.
    private String accountSid;
    private String authToken;
    private TwilioRestClient client;

    // FXML annotations for UI elements in the Hello application.
    @FXML
    private TextField toField;

    @FXML
    private TextArea messageArea;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button sendButton;

    /**
     * Constructor for the HelloController class that initializes Twilio account information and client object.
     * The values for accountSid and authToken are taken from the HelloApplication class.
     */
    public HelloController() {
        this.accountSid = HelloApplication.ACCOUNT_SID;
        this.authToken = HelloApplication.AUTH_TOKEN;
        this.client = new TwilioRestClient.Builder(this.accountSid, this.authToken).build();
    }

    /**
     * Method to set the Twilio account information and client object.
     *
     * @param accountSid The Twilio account SID.
     * @param authToken  The Twilio account auth token.
     */
    public void setCredentials(String accountSid, String authToken) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.client = new TwilioRestClient.Builder(this.accountSid, this.authToken).build();
    }

    /**
     * Event handler for the Send button in the Hello application that sends an SMS message using Twilio API.
     * If the message is sent successfully, the UI elements are cleared and a success message is displayed.
     * If there is an error sending the message, an error message is displayed.
     *
     * @param event The ActionEvent object representing the button click event.
     */
    @FXML
    public void onSendButtonClick(ActionEvent event) {
        try {
            // Use Twilio Message creator to send an SMS message using Twilio API.
            Message.creator(
                    new PhoneNumber(toField.getText()),
                    new PhoneNumber("+15074185977"),
                    messageArea.getText()
            ).create();

            // Clear the UI elements and display success message.
            toField.setText("");
            messageArea.setText("");
            feedbackLabel.setText("Message sent successfully");
        } catch (Exception e) {
            // Display error message if there is an exception sending the message.
            feedbackLabel.setText("Error sending message");
        }
    }
}