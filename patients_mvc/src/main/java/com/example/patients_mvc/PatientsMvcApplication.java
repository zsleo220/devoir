package com.example.patients_mvc;

import com.example.patients_mvc.entities.Patient;
import com.example.patients_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,100));
            patientRepository.save(new Patient(null,"Hasnae",new Date(),true,450));
            patientRepository.save(new Patient(null,"Kamal",new Date(),false,214));
            patientRepository.save(new Patient(null,"Bachir",new Date(),true,198));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());

            });
        };

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
