package com.wipro.flight.service.impl;

import com.wipro.flight.entity.FlightDetails;
import com.wipro.flight.repository.FlightRepo;
import com.wipro.flight.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepo flightRepo;


    @Override
    public List<FlightDetails> getAllFlights(String source, String destination, String date) {
        log.info("service call searching flight with source {}, destination {} , date {} ",source,destination,date);
        List<FlightDetails> availableFlights = flightRepo.findBySourceAndDestinationAndFromDate(source, destination, date);
        return availableFlights;
    }

    @Override
    public FlightDetails getFlightById(int id) {
        return flightRepo.findById(id).get();
    }

    @Override
    public void saveFlight(FlightDetails flightDetails) {
        flightRepo.save(flightDetails);

    }
}
