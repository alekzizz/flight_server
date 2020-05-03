package service;

import com.itextpdf.text.Document;
import model.Flight;
import model.Ticket;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.io.File;
import java.util.List;

@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
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
