package no.ntnu.IDATT2001.Oblig3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

    private final PlayingCard playingCard = new PlayingCard('S', 2);

    @Nested
    class constructor {

        @Test
        @DisplayName("Contructor throws exception when the face of cards is invalid")
        void faceIsInvalid() {
            assertThrows(IllegalArgumentException.class, ()-> new PlayingCard('S', 60));
        }
    }

    @Test
    @DisplayName("getSuit() return the suit of the card")
    void getSuit() {
        assertEquals(playingCard.getSuit(), 'S');
    }

    @Test
    @DisplayName("getFace() return the face of the card")
    void getFace() {
        assertEquals(playingCard.getFace(), 2);
    }

    @Test
    @DisplayName("toString() retrns the card as a string")
    void testTosString() {
        assertEquals(playingCard.toString(), "S2");
    }

}