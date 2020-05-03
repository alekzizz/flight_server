import service.FlightServiceImpl;
import javax.xml.ws.Endpoint;

public class FlightServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/flight", new FlightServiceImpl());
        System.out.println("Web serwis czeka na klienta...");
    }
}
