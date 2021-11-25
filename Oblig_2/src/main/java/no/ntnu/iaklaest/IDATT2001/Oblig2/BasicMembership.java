package no.ntnu.iaklaest.IDATT2001.Oblig2;

/**
 * Lager en klasse BasicMembership som arver fra klassen Membership.
 * @author Ida Angell Veglo Klæstad
 */

public class BasicMembership extends Membership{
    /**
     * Her overrider jeg metoden som vi lagde i klassen Membership for å tilpasse den
     * det som er spesielt for basicMembership.
     * @param bonusPointsBalance
     * @param newPoints
     * @return bonusPointsBalance til medlemmet.
     */
    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        bonusPointsBalance += newPoints;
        return bonusPointsBalance;
    }

    /**
     * Gjør det samme i denne metoden slik at den er tilpasset riktig medlemsnivå.
     * @return Basic
     */
    @Override
    public String getMambershipName() {
        return "Basic";
    }

    /**
     * Lager en toString for å kunne finne ut medlemsnivået til et medlem.
     * @return Basic
     */
    public String toString(){
        return getMambershipName();
    }
}
