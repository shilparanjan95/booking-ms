package com.wipro.flight.repository;

import com.wipro.flight.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<FlightDetails,Integer> {


    List<FlightDetails> findBySourceAndDestinationAndFromDate(String source, String destination, String toDate);

}
