package no.ntnu.iaklaest.IDATT2001.Oblig2;

/**
 *Lager en superklasse som inneholder de felles metodene og trekkene ved de ulike medlemsnivåene.
 * @author Ida Angell Veglo Klæstad
 */

public abstract class Membership {
    /**
     * Lager to objektvariabler for klassen membership.
     */
    private int bonusPointsBalance;
    private int newPoints;

    /**
     * Lager en metode med en tom metodekropp som kan brukes i subklassene.
     * Dette gjør jeg for å samle alle de felles faktorene ved de ulike medlemsnivåene
     * @param bonusPointsBalance
     * @param newPoints
     * @return
     */
    public abstract int registerPoints(int bonusPointsBalance, int newPoints);

    /**
     * Gjør det samme for metoden getMembershipName.
     * Ved å lage to tomme medtoder her vil man spare mye arbeid og man slipper å lage de samme metodene for hver klasse.
     * @return
     */
    public abstract String getMambershipName();

}
