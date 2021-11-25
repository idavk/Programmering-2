package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager klassen Employee som er extended av klassen Person.
 * Dette ble gjort for å slippe å måtte skrive inn de fellesdlene av de ulike klassene.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Employee extends Person{

    /**
     * Konstuktøren arver fra Person-klassen
     * @param firstName til en ansatt
     * @param lastName til en ansatt
     * @param socialSecurityNumber til en ansatt
     */
    //Making a constructor:
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Lager en toString for å kunne printe ut informasjonen over en ansatt.
     * @return fornavnet, etternavnet og personnummeret til en ansatt
     */
    @Override
    public String toString() {
        return "Employee:" +
                "\n FirstName: " + firstName +
                "\n LastName: " + lastName +
                "\n SocialSecurityNumber: " + socialSecurityNumber;
    }
}
