package com.example.prediction.model;

public class StressPredictionRequest {
    private int gender;
    private int age;
    private int occupation;
    private int sleep;
    private int bmi;
    private int heartRate;
    private int steps;
    private int systolic;

    // Getters and Setters
    public int getgender() { return gender; }
    public void setgender(int gender) { this.gender = gender; }
    public int getage() { return age; }
    public void setage(int age) { this.age = age; }
    public int getoccupation() { return occupation; }
    public void setoccupation(int occupation) { this.occupation = occupation; }
    public int getsleep() { return sleep; }
    public void setsleep(int sleep) { this.sleep = sleep; }
    public int getbmi() { return bmi; }
    public void setbmi(int bmi) { this.bmi = bmi; }
    public int getheartRate() { return heartRate; }
    public void setheartRate(int heartRate) { this.heartRate = heartRate; }
    public int getsteps() { return steps; }
    public void setsteps(int steps) { this.steps = steps; }
    public int getsystolic() { return systolic; }
    public void setsystolic(int systolic) { this.systolic = systolic; }
}
