package no.ntnu.IDATT2001.Mappe.Del1;

/**
 * Lager en cleint-klasse for å kunne hente ut liste over ansatte og pasienter.
 * Kunne slette ansatte og pasienter fra en liste.
 *
 * @author Ida Angell Veglo Klæstad
 * @since 2021.03.08
 */
public class HospitalClient {
   public static Hospital hospital;

    public static void main(String[] args) throws RemoveException {
        Hospital hospital = new Hospital("John Hopkins");
        no.ntnu.IDATT2001.Mappe.Del1.HospitalTestData.fillRegisterWithTestData(hospital);

        Patient patientTest = new Patient("Ida", "Angell", "43786");
        GeneralPractitioner generalPractitionerTest = new GeneralPractitioner("Frida", "Hansen", "45348");
        generalPractitionerTest.setDiagnosis(patientTest,"Appears to be a broken leg. The patient should rest for 7 days.");

        //Removing a Employee successfully:
        hospital.getDepartments().get(0).addEmployee(generalPractitionerTest);
        System.out.println(hospital.toString() + "\n");
        hospital.getDepartments().get(0).remove(generalPractitionerTest);
        System.out.println("\n" + hospital.toString() + "\n");

        //Removing a Patient unsuccessfully:
        try {
            hospital.getDepartments().get(1).remove(patientTest);
        }catch (RemoveException remove){
            System.out.println("The person you tried to remove do not exist in the register");
        }
        hospital.getDepartments().get(0).addPatient(patientTest);
    }

}
