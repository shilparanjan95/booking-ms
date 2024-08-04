package com.wipro.flight.controller;

import com.wipro.flight.entity.FlightDetails;
import com.wipro.flight.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@Slf4j
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<FlightDetails>> searchAllFlight(@RequestParam("source") String source,
                                                               @RequestParam("destination") String destination,
                                                               @RequestParam("date") String date)
    {
        log.info("searching flight with source {}, destination {} , date {} ",source,destination,date);
        List<FlightDetails> flights = flightService.getAllFlights(source, destination, date);
        if(flights.isEmpty()) {
            log.info("no  flight found for  source {}, destination {} , date {} ", source, destination, date);

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);

    }

    @PostMapping
    public void saveFlight(@RequestBody FlightDetails flightDetails)
    {
         flightService.saveFlight(flightDetails);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FlightDetails> searchFlightById(@PathVariable int id)
    {

        return ResponseEntity.ok(flightService.getFlightById(id));

    }
}
