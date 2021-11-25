package no.ntnu.IDATT2001.Mappe.Del1;
/**
 * Lager en klasse Nurse som arver fra klassen Employee.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Nurse extends Employee{
    /**
     * Lager en konstruktør som er basert på konstruktøren i klassen Employee.
     * @param firstName på sykepleieren
     * @param lastName på sykepleieren
     * @param socialSecurityNumber på sykepleieren
     */
    public Nurse(String firstName, String lastName, String socialSecurityNumber){
        super(firstName,lastName,socialSecurityNumber);
    }

    /**
     * Lager en toString metode for å kunne hente ut informasjonen om en sykepleier på en ryddig måte.
     * @return fornavnet, etternavnet og personnummeret på sykepleieren
     */
    @Override
    public String toString() {
        return "Nurse: " +
                "\n FirstName: " + firstName +
                "\n LastName: " + lastName +
                "\n SocialSecurityNumber: " + socialSecurityNumber;
    }
}
