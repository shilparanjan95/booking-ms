package com.wipro.flight.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FlightDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String airlineName;
    private String source;
    private String destination;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private Double price;
    private boolean isNonStop;









}
