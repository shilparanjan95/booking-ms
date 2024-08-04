package com.wipro.flight.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingInfo {

    private UUID bookingId;
    private String status;
    private Double amount;
    private String paymentMode;
    private int flightId;
}
