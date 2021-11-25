package no.ntnu.IDATT2001.Mappe.Del1;
/**
 * Lager en interface klasse Diagnosable for at klassen Patient skal kunne implemnetere fra interfaceklassen.
 * Dette gjøres for at Patient klassen skal kunne "arve" fra flere ulike klasser.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */
public interface Diagnosable {
    /**
     * Lager en set-metode slik at en pasient kan få en diagnose.
     * @param diagnosis på pasienten
     */
    void setDiagnosis(String diagnosis);
}
