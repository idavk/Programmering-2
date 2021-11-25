package no.ntnu.IDATT2001.Oblig3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
    @Test
    @DisplayName("dealHand(n) returns a hand with n cards")
    void dealHand() {
        DeckOfCards deckOfCards = new DeckOfCards();
        CardsOnHand hand = deckOfCards.dealHand(5);

        assertEquals(hand.getHand().size(), 5);
    }

}