package com.bbende.notes.client.service;

import org.gwtproject.http.client.Request;

public interface ServiceCallback<T> {

    void onSuccess(Request request, T dto);

    void onError(Throwable exception);

}
