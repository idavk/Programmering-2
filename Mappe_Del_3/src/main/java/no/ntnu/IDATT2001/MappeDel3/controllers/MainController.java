package no.ntnu.IDATT2001.MappeDel3.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import no.ntnu.IDATT2001.MappeDel3.App;
import no.ntnu.IDATT2001.MappeDel3.controllers.factory.AlertFactory;
import no.ntnu.IDATT2001.MappeDel3.controllers.factory.AlertType;
import no.ntnu.IDATT2001.MappeDel3.models.ZipCode;

import no.ntnu.IDATT2001.MappeDel3.models.serialization.ZipCodeDeserializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * JavaFx mainController
 *
 * @author Ida Angell Veglo Klæstad
 */
public class MainController {

    @FXML
    private TableView<ZipCode> zipCodeTable;

    @FXML
    private TableColumn<ZipCode, String> postalCodeColumn;

    @FXML
    private TableColumn<ZipCode, String> postalPlaceColumn;

    @FXML
    private TableColumn<ZipCode, String> municipalityNumberColumn;

    @FXML
    private TableColumn<ZipCode, String> municipalityNameColumn;

    @FXML
    private TextField searchBar;

    private final ObservableList<ZipCode>  data = FXCollections.observableArrayList();
    private final ObservableList<ZipCode> zipCodeObservableList = FXCollections.observableArrayList();
    private final FilteredList<ZipCode> searchData = new FilteredList<>(data, e -> true);

    /**
     * JavaFX initializer.
     * Initializes zipCode table and fills its content, if any.
     */
    @FXML
    private void initialize() {
        this.zipCodeTable.setItems(data);

        this.postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        this.postalPlaceColumn.setCellValueFactory(new PropertyValueFactory<>("postalPlace"));
        this.municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));
        this.municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));
    }

    //Listeners for the MenuBar:

    //File-menu:
    /**
     * Listener for "Import txt" menu item's {@code onAction} event.
     * The user will get an alert if they try to import a fil that's not a txt-file.
     * I made the fileChooser to only open files that's a txt-fil in "Filutforsker".
     */
    @FXML
    private void onImportTxt() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Txt file", "*.txt"
        ));
        File file = fileChooser.showOpenDialog(null);

        try (InputStream inputStream = new FileInputStream(file)){
            ZipCodeDeserializer deserializer = new ZipCodeDeserializer((FileInputStream) inputStream);
        } catch (RuntimeException runtimeException) {
            AlertFactory.create(AlertType.NOT_TXT_FILE).showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileChooser != null) {
           zipCodeTable.getItems().clear();
            List<ZipCode> zipCodes = ZipCodeDeserializer.deserializer(file);
            zipCodeTable.getItems().addAll(zipCodes);
            zipCodeTable.refresh();
        }
    }

    /**
     * The listener for "exit" menu item's {@code onExit} event.
     */
    @FXML
    private void onExit() {
        System.exit(0);
    }

    //Help-menu:
    /**
     * The listener for "about" menu item's {@code onAbout} event.
     */
    @FXML
    private void onAbout() {
        Alert infoDialog = new Alert(Alert.AlertType.INFORMATION);
        infoDialog.setTitle("Information Dialog - About");
        infoDialog.setHeaderText(App.getTitle() + '\n' + App.getCreated());
        infoDialog.setContentText("An application created by" + '\n' +
                "© Ida Angell Veglo Klæstad" + '\n' + App.getVersion());

        infoDialog.show();
    }

    //Listener for search:
    /**
     * A listener for the TextField to search for a part or the hole PostalCode or the PostalPlace {@code onAction} event.
     * If the searchBar is empty the user will see the hole list of zipCode. If the user search with the postalCode the list will
     * update to match the search of the user. The same thing will happen if the user search for a PostalPlace.
     * Before the first search the user have to press enter, I could not find out how to make the search
     * update on the first search without click on enter first.
     * After the user have pressed enter the searchbar functions as it should.
     */
    @FXML
    private void onSearch() {
        searchBar.setOnKeyPressed(e -> {
            zipCodeTable.getSelectionModel().clearSelection();
        });

        searchBar.setOnKeyPressed(e -> {
            searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                searchData.setPredicate(zipCode -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if (zipCode.getPostalCode().trim().contains(newValue)) {
                        return true;
                    } else if ((zipCode.getPostalPlace().toLowerCase().trim().contains(toLowerCaseFilter))) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });

            SortedList<ZipCode> zipCodeSortedList = new SortedList<>(searchData);
            zipCodeSortedList.comparatorProperty().bind(zipCodeTable.comparatorProperty());
            zipCodeTable.setItems(zipCodeSortedList);

            if(zipCodeSortedList == null || zipCodeSortedList.isEmpty()) {
                AlertFactory.create(AlertType.NO_MATCH_ON_SEARCH).showAndWait();
            }
        });
    }
}
