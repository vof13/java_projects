import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {


    List<Station> route;
    private final StationIndex stationIndex = new StationIndex();
    RouteCalculator calculator;


    @Override
    protected void setUp() {
        addNewLines();
        addNewStation("Московская", 1);
        addNewStation("Венская", 1);
        addNewStation("Ленинградская", 1);

        addNewStation("Омская", 2);
        addNewStation("Минская", 2);
        addNewStation("Гомельская", 2);
        addNewStation("Севастопольская", 2);
        addNewStation("Калининградская", 2);

        addNewStation("Брестская", 3);
        addNewStation("Витебская", 3);


        addConnections();
        calculator= new  RouteCalculator(stationIndex);
    }

    private void addConnections() {
        List<Station> connectionStations1 = new ArrayList<>();
        connectionStations1.add(stationIndex.getStation("Венская", 1));
        connectionStations1.add(stationIndex.getStation("Омская", 2));
        stationIndex.addConnection(connectionStations1);

        List<Station> connectionStations2 = new ArrayList<>();
        connectionStations2.add(stationIndex.getStation("Севастопольская", 2));
        connectionStations2.add(stationIndex.getStation("Брестская", 3));
        stationIndex.addConnection(connectionStations2);
    }

    private void addNewStation(String name, int number) {
        Line line = stationIndex.getLine(number);
        Station station = new Station(name, line);
        stationIndex.addStation(station);
        line.addStation(station);
    }

    private void addNewLines () {
        stationIndex.addLine(new Line(1, "Первая"));
        stationIndex.addLine(new Line(2, "Вторая"));
        stationIndex.addLine(new Line(3, "Третья"));
    }

    @DisplayName("Время проезда одна ветка без пересадок")
    public void testCalculateDurationOneLine(){
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Ленинградская", stationIndex.getLine(1));
        route = calculator.getShortestRoute(from, to);
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 5;
        assertEquals(expected, actual);
    }


    @DisplayName("Маршрут одна ветка без пересадок")
    public void testCalculateRouteOneDirectLine () {
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Ленинградская", stationIndex.getLine(1));
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>();
        expected.add(new Station("Московская", stationIndex.getLine(1)));
        expected.add(new Station("Венская", stationIndex.getLine(1)));
        expected.add(new Station("Ленинградская", stationIndex.getLine(1)));
        assertEquals(expected, actual);
    }


    @DisplayName("Маршрут одна ветка без пересадок в обратном направлении")
    public void testCalculateRouteOneReverseLine () {
        Station from = new Station("Ленинградская", stationIndex.getLine(1));
        Station to = new Station("Московская", stationIndex.getLine(1));
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>();
        expected.add(new Station("Ленинградская", stationIndex.getLine(1)));
        expected.add(new Station("Венская", stationIndex.getLine(1)));
        expected.add(new Station("Московская", stationIndex.getLine(1)));
        assertEquals(expected, actual);
    }
    @DisplayName("Маршрут две ветки с одной пересадкой ")
    public void testCalculateRouteTwoLine () {
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Гомельская", stationIndex.getLine(2));
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>();
        expected.add(new Station("Московская", stationIndex.getLine(1)));
        expected.add(new Station("Венская", stationIndex.getLine(1)));
        expected.add(new Station("Омская", stationIndex.getLine(2)));
        expected.add(new Station("Минская", stationIndex.getLine(2)));
        expected.add(new Station("Гомельская", stationIndex.getLine(2)));

        assertEquals(expected, actual);
    }

    @DisplayName("Время маршрута две ветки с одной пересадкой ")
    public void testCalculateDurationTwoLine(){
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Гомельская", stationIndex.getLine(2));
        route = calculator.getShortestRoute(from, to);
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    @DisplayName("Время маршрута ТРИ ветки с ДВУМЯ пересадками ")
    public void testCalculateDurationThreeLine(){
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Витебская", stationIndex.getLine(3));
        route = calculator.getShortestRoute(from, to);
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }

    @DisplayName("Маршрут ТРИ ветки с ДВУМЯ пересадками ")
    public void testCalculateRouteThreeLine () {
        Station from = new Station("Московская", stationIndex.getLine(1));
        Station to = new Station("Витебская", stationIndex.getLine(3));
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>();
        expected.add(new Station("Московская", stationIndex.getLine(1)));
        expected.add(new Station("Венская", stationIndex.getLine(1)));
        expected.add(new Station("Омская", stationIndex.getLine(2)));
        expected.add(new Station("Минская", stationIndex.getLine(2)));
        expected.add(new Station("Гомельская", stationIndex.getLine(2)));
        expected.add(new Station("Севастопольская", stationIndex.getLine(2)));
        expected.add(new Station("Брестская", stationIndex.getLine(3)));
        expected.add(new Station("Витебская", stationIndex.getLine(3)));


        assertEquals(expected, actual);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

