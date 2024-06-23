package com.hermanyauck.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {

    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

    public <T> T obtenerRecord(String url, Class<T> recordd){
        ConvertDatos conversor = new ConvertDatos();
        ConsumirAPI consumoAPI = new ConsumirAPI();
        String json = consumoAPI.obtenerDatos(url);
        return conversor.obtenerDatos(json, recordd);
    }

}
