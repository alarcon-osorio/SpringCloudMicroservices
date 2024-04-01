package com.tlaxcala.securesapp.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlaxcala.securesapp.entity.PatientEntity;
import com.tlaxcala.securesapp.repository.PatientRepository;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientService implements InitializingBean{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CommonService commonService;

    /**
     * Map of Thing mocks
     */
    private Map<String, PatientEntity> patientsMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() {
        // Populates the Map with mocks at bean intialization
        IntStream.range(1, 10).forEach(
                index -> patientsMap.put("patient" + index, PatientEntity.builder()
                        .idPatient("idPatient" + index)
                        .firstName("firstName" + index)
                        .lastName("lastName" + index)
                        .dni("dni" + index)
                        .address("address" + index)
                        .phone("phone" + index)
                        .email("email" + index)
                        .build()));
    }

    /**
     * Gets a {@link PatientEntity} instance by its identifier
     *
     * @param idPatient Thing's identifier
     * @return {@link PatientEntity} instance if exists or IllegalArgumentException if not.
     */
    public Single<PatientEntity> findById(final String transactionId, final String id) {
        return Single.create(emitter -> {
            log.info("{}: Evaluating service findById...", transactionId);
            
            // Configurar el cliente HTTP
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/patients/" + id)) // Reemplaza "URL_DEL_ENDPOINT_EXTERNO" por la URL real del endpoint externo
                    .build();
            
            // Realizar la llamada al endpoint externo
            CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            
            log.info("Response --> " + responseFuture.get());

            // Manejar la respuesta
            responseFuture.thenAccept(response -> {
                if (response.statusCode() == 200) {
                    // Si la llamada es exitosa, procesar la respuesta y emitir el resultado
                    PatientEntity patientEntity = procesarRespuesta(response.body());
                    emitter.onSuccess(patientEntity);
                    log.info("Respuesa exitosa con el Body: " + response.body());
                    log.info("Enviando orden para guardar en base de datos MONGO");

                    try{
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(response.body());

                        String idPatient = jsonNode.get("idPatient").asText();
                        log.info("Validar existencia de ID: " + idPatient);

                        String resultIdPatient = patientRepository.findByIdPatient(idPatient);
                        log.info("result consult exist ---> " + resultIdPatient);

                        if (resultIdPatient == null) {
                            commonService.operacionAsincrona(patientEntity);
                            //insertPatient(patientEntity);
                            log.info("Registro insertado");
                        }else{
                            log.info("Registro existe no se inserta");
                        }
                        
                    }catch(Exception ex){
                        ex.printStackTrace();
                        log.info("Exception ---> " +  ex);
                        
                    }
                    
                } else {
                    // Si hay un error, emitir un error
                    emitter.onError(new RuntimeException("Error al llamar al endpoint externo. Código de estado: " + response.statusCode()));
                }
            }).exceptionally(ex -> {
                // Manejar errores de forma asincrónica
                emitter.onError(ex);
                return null;
            });
        });
    }

    // Método para procesar la respuesta del endpoint externo y crear una instancia de PatientEntity
    private PatientEntity procesarRespuesta(String responseBody) {
        // Implementa la lógica para procesar el cuerpo de la respuesta y crear una instancia de PatientEntity
        // Aquí se asume que responseBody contiene la información necesaria para crear un PatientEntity
        log.info("Response resposebody " + responseBody);
        
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);
    
            PatientEntity patientEntity = new PatientEntity();
            patientEntity.setIdPatient(jsonNode.get("idPatient").asText());
            patientEntity.setFirstName(jsonNode.get("firstName").asText());
            patientEntity.setLastName(jsonNode.get("lastName").asText());
            patientEntity.setDni(jsonNode.get("dni").asText());
            patientEntity.setPhone(jsonNode.get("phone").asText());
            patientEntity.setAddress(jsonNode.get("address").asText());
            patientEntity.setEmail(jsonNode.get("email").asText());
            return patientEntity;
        }catch(Exception ex){
            ex.printStackTrace();
            log.info("Exception ---> " +  ex);
            return null;
        } 
    }

    @SuppressWarnings("null")
    public void insertPatient(PatientEntity patientEntity) {
        mongoTemplate.insert(patientEntity, "patients");
    }
}
