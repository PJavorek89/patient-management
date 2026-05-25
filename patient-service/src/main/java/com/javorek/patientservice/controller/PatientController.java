package com.javorek.patientservice.controller;

import com.javorek.patientservice.DTO.PatientRequestDTO;
import com.javorek.patientservice.DTO.PatientResponseDTO;
import com.javorek.patientservice.DTO.validators.CreatePatientsValidationGroups;
import com.javorek.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Parient", description = "API for managing patients")
public class PatientController {

    private static PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get all patients",
            description = "Retrieve a list of all patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID",
            description = "Retrieve a patient by their unique ID")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(patientService.getPatientById(id));
    }


    @PostMapping
    @Operation(summary = "Create a new patient",
            description = "Create a new patient with the provided information")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientsValidationGroups.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok().body(patientService.createPatient(patientRequestDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing patient",
            description = "Update the information of an existing patient by their unique ID")
    public ResponseEntity<PatientResponseDTO> updatePatient(@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO,
                                                            @PathVariable UUID id) {
        return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
    }

    @PutMapping("dirty-checking/{id}")
    @Operation(summary = "Update an existing patient using dirty checking",
            description = "Update the information of an existing patient by their unique ID using dirty checking")
    public ResponseEntity<PatientResponseDTO> updatePatientUsingDirtyChecking(@Valid @RequestBody PatientRequestDTO patientRequestDTO,
                                                            @PathVariable UUID id) {
        return ResponseEntity.ok().body(patientService.updatePatientUsingDirtyChecking(id, patientRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient by ID",
            description = "Delete a patient from the system by their unique ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Patient successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    public ResponseEntity<Void> deletePatientByEmail(@PathVariable UUID id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }

}
