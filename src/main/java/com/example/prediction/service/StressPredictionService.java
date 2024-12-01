package com.example.prediction.service;

import com.example.prediction.model.StressPredictionRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class StressPredictionService {

    private final String pythonBackendUrl = "http://localhost:5000/predict";
    private final RestTemplate restTemplate;

    public StressPredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int predictStressLevel(StressPredictionRequest request) {
        try {
            // Menyiapkan header dengan format JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Menyiapkan body request
            HttpEntity<StressPredictionRequest> entity = new HttpEntity<>(request, headers);

            // Mengirimkan POST request ke backend Flask dan menerima response
            ResponseEntity<Integer> response = restTemplate.exchange(pythonBackendUrl, HttpMethod.POST, entity, Integer.class);

            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("Error during request: " + e.getMessage());
            return -1; // Indikator error
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return -1; // Indikator error
        }
    }
}
