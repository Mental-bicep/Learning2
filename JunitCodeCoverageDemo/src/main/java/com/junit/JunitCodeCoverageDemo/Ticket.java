package com.junit.JunitCodeCoverageDemo;



public class Ticket {
    private String passengerName;
    private double farePaid;
    private String status;

    public Ticket(String passengerName, double farePaid, String status) {
        this.passengerName = passengerName;
        this.farePaid = farePaid;
        this.status = status;
    }

    public String getPassengerName() { return passengerName; }
    public double getFarePaid() { return farePaid; }
    public String getStatus() { return status; }
}