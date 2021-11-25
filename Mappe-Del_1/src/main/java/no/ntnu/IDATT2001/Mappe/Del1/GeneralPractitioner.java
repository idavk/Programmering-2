package no.ntnu.IDATT2001.Mappe.Del1;
/**
 * Lager en klasse GeneralPractitioner som er en subklasse av klassen Doctor.
 * En allmennlege skal kunne sette diagnose på en pasient
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class GeneralPractitioner extends Doctor{
    /**
     * Lager en konstruktør som er basert på konstuktøren i Employee.
     * @param firstName på allmennlegen
     * @param lastName på allmennlegen
     * @param socialSecurityNumber på allmennlegen
     */
    public GeneralPractitioner(String firstName, String lastName, String socialSecurityNumber){
        super(firstName,lastName,socialSecurityNumber);
    }

    /**
     * Lager en @Override set-metode for at en allmennlege skal kunne sette diagnose på en pasient
     * @param patient fra Patient-klassen
     * @param diagnosis på pasienten
     */
    @Override
    public void setDiagnosis(Patient patient,String diagnosis){
        patient.setDiagnosis(diagnosis);
    }
}
