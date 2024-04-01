package com.tlaxcala.securesapp.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings("null")
    public CompletableFuture<Object> operacionAsincrona(Object object) {
        CompletableFuture<Object> future = new CompletableFuture<>();

        // Simulamos una operación asíncrona
        Executors.newCachedThreadPool().submit(() -> {
            try {
                // Simular una operación que tarda más de 30 segundos
                Thread.sleep(60000);
                
                log.info("Registro insertado por common despues de 60Segs");
                mongoTemplate.insert(object);
                // Completa el futuro con el resultado exitoso
                future.complete(new Object());
            } catch (InterruptedException e) {
                // Si la operación es interrumpida, completa el futuro con una excepción
                future.completeExceptionally(new RuntimeException("Operación interrumpida"));
            }
        });

        // Simular un timeout después de 2 segundos
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            if (!future.isDone()) {
                future.completeExceptionally(new RuntimeException("Timeout excedido"));
            }
        }, 30, TimeUnit.SECONDS);

        return future;
    }

    @SuppressWarnings("null")
    public void insertCommon(Object object) {
        log.info("Registro insertado por common");
        mongoTemplate.insert(object);
    }

    
}
