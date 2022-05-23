package com.ob11to.http.service;

import com.ob11to.http.dao.FlightDao;
import com.ob11to.http.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    //синглтон
    private final FlightDao flightDao = FlightDao.getInstance();

    //делаем синглтон
    private static final FlightService FLIGHT_SERVICE_INSTANCE = new FlightService();
    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> new FlightDto(
                        flight.getId(),
                        """
                        %s - %s - %s
                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus())
                ))
                .collect(Collectors.toList());
    }

    public static FlightService getInstance(){
        return FLIGHT_SERVICE_INSTANCE;
    }
}
