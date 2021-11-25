package no.ntnu.IDATT2001.MAppe.Del1;

import no.ntnu.IDATT2001.Mappe.Del1.Department;
import no.ntnu.IDATT2001.Mappe.Del1.Employee;
import no.ntnu.IDATT2001.Mappe.Del1.Patient;
import no.ntnu.IDATT2001.Mappe.Del1.RemoveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Lager en DepartemntTest-klasse for å kunne utføre JUnit-tester på remove-metoden som ble implementert
 * Velger å utføre både positive og negative tester for å kunne vite at begge deler funker.
 */
 @Nested
 class DepartmentTestPositives {
     @Test
     @DisplayName("Method throws a RemoveException when failing")
     void TheEmployeeExists() {
         Employee test = new Employee("Malin", "Jensen", "234560");
         Department department = new Department("TestDepartment");
         assertThrows(RemoveException.class, () -> department.remove(test));
     }

     @Test
     void ThePatientExists() {
         Patient test = new Patient("Grete", "Hansen", "678908");
         Department department = new Department("TestDepartment");
         assertThrows(RemoveException.class, () -> department.remove(test));

     }
 }
 @Nested
 class RemoveTestNegative{
     @Test
     void TheEmployeeExists() throws RemoveException {
            Employee test = new Employee("Ida", "Jansen", "46543276");
            Department department = new Department("Test departemnt");
            department.addEmployee(test);
            assertEquals(test, department.getEmployees().get(0));
            department.remove(test);
            assertEquals(0, department.getEmployees().size());
        }

     @Test
     @DisplayName("this error occurred")
     void ThePatientExistst() throws RemoveException {
         Patient test = new Patient("Hanne", "Larsen", "4653278");
         Department department = new Department("Test Departemnt");
         department.addPatient(test);
         assertEquals(test, department.getPatients().get(0));
         department.remove(test);
         assertEquals(0, department.getPatients().size());
     }

 }

