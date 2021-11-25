package no.ntnu.IDATT2001.MappeDel3.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a patient admitted to the register.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class ZipCode implements Serializable {

    //Attributes:
    /**
     * Makes 4 attributes to be able to store the necessary information in a zipCode.
     */
    private String postalCode;
    private String postalPlace;
    private final String municipalityName;
    private final String municipalityNumber;

    //Constructor:
    /**
     * Constructor for creating a new zipCode object.
     * Making exceptions if the attributes are null.
     * Making a if-statement to check if the postalCode is 4 digits long.
     * @param postalCode for the zipCode
     * @param postalPlace for the zipCode
     * @param municipalityName for the zipCode
     * @param municipalityNumber for the zipCode
     */
    public ZipCode(String postalCode, String postalPlace, String municipalityNumber, String municipalityName) {
        if (!(postalCode.length() == 4)) {
            throw new IllegalArgumentException("The postal code must be 4 digits");
        }

        Objects.requireNonNull(postalCode, "Postal code cannot be null");
        Objects.requireNonNull(postalPlace, "Postal place cannot be null");
        Objects.requireNonNull(municipalityName, "Municipality name cannot be null");
        Objects.requireNonNull(municipalityNumber, "Municipality number cannot be null");


        this.postalCode = postalCode;
        this.postalPlace = postalPlace;
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;

    }

    //Making getters:
    /**
     * @return the postalCode of a ZipCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @return the PostalPlace of a ZipCode
     */
    public String getPostalPlace() {
        return postalPlace;
    }

    /**
     * @return the MunicipalityName for the zipCode
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * @return the MunicipalityNumber for a zipCode
     */
    public String  getMunicipalityNumber() {
        return municipalityNumber;
    }

    //Making setters:
    /**
     * Sets a non null postalCode for the zipCode
     *
     * @param postalCode PostalCode to set.Must not be null
     */
    public void setPostalCode(String postalCode) {
        Objects.requireNonNull(postalCode,"Postal code cannot be null");
        this.postalCode = postalCode;
    }

    /**
     * Sets a non null postalPlace for the zipCode
     *
     * @param postalPlace PostalPlace to set. Must not be null
     */
    public void setPostalPlace(String postalPlace) {
        Objects.requireNonNull(postalPlace,"Postal place cannot be null");
        this.postalPlace = postalPlace;
    }

    /**
     * Checks if the given object equals this zipCode
     * zipCodes are the same if the postalCode is the same.
     * A postalCode is a unique ID for the ZipCode.
     *
     * @param o object to compare
     * @return {@code true} if the objects are equal by postalCode. {@code false} if otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return postalCode.equals(zipCode.postalCode);
    }

    /**
     * Makes a unique hashCode for the zipCode.
     *
     * @return HasCode based on the identity of the zipCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(postalCode, postalPlace);
    }

    /**
     * @return a zipCode in a preferred format.
     */
    public String toString() {
        return String.format("%s" + "\t" + "%s" + "\t" + "%s" + "\t" + "%s", postalCode, postalPlace, municipalityNumber, municipalityName);
    }
}
