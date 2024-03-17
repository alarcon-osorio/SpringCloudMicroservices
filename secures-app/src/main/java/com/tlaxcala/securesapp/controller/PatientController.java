package com.tlaxcala.securesapp.controller;

import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tlaxcala.securesapp.dto.PatientResponse;
import com.tlaxcala.securesapp.entity.PatientEntity;
import com.tlaxcala.securesapp.service.PatientService;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class PatientController {
    
    /**
     * Service for managing {@link PatientEntity} logic
     */
    private PatientService patientService;

    /**
     * Custom constructor for dependency injection
     *
     * @param patientService Service for managing {@link PatientEntity}
     */
    public PatientController(@Autowired PatientService patientService) {
        this.patientService = patientService;
    }
/**
     * Gets the {@link PatientEntity} related to the given Identifier
     *
     * @param idPatient Entity identifier
     * @return {@link PatientResponse} with http 200 (Ok) if the wanted {@link PatientEntity} instance exists or Http 400
     * (Bad Request) if not.
     */
    @GetMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<PatientResponse>> getPatients(@PathVariable String id) {
        String transactionId = UUID.randomUUID().toString();
        log.info("{}: Request received for id: '{}'", transactionId, id);
        Mono<Single<PatientEntity>> responseMono = Mono.fromCallable(() -> patientService.findById(transactionId, id));
        log.info("{}: Request for id: '{}' processed.", transactionId, id);

        return responseMono
            .doOnNext(patient -> log.debug("{}: Success", transactionId))
            .map(PatientController::mapPatientResponse)
            .map(patientResponse -> ResponseEntity.ok(patientResponse))
            .defaultIfEmpty(ResponseEntity.notFound().build())
            .doOnTerminate(() -> log.debug("{}: Terminate", transactionId));

    }

    public static PatientResponse mapPatientResponse(Single<PatientEntity> singlePatientEntity) {
        PatientEntity patientEntity = singlePatientEntity.blockingGet(); // Obtener el PatientEntity del Single

        // Construir el PatientResponse con el PatientEntity y un mensaje opcional
        String message = "Paciente obtenido correctamente"; // Mensaje por defecto
        return PatientResponse.builder()
                              .patientEntity(patientEntity)
                              .message(message)
                              .build();
    }

}
