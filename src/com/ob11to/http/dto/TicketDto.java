package com.ob11to.http.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class TicketDto {
    Long id;
    String passengerNo;
    String passengerName;
    Integer flightId;
    String seatNo;
    BigDecimal cost;
}
