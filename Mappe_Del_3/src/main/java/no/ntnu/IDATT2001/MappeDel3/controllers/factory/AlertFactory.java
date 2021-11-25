package no.ntnu.IDATT2001.MappeDel3.controllers.factory;

import javafx.scene.control.Alert;

/**
 * Factory for creating alerts specific to ZipCode register.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class AlertFactory {

    //Method for creating alerts:
    /**
     * General factory method for alerts that require no variable information
     * @param alertType Type of alert to display
     * @return Alert dialog to display for the user
     */
    public static Alert create(AlertType alertType) {
        Alert.AlertType type;
        String title;
        String header;
        String content;

        switch (alertType) {
            case NOT_TXT_FILE: //Alert if the user tries to import a file that's not a txt-file
                type = Alert.AlertType.ERROR;
                title = "Error Alert";
                header = "The file you try to import are not a txt-file";
                content = "Please select a txt-file";
                break;

            case NO_MATCH_ON_SEARCH: //Alert if the zipCode the user searched for doesn't exist
                type = Alert.AlertType.INFORMATION;
                title = "No match";
                header = "The zipcode you search for does not exists";
                content = "Search for another zipcode";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + alertType);
        }
        return createAlert(type, title, header, content);
    }

    //Helper-method for creating an alert:
    /**
     * Helper method to create alerts
     * @param alertType Type of alert.
     * @param title Alert title
     * @param headerText Header text for alert
     * @param contentText Alert content.
     * @return Alert dialog to forward
     */
    private static Alert createAlert(Alert.AlertType alertType, String title,
                                     String headerText, String contentText)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        return alert;
    }

}
