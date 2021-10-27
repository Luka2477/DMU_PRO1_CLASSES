package opgave3;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        Passenger arnold = flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);
        flight.setDepartDate(LocalDateTime.now());
        flight.setArrivalDate(LocalDateTime.now().plusHours(6).plusMinutes(14).plusSeconds(30));

        System.out.println(flight.getAverageAge());
        System.out.println(flight.flightDurationInHours());
        System.out.println(flight.midnightFlight());
    }

}
