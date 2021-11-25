package no.ntnu.IDATT2001.MappeDel3.modelTests;

import no.ntnu.IDATT2001.MappeDel3.models.ZipCode;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeTest {

    @Nested
    public class ConstructorTest {
        @Test
        public void postalCodeIsNull_throwsException() {
            assertThrows(NullPointerException.class, () -> new ZipCode(null, "Oslo", "0301", "Oslo"));
        }

        @Test
        public void postalPlaceIsNull_throwsException() {
            assertThrows(NullPointerException.class, () -> new ZipCode("0590", null, "0301", "Oslo"));
        }

        @Test
        public void municipalityNumberIsNull_throwsException() {
            assertThrows(NullPointerException.class, () -> new ZipCode("0590", "Oslo", null, "Oslo"));
        }

        @Test
        public void municipalityNameIsNull_throwsException() {
            assertThrows(NullPointerException.class, () -> new ZipCode("0590", "Oslo", "0301", null));
        }
    }

    @Nested
    public class GetterTest {
        @Test
        public void getPostalCode_returnsPostalCode() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertEquals("0590", zipCodeTest.getPostalCode());
        }

        @Test
        public void getPostalPlace_returnPostalPlace() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertEquals("Oslo", zipCodeTest.getPostalPlace());
        }

        @Test
        public void getMunicipalityNumber_returnMunicipalityNumber() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertEquals("0301", zipCodeTest.getMunicipalityNumber());
        }

        @Test
        public void getMunicipalityName_returnMunicipalityName() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertEquals("Oslo", zipCodeTest.getMunicipalityName());
        }
    }

    @Nested
    public class SetterTest {
        @Test
        public void setPostalCode_nullPostalCode_throwsException() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertThrows(NullPointerException.class, () -> zipCodeTest.setPostalCode(null));
        }

        @Test
        public void setPostalCode_nonNullPostalCode_setsPostalCode() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            zipCodeTest.setPostalCode("0590");
            String postalCode = zipCodeTest.getPostalCode();

            assertEquals("0590", postalCode);
        }

        @Test
        public void setPostalPlace_nullPostalPlace_throwsException() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertThrows(NullPointerException.class, () -> zipCodeTest.setPostalCode(null));
        }

        @Test
        public void setPostalPlace_nonNullPostalPlace_setsPostalPlace() {
            ZipCode zipCodeTest = new ZipCode("0590", "Oslo", "0301", "Oslo");

            zipCodeTest.setPostalPlace("Oslo");
            String postalPlace = zipCodeTest.getPostalPlace();

            assertEquals("Oslo", postalPlace);
        }
    }

    @Nested
    public class EqualsTests {
        @Test
        public void equals_equalZipCodes_returnTrue() {
            String testPostalCode = "0590";
            String testPostalPlace = "Oslo";
            String testMunicipalityNumber = "0301";
            String testMunicipalityName = "Oslo";

            ZipCode zipCode1 = new ZipCode(testPostalCode, testPostalPlace, testMunicipalityName, testMunicipalityNumber);
            ZipCode zipCode2 = new ZipCode(testPostalCode, testPostalPlace, testMunicipalityName, testMunicipalityNumber);

            assertTrue(zipCode1.equals(zipCode2) && zipCode2.equals(zipCode1));
        }

        @Test
        public void equals_nonEqualPatients_returnFalse() {
            ZipCode zipCode1 = new ZipCode("0680", "Trondheim", "0305", "Trondheim");
            ZipCode zipCode2 = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertFalse(zipCode1.equals(zipCode2) && zipCode2.equals(zipCode1));
        }

        @Test
        public void equals_nullAsArg_returnFalse() {
            ZipCode zipCode = new ZipCode("0590", "Oslo", "0301", "Oslo");

            assertFalse(zipCode.equals(null));
        }
    }
}