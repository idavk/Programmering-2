package no.ntnu.IDATT2001.MappeDel3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.IDATT2001.MappeDel3.controllers.factory.SceneFactory;

import java.io.IOException;

/**
 * JavaFX application class.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class App extends Application {
    private static final String TITLE = "ZipCode register";
    private static final String CREATED = "10.04.2021";

    /**
     * Main method, responsible for launching a concrete application from a static context.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Override of {@code Application}'s {@code start()} method.
     * Responsible for Loading and running a stage (window) from an FXML file.
     * @param primaryStage Stage object injected by JavaFX
     * @throws IOException if {@code primaryStage} if the application cannot run.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/MainView.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = SceneFactory.create(root);
        primaryStage.setTitle("Postal code register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Getters:
    /**
     * @return the title for the application
     */
    public static String getTitle() {
        return TITLE;
    }

    /**
     * @return the day the application was created
     */
    public static String getCreated() {
        return CREATED;
    }

    /**
     * @return the version of the application
     */
    public static String getVersion() {
        return "v0.1-SNAPSHOT";
    }
}
