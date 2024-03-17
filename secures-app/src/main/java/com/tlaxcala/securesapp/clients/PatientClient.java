package com.tlaxcala.securesapp.clients;

import com.mongodb.lang.NonNull;

import io.reactivex.SingleEmitter;

public interface PatientClient<T> {
    
    /**
     * Called for each SingleObserver that subscribes.
     * @param emitter the safe emitter instance, never null
     * @throws Exception on error
     */
    void subscribe(@NonNull SingleEmitter<T> emitter) throws Exception;
    
}
