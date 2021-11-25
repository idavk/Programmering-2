package no.ntnu.IDATT2001.MappeDel3.modelTests;

import no.ntnu.IDATT2001.MappeDel3.models.ZipCode;
import no.ntnu.IDATT2001.MappeDel3.models.ZipCodeRegister;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeRegisterTest {
    @Nested
    public class ConstructorTest {
        @Test
        public void defaultConstructor_initializeEmptyList() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();

            assertEquals(0, zipCodeRegisterTest.getZipCodes().size());
        }

        @Test
        public void parametrizedConstructor_nullAsArg_throwsNullPointerException() {
            assertThrows(NullPointerException.class, () -> new ZipCodeRegister(null));
        }
    }

    @Nested
    public class AddZipCodeTest {
        @Test
        public void addZipCode_nullAsArg_throwsNullPointerException() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();

            assertThrows(NullPointerException.class, () -> zipCodeRegisterTest.addZipCode(null));
        }

        @Test
        public void addZipCode_nonExistingPatientAsArg_addsZipCode() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertTrue(zipCodeRegisterTest.addZipCode(zipCodeTest));
            assertTrue(zipCodeRegisterTest.getZipCodes().contains(zipCodeTest));
        }

        @Test
        public void addZipCode_ExistingZipCodeAsArg_returnFalse() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();
            ZipCode zipCode1 = new ZipCode("0590", "Oslo", "0301", "Oslo");
            ZipCode zipCode2 = new ZipCode("0590", "Oslo", "0301", "Oslo");

            zipCodeRegisterTest.addZipCode(zipCode1);
            assertFalse(zipCodeRegisterTest.addZipCode(zipCode2));
        }
    }

    @Nested
    public class RemoveZipCodeTest {
        @Test
        public void removeZipCode_nullAsArg_throwsNullPointerException() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();
            assertThrows(NullPointerException.class, () -> zipCodeRegisterTest.removeZipCode(null));
        }

        @Test
        public void removeZipCode_existingZipCodeAsArg_returnTrue() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertTrue(zipCodeRegisterTest.addZipCode(zipCodeTest));
            assertTrue(zipCodeRegisterTest.getZipCodes().contains(zipCodeTest));
        }

        @Test
        public void removeZipCode_nonExistingZipCodeAsArg_returnsFalse() {
            ZipCodeRegister zipCodeRegisterTest = new ZipCodeRegister();
            ZipCode zipCode = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertFalse(zipCodeRegisterTest.getZipCodes().contains(zipCode));
        }
    }
}