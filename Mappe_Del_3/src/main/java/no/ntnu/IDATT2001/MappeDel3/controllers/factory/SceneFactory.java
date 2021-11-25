package no.ntnu.IDATT2001.MappeDel3.controllers.factory;

import javafx.scene.Parent;
import javafx.scene.Scene;
import no.ntnu.IDATT2001.MappeDel3.App;

/**
 * Factory for creating scenes with a common CSS file.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class SceneFactory {
    /**
     * @param parent Parent object of the caller
     * @return Scene object injected with CSS file.
     */
    public static Scene create(Parent parent) {
        Scene scene = new Scene(parent);

        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        return scene;
    }
}
