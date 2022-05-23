package com.ob11to.http.service;

import com.ob11to.http.dao.TicketDao;
import com.ob11to.http.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private final TicketDao ticketDao = TicketDao.getInstance();

    private static final TicketService TICKET_SERVICE_INSTANCE = new TicketService();

    private TicketService() {
    }

    public static TicketService getInstance() {
        return TICKET_SERVICE_INSTANCE;
    }

    public List<TicketDto> findByIdFlightId(Integer flightId){
        return ticketDao.findByIdFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getPassengerNo(),
                        ticket.getPassengerName(),
                        ticket.getFlightId(),
                        ticket.getSeatNo(),
                        ticket.getCost()
                )).collect(Collectors.toList());
    }


    public List<TicketDto> findAll(){
        return ticketDao.findAll().stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getPassengerNo(),
                        ticket.getPassengerName(),
                        ticket.getFlightId(),
                        ticket.getSeatNo(),
                        ticket.getCost()
                ))
                .collect(Collectors.toList());
    }

}