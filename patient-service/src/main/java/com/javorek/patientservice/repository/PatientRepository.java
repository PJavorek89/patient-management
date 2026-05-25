package com.javorek.patientservice.repository;

import com.javorek.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);

    //check for the case of updated pacient with the same email as before
    boolean existsByEmailAndIdNot(String email, UUID id);
}
