package com.ob11to.http.entity;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Ticket {
    Long id;
    String passengerNo;
    String passengerName;
    Integer flightId;
    String seatNo;
    BigDecimal cost;
}
