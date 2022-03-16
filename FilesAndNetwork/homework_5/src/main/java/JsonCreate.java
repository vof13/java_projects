import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonCreate {

    private Map<String, ArrayList<String>> stations = new LinkedHashMap<>();
    private ArrayList<Lines> lines = new ArrayList();

    public void setLines(String number, String name) {
        Lines line = new Lines(number, name);
        this.lines.add(line);
    }

    public ArrayList<Lines> getLines() {
        return lines;
    }

    public Map<String, ArrayList<String>> getStations() {
        return stations;
    }

    public void setStations(String number, ArrayList<String> stations) {
        this.stations.put(number, stations);
    }
}
