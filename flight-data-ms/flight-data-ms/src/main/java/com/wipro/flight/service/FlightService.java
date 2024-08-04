package com.wipro.flight.service;

import com.wipro.flight.entity.FlightDetails;

import java.util.List;

public interface FlightService {

    public List<FlightDetails> getAllFlights(String source,String destination,String date);

    public FlightDetails getFlightById(int id);

    void saveFlight(FlightDetails flightDetails);
}
