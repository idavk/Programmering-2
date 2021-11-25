package no.ntnu.IDATT2001.Mappe.Del1;

import java.util.ArrayList;

/**
 * Lager en klasse Hospital som skal bestå av flere ulike avdelinger
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Hospital {
    /**
     * Lager objektvariabelen hospitalName for å kunne gi sykehuset et navn
     */
    private final String hospitalName;
    private final ArrayList<Department> departments;


    /**
     * Konstuktøren
     * @param hospitalName namme of the Hospital
     */
    //Making a constructor;
    public Hospital(String hospitalName){
        this.hospitalName = hospitalName;
        this.departments = new ArrayList<>();
    }

    //Making get-methods:
    /**
     * Lager en get-metode for å kunne hente ut navnet på sykehuset
     * @return hospitalName to get the name of the Hospital
     */
    public String getHospitalName(){
        return hospitalName;
    }

    /**
     * Har laget en metode for å kunne hente ut en liste over avdelinger som er en del sykehuset.
     * Valgte å bruke ArrayList for jeg mener det vil gi en bedre struktur på lsistene.
     * @return depatments in the Hospital
     */
    public ArrayList<Department> getDepartments(){
        return departments;
    }

    /**
     * Laget en metode for å kunne legge til en ny avdeling tilhørende sykehuset.
     * @param department in the hospital
     */
    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            this.departments.add(department);
        } else {
            throw new IllegalArgumentException("Denne avdelingen eksisterer allerede");
        }
    }


    /**
     * Lager en toString for å kunne printe ut en oversikt over navnet på sykehuset.
     * @return name of the Hospital and the departments in the hospital
     */
    @Override
    public String toString() {
        return "Hospital: " + hospitalName +
                "\n Departments: " + departments;
    }

}

