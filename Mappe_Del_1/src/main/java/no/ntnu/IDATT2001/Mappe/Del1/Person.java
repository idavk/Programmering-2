package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager en abstrakt Superklasse som klassen Patient og Employee kan extendes fra
 * for å slippe å mætte skrive all den felles informasjonen de to klassene har to ganger.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public abstract class Person {
    /**
     * Legger inn nødvendige attributer i klassen som kommer til å være felles for både
     * Patient og Employee klassene.
     */
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;

    public Person(String firstName,String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    //Lager gettere for alle attributene:
    /**
     * Lager get-metode for å kunne returnere fornavnet på en person som blir lagt til.
     * @return fornavnet på en person
     */
    public String getFirstName(){
        return firstName;
    }


    /**
     * Lager en get-metode for å kunne returnere etternavnet til en person
     * @return etternavnet på en person
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Lager en get-metode for å kunne returnere personnummeret til en person som blir registrert
     * @return personnummeret til en person
     */
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    /**
     * Lager en get-metode for å returnere fullt navn til en person
     * @return Hele navnet til en person
     */
    public String getFullName(){
        return firstName + " " + lastName;
    }

    // Lager settere for de ulike attributtene:

    /**
     * Lager en setter for fornavn for å kunne legge fornavnet til en person
     * @param firstName til en person
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Lager en setter for å kunne legge til etternavnet til en person
     * @param lastName til en person
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Lager en setter for å kunne registere navnet til en person
     * @param socialSecurityNumber til en person
     */
    public void setSocialSecurityNumber(String socialSecurityNumber){
        this.socialSecurityNumber = socialSecurityNumber;
    }


    /**
     * Lager en toString metode for å kunne hente ut informasjonen om en person på en ryddig måte.
     * @return fornavnet, etternavnet og personnummeret til en person
     */
    @Override
    public String toString() {
        return "Person: " +
                "\n FirstName: " + firstName +
                "\n LastName: " + lastName +
                "\n SocialSecurityNumber: " + socialSecurityNumber;
    }
}
