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
        Date currentDate = new Date(System.currentTimeMillis());
        Date inTwoHours = new Date(System.currentTimeMillis() + 2*3600000);

        Stream<Flight> flightStream = airport.getTerminals()
              .stream().flatMap(x -> x.getFlights().stream()
                    .filter(y -> y.getDate().getHours()*60+y.getDate().getMinutes() >= currentDate.getHours()*60+currentDate.getMinutes()
                          && y.getDate().getHours()*60+y.getDate().getMinutes() <= inTwoHours.getHours()*60+inTwoHours.getMinutes()));

      return flightStream.collect(Collectors.toList());
    }
}