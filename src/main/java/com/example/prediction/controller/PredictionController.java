package com.example.prediction.controller;

import com.example.prediction.model.StressPredictionRequest;
import com.example.prediction.service.StressPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PredictionController {

    @Autowired
    private StressPredictionService stressPredictionService;

    @RequestMapping("/")
    public String showForm() {
        return "input-form";
    }

    @PostMapping("/predict")
    public String predictStress(StressPredictionRequest predictionRequest, Model model) {
        // Menggunakan service untuk memprediksi tingkat stres
        int stressLevel = stressPredictionService.predictStressLevel(predictionRequest);
        model.addAttribute("stressLevel", stressLevel);
        return "dashboard";
    }
}
