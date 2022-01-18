import junit.framework.TestCase;
import core.Line;
import core.Station;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class RouteCalculatorTest extends TestCase{

    List<Station> routeWithOneConnection = new ArrayList<>();
    List<Station> routeWithTwoConnection = new ArrayList<>();

    Line line1 = new Line(1,"Первая");
    Line line2 = new Line(2,"Вторая");
    Line line3 = new Line(3,"Третья");

    @Override
    public void setUp() throws Exception {
        routeWithOneConnection.add(new Station("Политехническая",line1));
        routeWithOneConnection.add(new Station("Шулявка",line1));
        routeWithOneConnection.add(new Station("Осокорки",line1));
        routeWithOneConnection.add(new Station("Святошино",line1));
        routeWithOneConnection.add(new Station("Выставочный центр",line2));
        routeWithOneConnection.add(new Station("Демеевская",line2));
        routeWithOneConnection.add(new Station("Голосеевска",line2));
        routeWithOneConnection.add(new Station("Васильковская",line2));


        routeWithTwoConnection.add(routeWithOneConnection.get(0));
        routeWithTwoConnection.add(routeWithOneConnection.get(1));
        routeWithTwoConnection.add(routeWithOneConnection.get(2));
        routeWithTwoConnection.add(routeWithOneConnection.get(3));
        routeWithTwoConnection.add(routeWithOneConnection.get(4));
        routeWithTwoConnection.add(routeWithOneConnection.get(5));
        routeWithTwoConnection.add(routeWithOneConnection.get(6));
        routeWithTwoConnection.add(routeWithOneConnection.get(7));
        routeWithTwoConnection.add(new Station("Беговая",line3));
        routeWithTwoConnection.add(new Station("Новокрестовская",line3));
        routeWithTwoConnection.add(new Station("Приморская",line3));
        routeWithTwoConnection.add(new Station("Василеостровская",line3));


        line1.addStation(routeWithTwoConnection.get(0));
        line1.addStation(routeWithTwoConnection.get(1));
        line1.addStation(routeWithTwoConnection.get(2));
        line1.addStation(routeWithTwoConnection.get(3));
        line2.addStation(routeWithTwoConnection.get(4));
        line2.addStation(routeWithTwoConnection.get(5));
        line2.addStation(routeWithTwoConnection.get(6));
        line2.addStation(routeWithTwoConnection.get(7));
        line3.addStation(routeWithTwoConnection.get(8));
        line3.addStation(routeWithTwoConnection.get(9));
        line3.addStation(routeWithTwoConnection.get(10));
        line3.addStation(routeWithTwoConnection.get(11));
    }

    @Test
    public void testCalculateDurationWithOneConnection(){
        double expected = 18.5;
        double actual = RouteCalculator.calculateDuration(routeWithOneConnection);
        assertEquals(expected,actual);
    }

    @Test
    public void testCalculateDurationWithTwoConnection(){
        double expected = 18.5;
        double actual = RouteCalculator.calculateDuration(routeWithOneConnection);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetRouteOnTheLine(){
        RouteCalculator routeCalculator = new RouteCalculator(new StationIndex());
        Station from = line1.getStations().get(0);
        Station to = line1.getStations().get(3);
        List<Station> actualRoute = routeCalculator.getShortestRoute(from,to);
        assertEquals(line1.getStations(),actualRoute);
    }

    @Test
    public void testGetRouteWithOneConnection(){

        StationIndex stationIndex = new StationIndex();
        stationIndex.addConnection(routeWithOneConnection);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = line1.getStations().get(0);
        Station to = line2.getStations().get(3);
        List<Station> actualRoute = routeCalculator.getShortestRoute(from,to);
        assertEquals(routeWithOneConnection,actualRoute);
    }

    @Test
    public void testGetRouteWithTwoConnections(){

        StationIndex stationIndex = new StationIndex();
        stationIndex.addConnection(routeWithTwoConnection);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = line1.getStations().get(0);
        Station to = line3.getStations().get(3);
        List<Station> actualRoute = routeCalculator.getShortestRoute(from,to);
        assertEquals(routeWithTwoConnection,actualRoute);
    }


    public void tearDown() throws Exception {
    }

}




