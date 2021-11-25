package no.ntnu.IDATT2001.MappeDel3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a zipCode register for the user to add, or delete a zipCode from the register.
 * Chose to add this class to make it easier in further work to implement the functions to add,
 * and remove zipcodes from the register.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 10/05/21
 */
public class ZipCodeRegister {

    //The attribute:
    /**
     * A attribute with a list of ZipCodes.
     */
    private final List<ZipCode> zipCodes;

    //The constructors:
    /**
     * The constructor for a zipCode with already existing zipCodes.
     * @param zipCodes ZipCodes to store in the register
     */
    public ZipCodeRegister(ArrayList<ZipCode> zipCodes) {
        Objects.requireNonNull(zipCodes,"Argument cannot be null");

        this.zipCodes = zipCodes;
    }

    /**
     * Default constructor for a zipCode register.
     * Initialises the internal list with a new, empty list.
     */
    public ZipCodeRegister() {
        this.zipCodes = new ArrayList<>();
    }

    //Getter
    /**
     * @return {@code List} object containing the zipCodes stored in the register.
     */
    public List<ZipCode> getZipCodes() {
        return this.zipCodes;
    }

    //Add-method
    /**
     * Adds a non-null zipCode to the register.
     *
     * @param zipCode ZipCode to add in the register.
     * @return Whether ot not the zipCode could be added to the register, based on whether or not the
     * the zipCode are already presented in the register
     */
    public boolean addZipCode(ZipCode zipCode) {
        Objects.requireNonNull(zipCode, "Argument cannot be null");

        if (!(this.zipCodes.contains(zipCode))){
            this.zipCodes.add(zipCode);
            return true;
        } else {
            return false;
        }
    }

    //Remove-method:
    /**
     * Removes a non-null zipCode from the register.
     *
     * @param zipCode ZipCode to be removed from the register.
     * @return Whether or not the zipCode could be removed from the register,
     * based on whether or not the zipCode are present in the register and able to be removed.
     */
    public boolean removeZipCode(ZipCode zipCode) {
        Objects.requireNonNull(zipCode, "Argument cannot be null");

        return this.zipCodes.remove(zipCode);
    }

}