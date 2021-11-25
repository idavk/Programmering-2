package no.ntnu.IDATT2001.Oblig3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Making a class to control cards on the hand
 * @author Ida Angell Veglo Klæstad
 */

public class CardsOnHand {
    /**
     * Making a attribute to make a list for the cards on the hand
     */
    private ArrayList<PlayingCard> hand;
    private final char[] suits = {'S', 'H', 'D', 'C'};

    /**
     * The constructor
     * @param numberOfCards on the hand
     */
    public CardsOnHand (int numberOfCards) {
        DeckOfCards deckOfCards = new DeckOfCards();
        this.hand = new ArrayList<>();
        Random random = new Random();

        if (numberOfCards < 1 || numberOfCards > 52) {
            throw new IllegalArgumentException("The number has to be between 1 and 52");
        }
        while (hand.size() < numberOfCards) {
            PlayingCard addedCard = deckOfCards.getDeckOfCards().get(random.nextInt(52));
            if (!hand.contains(addedCard)) {
                hand.add(addedCard);
            }
        }
    }

    /**
     * The constructor
     * @param cards on the hand
     */
    public CardsOnHand (List<PlayingCard> cards) {
        this.hand = new ArrayList<>(cards);
    }

    /**
     * Get-method to get the cardson the hand
     * @return cards on hand
     */
    public ArrayList<PlayingCard> getHand () {
        return hand;
    }

    /**
     * A method to sum the cards the player has on hand
     * @return sum of the cards on the hand
     */
    public int getSumOfFaces() {
      return hand
                .stream()
                .mapToInt(PlayingCard::getFace)
                .sum();
    }

    /**
     * Method for checking the hands for Hearts
     */
    public ArrayList<PlayingCard> getCardsWithHearts() {
        return (ArrayList<PlayingCard>) hand
                .stream()
                .filter(playingCard -> playingCard.getSuit() == 'H')
                .collect(Collectors.toList());
    }

    /**
     * Method for checking the hand for Queen of Spades
     */
    public boolean hasQueenSpades() {
        PlayingCard queenSpades = new PlayingCard('S', 12);
        return hand.contains(queenSpades);
    }

    /**
     * Method for checking the hand for flush
     */
    public boolean flush() {
        int numSuits = 0;
        for (char c: suits) {
           numSuits = (int) hand.stream().filter(playingCard -> playingCard.getSuit() == c).count();
           return (numSuits >= 5);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The hand of Cards: \n");

        hand.forEach(playingCard -> stringBuilder.append(playingCard.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
