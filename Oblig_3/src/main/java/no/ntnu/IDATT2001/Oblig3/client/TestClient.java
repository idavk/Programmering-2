package no.ntnu.IDATT2001.Oblig3.client;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.IDATT2001.Oblig3.models.CardsOnHand;
import no.ntnu.IDATT2001.Oblig3.models.DeckOfCards;
import no.ntnu.IDATT2001.Oblig3.models.PlayingCard;
import java.util.ArrayList;


public class TestClient extends Application{
    Stage window;
    Scene scene;

    private Label sumOfFacesResult = new Label("");
    private Label cardsWithHeartsResult = new Label("");
    private Label queensOfSpadesResult = new Label("");
    private Label hasFlushResult = new Label("");

    private static final Border defaultBorder = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    private static final DeckOfCards deckOfCards = new DeckOfCards();
    private CardsOnHand cardsOnHand = null;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method for the entire application.
     * The root is a GridPane, and is divided into three sections:
     * The right side: With the deal hand button and a check hand button.
     * The left side: With the deal cards.
     * The bottom section: With the sum of the faces, showing cards with hearts, checking the cards for Queen of Spades and checking the hand for flush.
     *
     * @param primaryStage the primary stage
     */
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Poker Game");

        //Right side:
        VBox rightSide = new VBox(8);
        Button dealHand = new Button("Deal Hand");
        Button checkHand = new Button("Check Hand");
        rightSide.getChildren().addAll(dealHand, checkHand);

        //Bottom text box:
        HBox sumOfFacesBox = new HBox(8);
        sumOfFacesBox.setBorder(defaultBorder);
        sumOfFacesBox.setSpacing(5);
        Label sumOfFacesQ = new Label("Sum of Faces: ");
        sumOfFacesBox.getChildren().addAll(sumOfFacesQ, sumOfFacesResult);

        HBox cardsWithHeartsBox = new HBox(8);
        cardsWithHeartsBox.setBorder(defaultBorder);
        cardsWithHeartsBox.setSpacing(10);
        Label cardsWithHeartsQ = new Label("Cards with Hearts: ");
        cardsWithHeartsBox.getChildren().addAll(cardsWithHeartsQ, cardsWithHeartsResult);

        HBox queenSpadesBox = new HBox(8);
        queenSpadesBox.setBorder(defaultBorder);
        queenSpadesBox.setSpacing(10);
        Label queenSpadesQ = new Label("Has Queen of Spades: ");
        queenSpadesBox.getChildren().addAll(queenSpadesQ, queensOfSpadesResult);

        HBox hasFlushBox = new HBox(8);
        hasFlushBox.setBorder(defaultBorder);
        hasFlushBox.setSpacing(10);
        Label hasFlushQ = new Label("Has Flush: ");
        hasFlushBox.getChildren().addAll(hasFlushQ, hasFlushResult);

        FlowPane bottom = new FlowPane();
        bottom.setVgap(15);
        bottom.setHgap(20);
        bottom.getChildren().addAll(sumOfFacesBox, cardsWithHeartsBox, queenSpadesBox, hasFlushBox);

        //The left side:
        StackPane leftSide = new StackPane();
        leftSide.setPadding(new Insets(10, 10, 10, 10));
        leftSide.setBorder(defaultBorder);



        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(4);

        GridPane.setConstraints(bottom, 0, 15);
        GridPane.setConstraints(rightSide, 4, 10);
        GridPane.setConstraints(leftSide, 0, 3);

        root.getChildren().addAll(bottom, rightSide, leftSide);

        dealHand.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            leftSide.getChildren().clear();
            cardsOnHand = deckOfCards.dealHand(5);
            leftSide.getChildren().add(renderhand(cardsOnHand));
        });

        checkHand.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (cardsOnHand == null) {
                throw new IllegalArgumentException("You have to deal hand first");
            } else {
                checkHand(cardsOnHand);
            }
        });

        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    /**
     * The method thats set the sum of the faces
     * @param cardsOnHand, the cards on hand
     */
    private void getSumOfFacesResult(CardsOnHand cardsOnHand) {
        sumOfFacesResult.setText(String.valueOf(cardsOnHand.getSumOfFaces()));
    }

    /**
     * The method that sets queenOfSpades to text.
     * "Yes" if the hand contains queen of spades, and "No" if it dont contains queen of spades.
     * @param cardsOnHand, cards on hand
     */
    private void getQueenOfSpades(CardsOnHand cardsOnHand) {
        if (cardsOnHand.hasQueenSpades()) {
            queensOfSpadesResult.setText("Yes");
        }
        else {
            queensOfSpadesResult.setText("No");
        }
    }

    /**
     * The method that sets cards with hearts to a text box.
     * If the hand contains hearts it will show which cards it is, but "None" if there is no hearts
     * @param cardsOnHand, cards on hand
     */
    private void getCardsWithHearts (CardsOnHand cardsOnHand) {
        if(cardsOnHand.getCardsWithHearts().isEmpty()) {
            cardsWithHeartsResult.setText("None");
        } else {
            cardsWithHeartsResult.setText(printHearts(cardsOnHand.getCardsWithHearts()));
        }
    }

    /**
     * The method to print the cards of hearts in the hand of cards "H1 H12"
     * @param cardsOnHand, cards on hand
     * @return the cards with hearts on hand as a String.
     */
    private String printHearts(ArrayList<PlayingCard> cardsOnHand) {
        StringBuilder stringBuilder = new StringBuilder();

        cardsOnHand.forEach(playingCard -> stringBuilder.append(playingCard.toString()).append("\n"));

        return stringBuilder.toString();
    }

    /**
     * The method that sets has flush as text box.
     * Print out "Yes if the hand contains flush, and "No" if i dont contains flush.
     * @param cardsOnHand, cards on hand
     */
    private void getHasFlush(CardsOnHand cardsOnHand) {
        if (cardsOnHand.flush()) {
            hasFlushResult.setText("Yes");
        } else {
            hasFlushResult.setText("No");
        }
    }

    /**
     * The method that checks the singel hand of cards and updates all the
     * labels.
     * @param cardsOnHand, cards on hand
     */
    private void checkHand(CardsOnHand cardsOnHand) {
        getSumOfFacesResult(cardsOnHand);
        getQueenOfSpades(cardsOnHand);
        getCardsWithHearts(cardsOnHand);
        getHasFlush(cardsOnHand);
    }

    /**
     * The method takes cards on hand as parameter and renders each
     * playing card in the hand by creating a new label with the face of the cards
     * and the corresponding suit.
     * @param cardsOnHand, cards on hand
     * @return the cards on hand with all rendered cards.
     */
    private Node renderhand(CardsOnHand cardsOnHand) {
        FlowPane hand2 = new FlowPane(Orientation.HORIZONTAL);
        for (PlayingCard c : cardsOnHand.getHand()) {
            Label hand1 = new Label(Character.toString(c.getSuit()) + c.getFace() + " ");
            hand1.setFont(Font.font(20));
            hand2.getChildren().add(hand1);
        }
        return hand2;
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
