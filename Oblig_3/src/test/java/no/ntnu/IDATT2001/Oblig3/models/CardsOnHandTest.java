package no.ntnu.IDATT2001.Oblig3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsOnHandTest {

    @Test
    void getSumOfFaces() {
        List<PlayingCard> cards = Arrays.asList(
                new PlayingCard('H', 9),
                new PlayingCard('S', 9)
        );
        CardsOnHand hand = new CardsOnHand(cards);

        assertEquals(18, hand.getSumOfFaces());
    }

    @Nested
    class queenOfSpades {

        @Test
        @DisplayName("hasQueenOfSpades() returns true if hand contains it")
        void hasQueenOfSpadesTrue() {
            List<PlayingCard> cards = Arrays.asList(
                    new PlayingCard('H', 12),
                    new PlayingCard('S', 12)
            );
            CardsOnHand hand = new CardsOnHand(cards);

            assertTrue(hand.hasQueenSpades());
        }

        @Test
        @DisplayName("hasQueenOfSpades() returns false if hand don't contains it")
        void hasQueenOfSpadesFalse() {
            List<PlayingCard> cards = Arrays.asList(
                    new PlayingCard('H', 10),
                    new PlayingCard('S', 11)
            );
            CardsOnHand hand = new CardsOnHand(cards);

            assertFalse(hand.hasQueenSpades());
        }
    }

    @Nested
    class hasFlushTest {

        @Test
        @DisplayName("hasFlush() returns true if hand contains it")
        void hasFlushTrue() {
            List<PlayingCard> cards = Arrays.asList(
                    new PlayingCard('S', 1),
                    new PlayingCard('S', 2),
                    new PlayingCard('S', 3),
                    new PlayingCard('S', 4),
                    new PlayingCard('S', 5)
            );
            CardsOnHand hand = new CardsOnHand(cards);

            assertTrue(hand.flush());
        }

        @Test
        @DisplayName("hasFlush() returns false if hand dont contains it")
        void hasFlushFalse() {
            List<PlayingCard> cards = Arrays.asList(
                    new PlayingCard('H', 9),
                    new PlayingCard('H', 2),
                    new PlayingCard('H', 3),
                    new PlayingCard('H', 4),
                    new PlayingCard('H', 11)
            );
            CardsOnHand hand = new CardsOnHand(cards);

            assertFalse(hand.flush());
        }
    }

}