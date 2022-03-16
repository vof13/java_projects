import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    private static final String pathSource = "https://skillbox-java.github.io/";
    private static final String pathTarget = "D:\\java_projects\\skillbox\\java_basics\\FilesAndNetwork\\homework_5\\src\\main\\resources";
    private static final JsonCreate jsonCreate = new JsonCreate();

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(pathSource).get();
        getLinesAndStation(document);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File(pathTarget+"\\map.json"), jsonCreate);

        JsonNode rootNode = objectMapper.readTree(new File(pathTarget+"\\map.json"));
        JsonNode stationsNode = rootNode.path("stations");
        Map <String, List> stationsMap = objectMapper.convertValue(stationsNode, new TypeReference<Map<String, List>>() {});
        stationsMap.forEach((o1, o2) -> System.out.println("stations: " + o1 + " count " + o2.size()));
    }

    private static void getLinesAndStation (Document document) {
        Elements parsedLines = document.select("span.js-metro-line");

        for (Element line : parsedLines) {
            String lineNumber = line.attr("data-line");
            jsonCreate.setLines(lineNumber, line.text());

            ArrayList<String> stationsList= new ArrayList<>();
            Elements parsedStations = document.select("div.js-metro-stations[data-line=" +
                    lineNumber + "] > p > span.name");
            for (Element station : parsedStations) {
                stationsList.add(station.text());
            }
            jsonCreate.setStations(lineNumber, stationsList);
        }
    }
}