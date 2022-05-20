package com.ob11to.http.entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Flight {
    Integer id;
    String flightNo;
    LocalDateTime departureDate;
    String departureAirportCode;
    LocalDateTime arrivalDate;
    String arrivalAirportCode;
    FlightStatus status;
}
