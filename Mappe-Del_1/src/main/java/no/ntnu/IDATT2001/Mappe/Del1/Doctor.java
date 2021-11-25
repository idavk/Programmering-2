package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager en abstrakt klasse Doctor som fungerer som en Superklasse for
 * klassene Surgeon og GeneralPractitioner.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public abstract class Doctor extends  Employee{
    /**
     * Lager en konstruktør som er basert på konstruktøren som er laget i klassen Employee som den arver fra.
     * @param firstName på den ansatte
     * @param lastName på den ansatte
     * @param socialSecurityNumber på den ansatte
     */
    //Making the constructor based on the constructor from Employee:
    public Doctor(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Lager en abstarkt setter for slik at en kirurg og en allmennlege skal
     * kunne sette diagnose på en pasient.
     * @param patient fra Patient-klassen
     * @param diagnosis på en pasient
     */
    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
