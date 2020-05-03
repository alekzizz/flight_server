package service;

import model.Flight;
import model.Ticket;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import java.io.File;
import java.util.List;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
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
    File getPDF(int ticketId) throws Exception;

}
