import model.Flight;
import service.FlightServiceImpl;

import javax.xml.ws.Endpoint;

public class FlightServer {
    public static void main(String[] args) throws Exception{
        Endpoint.publish("http://localhost:9999/ws/flight", new FlightServiceImpl());
        System.out.println(new FlightServiceImpl().buyTicket(35, 1).toString());
        System.out.println("Web serwis czeka na klienta...");
    }
}
