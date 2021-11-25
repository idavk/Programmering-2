package no.ntnu.IDATT2001.Mappe.Del1;


public final class HospitalTestData {
   HospitalTestData() {
    }
    /**
     * Blir laget en metode for å kunne lage en liste med ansatte og pasienter i ulike avdelinger.
     * @param hospital fra Hospital klassen.
     */
    public static void fillRegisterWithTestData(final Hospital hospital) {
        Department emergency = new Department("Akutten");
        emergency.getEmployees().add(new Employee("Odd Even", "Primtallet", "53695769"));
        emergency.getEmployees().add(new Employee("Huppasahn", "DelFinito", "75869876"));
        emergency.getEmployees().add(new Employee("Rigmor", "Mortis", "47985269"));
        emergency.getEmployees().add(new GeneralPractitioner("Inco", "Gnito", "23458989"));
        emergency.getEmployees().add(new Surgeon("Inco", "Gnito", "12345678"));
        emergency.getEmployees().add(new Nurse("Nina", "Teknologi", "13579348"));
        emergency.getEmployees().add(new Nurse("Ove", "Ralt", "24681357"));
        emergency.getPatients().add(new Patient("Inga", "Lykke", "75386421"));
        emergency.getPatients().add(new Patient("Ulrik", "Smål", "75681360"));
        hospital.getDepartments().add(emergency);
        Department childrenPolyclinic = new Department("Barn poliklinikk");
        childrenPolyclinic.getEmployees().add(new Employee("Salti", "Kaffen", "46091438"));
        childrenPolyclinic.getEmployees().add(new Employee("Nidel V.", "Elvefølger", "54876508"));
        childrenPolyclinic.getEmployees().add(new Employee("Anton", "Nym", "42923801"));
        childrenPolyclinic.getEmployees().add(new GeneralPractitioner("Gene", "Sis", "54876910"));
        childrenPolyclinic.getEmployees().add(new Surgeon("Nanna", "Na", "67584902"));
        childrenPolyclinic.getEmployees().add(new Nurse("Nora", "Toriet", "13456789"));
        childrenPolyclinic.getPatients().add(new Patient("Hans", "Omvar", "12456789"));
        childrenPolyclinic.getPatients().add(new Patient("Laila", "La", "12356789"));
        childrenPolyclinic.getPatients().add(new Patient("Jøran", "Drebli", "12346789"));
        hospital.getDepartments().add(childrenPolyclinic);
        Department orthopedic = new Department("Orthopedic");
        orthopedic.getEmployees().add(new Employee("Johannes", "Karlsen", "56878056"));
        orthopedic.getEmployees().add(new Employee("Per", "Olsen", "58741309"));
        orthopedic.getEmployees().add(new GeneralPractitioner("Astrid", "Jakobsen", "54910678"));
        orthopedic.getEmployees().add(new GeneralPractitioner("Jakob", "Johannesen", "94256019"));
        orthopedic.getEmployees().add(new Surgeon("Kristoffer", "Nilsen", "76342810"));
        orthopedic.getEmployees().add(new Nurse("Sander", "Johansen", "56910100"));
        orthopedic.getPatients().add(new Patient("Marius", "Hansen", "40583427"));
        orthopedic.getPatients().add(new Patient("Kristian", "Larsen", "52638143"));
        orthopedic.getPatients().add(new Patient("Magnus", "Larsen", "56473898"));
        hospital.getDepartments().add(orthopedic);
        Department maternityWard = new Department("Fødeavdelingen");
        maternityWard.getEmployees().add(new Employee("Jakob", "Hansen", "23456809"));
        maternityWard.getEmployees().add(new Employee("Kristian", "Hansen", "57494738"));
        maternityWard.getEmployees().add(new GeneralPractitioner("Johannes", "Johannesen", "47947658"));
        maternityWard.getEmployees().add(new GeneralPractitioner("Ellen", "Pedersen", "54732890"));
        maternityWard.getEmployees().add(new Surgeon("Peder", "Kjøs", "56748319"));
        maternityWard.getEmployees().add(new Surgeon("Frida", "Karlson", "47563892"));
        maternityWard.getEmployees().add(new Nurse("Emil", "Johaug", "65743892"));
        maternityWard.getEmployees().add(new Nurse("Therese", "Iversen", "75654839"));
        maternityWard.getPatients().add(new Patient("Marit", "Klæbo", "45637298"));
        maternityWard.getPatients().add(new Patient("Viktor", "Hovland", "35437698"));
    }

}
