package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager klassen Patient som arver fra klassen Person og
 * implementerer interface-klassen Diagnosable.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Patient extends Person implements Diagnosable{
    /**
     * Lager en attribut for å kunne legge til en diagnose på en pasient.
     */
    private String diagnosis = "";

    /**
     * Konstuktøren arver fra Person klassen
     * @param firstName til en pasient
     * @param lastName til en pasient
     * @param socialSecurityNumber til en pasient
     */
    //Making a constructor:
    public Patient(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Lager en getter for å kunne returnere diagnosen på en pasient
     * @return diagnosen på en pasient
     */
    public String getDiagnosis(){
        return diagnosis;
    }

    /**
     * @Override metoden setDiagnosis som er implementer fra interface-klassen Diagnosable
     * @param diagnosis til en pasient
     */
    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Lager en toString for å kunne printe ut informasjon om en pasient på en oversiktlig måte.
     * @return fornavnet, etternavnet, personnummeret og diagnosen på en pasient
     */
    @Override
    public String toString() {
        return "Patient: " +
                "\n FirstName: " + firstName +
                "\n LastName: " + lastName +
                "\n SocialSecurityNumber: " + socialSecurityNumber +
                "\n Diagnosis: " + diagnosis;
    }
}
