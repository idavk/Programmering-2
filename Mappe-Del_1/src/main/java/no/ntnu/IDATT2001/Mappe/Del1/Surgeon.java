package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager en klasse Surgeon som er en subklasse av klassen Doctor.
 * En kirurg skal kunne sette diagnose på en pasient
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Surgeon extends Doctor{
    /**
     * Lager en konstruktør som er basert på konstruktøren som er basert på konstruktøren i Employee.
     * @param firstName of the Surgeon
     * @param lastName of the Surgeon
     * @param socialSecurityNumber of the Surgeon
     */
    public Surgeon(String firstName, String lastName, String socialSecurityNumber){
        super(firstName,lastName,socialSecurityNumber);
    }

    /**
     * Lager en @Override set-metode for at en kirurg skal kunne sette diagnose på en pasient
     * @param patient from the Patient class
     * @param diagnosis of the patient
     */
    @Override
    public void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
