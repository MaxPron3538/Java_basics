import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).stream().forEach(System.out::println);
      }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        int twoHours = 7200000;
        int hourInMinutes = 60;
        Date currentDate = new Date(System.currentTimeMillis());
        Date inTwoHours = new Date(System.currentTimeMillis() + twoHours);

        Stream<Flight> flightStream = airport.getTerminals()
              .stream().flatMap(x -> x.getFlights().stream()
                    .filter(y -> y.getDate().getHours()*hourInMinutes+y.getDate().getMinutes() >= currentDate.getHours()*hourInMinutes+currentDate.getMinutes()
                          && y.getDate().getHours()*hourInMinutes+y.getDate().getMinutes() <= inTwoHours.getHours()*hourInMinutes+inTwoHours.getMinutes()));

      return flightStream.collect(Collectors.toList());
    }
}