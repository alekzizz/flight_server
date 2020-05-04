package service;

import model.Flight;
import model.Ticket;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface FlightService {

    @WebMethod
    List<Flight> getFlights(String departureCity, String arrivalCity, String date) throws Exception;

    @WebMethod
    Flight getFlight(int flightId) throws Exception;

    @WebMethod
    List<Ticket> getTickets(int clientId) throws Exception;

    @WebMethod
    Flight buyTicket(int flightId, int clientId) throws Exception;

    @WebMethod
    DataHandler getPDF(int ticketId) throws Exception;

}
