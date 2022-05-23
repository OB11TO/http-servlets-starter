package com.ob11to.http.dao;

import com.ob11to.http.entity.Ticket;
import com.ob11to.http.util.ConnectionManager;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {
    //синглтон
    private static final TicketDao TICKET_DAO_INSTANCE = new TicketDao();

    private TicketDao() {
    }

    private static final String FIND_ALL = """
            SELECT id,
                    passenger_no,
                    passenger_name,
                    flight_id,
                    seat_no,
                    cost
            FROM flight_repository.task26.ticket
                        
            """;
    private static final String FIND_BY_ID_FLIGHT_ID = """
            SELECT *
            FROM task26.ticket
            WHERE flight_id =  ?
            """;

    @Override
    @SneakyThrows
    public List<Ticket> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTickets(resultSet));
            }
            return tickets;
        }
    }

    @SneakyThrows
    public List<Ticket> findByIdFlightId(Integer flight_id){
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_FLIGHT_ID)) {
            preparedStatement.setObject(1,flight_id);
            var resultSet = preparedStatement.executeQuery();
            List<Ticket> ticket = new ArrayList<>();
            while(resultSet.next()){
                ticket.add(buildTickets(resultSet));
            }
            return ticket;
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }

    @SneakyThrows
    private Ticket buildTickets(ResultSet resultSet) {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Integer.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class)
                );
    }

    public static TicketDao getInstance(){
        return TICKET_DAO_INSTANCE;
    }
}
