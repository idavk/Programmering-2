package no.ntnu.IDATT2001.Mappe.Del1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Lager en klasse Department som skal bestå av flere ulike avdelinger,
 * ansatte og pasienter.
 *
 * @since 2021.02.26
 * @author Ida Angell Veglo Klæstad
 */

public class Department{
    /**
     * Lager atributt for å kunne gi avdelinger et navn.
     */
    private String departmentName;
    private final ArrayList<Employee> employees;
    private final ArrayList<Patient> patients;

    /**
     * Konstruktøren
     * @param departmentName navnet på avdelingen
     */
    //Making the constructor:
    public Department(String departmentName){
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    //Making get-methods:
    /**
     * Lager en get-metode for å kunne hente ut navnet på en avdeling.
     * @return navnet på avdelingen
     */
    public String getDepartmentName(){
        return departmentName;
    }

    /**
     * Lager en get.metode for å kunne hente ut en oversikt over ansatte i
     * den gitt avdelingen. Valgte å bruke ArryList for jeg mener det gir bedre struktur
     * når listen skrives ut.
     * @return liste av ansatte på en avdeling
     */
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    /**
     * Lager en get-metode for å kunne hente ut informasjon over alle pasienter
     * som hører til på en avdeling. Valgte å bruke ArryList for jeg mener det gir bedre struktur
     * når listen skrives ut.
     * @return liste av pasienter i en avdeling
     */
    public ArrayList<Patient> getPatients(){
        return patients;
    }

    /**
     * Lager en set-metode for å kunne gi avdelingen et navn
     * @param departmentName navnet på avdelingen
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Lager en addEmployee for å kunne legge til nye ansatte til en avdeling.
     * Lager en if-statment for å kunne sjekke om den ansatte allerede eksisterer på den
     * gitte avdelingen.
     * @param employee lagt til hvis den ansatte ikke allerde eksisterer.
     */
    public void addEmployee(Employee employee){
        if(!employees.contains(employee)){
            this.employees.add(employee);
        }else{
            throw new IllegalArgumentException("Denne annsatte tilhører denne avdelingen allerede");
        }
    }

    /**
     * Lager en addPatient-metode for å kunne legge til en pasient
     * til en gitt avdeling.
     * Velger å legge til en if-statment for å kunne sjekke om pasienten allerede hører til avdelingen.
     * @param patient lagt til hvis pasientet ikke eksiterer fra før.
     */
    public void addPatient(Patient patient){
        if(!patients.contains(patient)){
            this.patients.add(patient);
        }else{
            throw new IllegalArgumentException("Denne pasientet hører allerede til denne avdelingen.");
        }
    }

    /**
     *Genererer en equals metode for å kunne sammenligne to objekter for å se om den
     * finnes fra før.
     * @param o objekt i department-klassen.
     * @return avdelinger med samme navn.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department department = (Department) o;
        return getDepartmentName().compareTo(department.getDepartmentName()) == 0;
    }

    /**
     *Generer en hashcode metode for å kunne se om to objekter har nøyaktig like verdier
     *@return navnet på avdelinger med like verdier.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }

    /**
     * Lager en remove-metode for å kunne fjerne en ansatt eller pasient fra en avdeling
     * @param personToBeRemoved fra lsiten
     * @throws RemoveException bruker RemoveException klassen
     */
    public void remove(Person personToBeRemoved) throws RemoveException {
        if(personToBeRemoved instanceof Employee && employees.contains(personToBeRemoved)){
            employees.remove(personToBeRemoved);
            return;
        }else if(personToBeRemoved instanceof Patient && patients.contains(personToBeRemoved)){
            patients.remove(personToBeRemoved);
            return;
        }
            throw new RemoveException("The person you are trying to remove do not belong to this department");
    }

    /**
     *Lager en toString metode for å kunne hente ut informasjonen over en avdeling og hvem som hører til den
     * @return navn på avdeling, ansatte og pasienter.
     */
    @Override
    public String toString() {
        return "Department: " + departmentName +
                "\n Employees: " + employees +
                "\n Patients: " + patients;
    }
}
