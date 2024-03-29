package service;

import com.itextpdf.text.Document;
import db.MySQLAccess;
import model.Flight;
import model.Ticket;
import model.Utils;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@MTOM
@WebService(endpointInterface = "service.FlightService")
@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public class FlightServiceImpl implements FlightService {

    private final MySQLAccess dao = new MySQLAccess();

    @Override
    public List<Flight> getFlights(String departureCity, String arrivalCity, String date) throws Exception {
        List<Flight> flights = dao.getFlights();
        List<Flight> filteredFlights = new ArrayList<>(flights);
        if (departureCity != null) {
            for (Flight flight :
                    flights) {
                if (!flight.getDepartureCity().equals(departureCity))
                    filteredFlights.remove(flight);
            }
        }
        if (arrivalCity != null) {
            for (Flight flight :
                    flights) {
                if (!flight.getArrivalCity().equals(arrivalCity))
                    filteredFlights.remove(flight);
            }
        }
        if (date != null) {
            for (Flight flight :
                    flights) {
                if (!flight.getDate().equals(date))
                    filteredFlights.remove(flight);
            }
        }
        return filteredFlights;
    }

    @Override
    public Flight getFlight(int flightId) throws Exception {
        return dao.getFlight(flightId);
    }

    @Override
    public List<Ticket> getTickets(int clientId) throws Exception {
        return dao.getTickets(clientId);
    }

    @Override
    public Flight buyTicket(int flightId, int clientId) throws Exception {
        dao.buyTicket(flightId, clientId);
        Flight flight = dao.getFlight(flightId);
        dao.setSoldTickets(flightId, flight.getSoldTickets()+1);
        return flight;
    }

    @Override
    public DataHandler getPDF(int ticketId) throws Exception {
        Ticket ticket = dao.getTicket(ticketId);
        return Utils.generatePDFFromTicket(ticket);
    }
}
