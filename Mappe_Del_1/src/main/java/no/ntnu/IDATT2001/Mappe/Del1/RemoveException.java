package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager en RemoveException-klasse for å kunne kaste unntak inn for å få de "checked"
 *
 * @author Ida Angell Veglo Klæstad
 * @since 2021.03.04
 */
public class RemoveException extends Exception{
    public RemoveException(String message) {
        super("An error occurred: " + message);
    }
}
