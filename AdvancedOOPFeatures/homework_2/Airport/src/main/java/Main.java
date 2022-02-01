import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        Date date = new Date();

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> (flight.getDate().getHours() - date.getHours() <= 2)
                && (flight.getType() == Flight.Type.DEPARTURE))
                .collect(Collectors.toList());


    }

}