import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).stream().forEach(System.out::println);
      }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        LocalDateTime currentTime  = LocalDateTime.now();

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> formatDate(flight).isAfter(currentTime) && formatDate(flight).isBefore(currentTime.plusHours(2)))
                .collect(Collectors.toList());
    }

    public  static LocalDateTime formatDate(Flight date)
    {
        return date.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}