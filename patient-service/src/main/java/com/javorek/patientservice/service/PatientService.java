package com.javorek.patientservice.service;

import com.javorek.patientservice.DTO.PatientResponseDTO;
import com.javorek.patientservice.mapper.PatientMapper;
import com.javorek.patientservice.model.Patient;
import com.javorek.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> listOfPatients = patientRepository.findAll();
        List<PatientResponseDTO> listOfPatientResponseDTO =
                listOfPatients
                        .stream().map(patient -> PatientMapper.toDTO(patient))
                        .collect(Collectors.toList());
        return listOfPatientResponseDTO;
    }
}
