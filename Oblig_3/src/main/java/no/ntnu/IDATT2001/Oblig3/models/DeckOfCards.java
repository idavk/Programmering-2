package no.ntnu.IDATT2001.Oblig3.models;

import java.util.ArrayList;

/**
 * Making a class for all the cards in a Deck
 * @author Ida Angell Veglo Klæstad
 */

public class DeckOfCards {
    /**
     * Making to attribute. One to have all the cards in a list and one to get the suit of the cards
     */
    private final char[] suits = {'S', 'H', 'D', 'C'};
    private ArrayList<PlayingCard> deckOfCards;

    /**
     * Making a constructor
     */
    public DeckOfCards(){
        this.deckOfCards = new ArrayList<>();

        for (int i = 1; i < 14; i++) {
            for (char p : suits){
                PlayingCard playingCard = new PlayingCard(p, i);
                deckOfCards.add(playingCard);
            }
        }
    }

    /**
     * Making a getmethod for a deck of cards
     * @return deck of cards
     */
    public ArrayList<PlayingCard> getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * Making a method for dealing a hand
     * @param numOfCards on the hand
     * @return cards on the hand
     */
    public CardsOnHand dealHand (int numOfCards) {
        return new CardsOnHand(numOfCards);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The entire deck: \n");

        deckOfCards.forEach(playingCard -> stringBuilder.append(playingCard.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
