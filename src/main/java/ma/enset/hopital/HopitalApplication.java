package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Patient patient = new Patient();
//        patient.setId(null);
//        patient.setNom("Youssef");
//        patient.setMalade(false);
//        patient.setScore(10);
//        patient.setDateNaissance(new Date());
//
//        Patient patient2=new Patient(null,"Yassine",new Date(),false,10);
//        Patient patient3=Patient.builder().nom("Fatima-azzahra").dateNaissance(new Date()).score(33).malade(false).build();
        patientRepository.save(new Patient(null,"fatima-azzahra",new Date(),false,79));
        patientRepository.save(new Patient(null,"Ghizlane",new Date(),true,88));
        patientRepository.save(new Patient(null,"Hafsa",new Date(),false,120));
    }
}
