import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHTMLParserSubway {

    HashMap<String,String> mapStations = new HashMap<>();
    HashMap<String,String> mapLines = new HashMap<>();
    HashMap<String,String> mapTransitions = new HashMap<>();
    HTMLParserSubway htmlParserSubway;
    @BeforeEach
    public void setUp() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\ListLines"));
        List<String> stations = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\ListStations"));
        List<String> transitions = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\ListTransitions"));

        for(String str : lines){
            List<String> subLines = Arrays.asList(str.split("   "));
            mapLines.put(subLines.get(0),subLines.get(1));
        }

        for(String str : stations){
            List<String> subStations = Arrays.asList(str.split("   "));
            mapStations.put(subStations.get(0),subStations.get(1));
        }

        for(String str : transitions){
            List<String> subTransitions = Arrays.asList(str.split("   "));
            mapTransitions.put(subTransitions.get(0),subTransitions.get(1));
        }
        htmlParserSubway = new HTMLParserSubway("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\main\\subway.json");
    }

    @Test
    @DisplayName("Получение списка номеров линий и названий линий Московского метрополитена")
    void testParseHTMLLines() throws IOException{
        htmlParserSubway.writeInJsonFile();
        assertEquals(mapLines,htmlParserSubway.getMapLines());
    }

    @Test
    @DisplayName("Получение списка номеров линий и станций, которые находятся на определенной линии")
    void testParseHTMLStations() throws IOException{
        htmlParserSubway.writeInJsonFile();
        assertEquals(mapStations,htmlParserSubway.getMapStations());
    }

    @Test
    @DisplayName("Получение списка линий и переходов на другие станции на определенной линии")
    void testParseHTMLTransitions() throws IOException{
        htmlParserSubway.writeInJsonFile();
        assertEquals(mapTransitions,htmlParserSubway.getMapTransitions());
    }

    @Test
    @DisplayName("Получение списка переходов из Json файла")
    void testReadJsonLines() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\linesFromJson"));
        htmlParserSubway.readFromJsonFile();
        assertEquals(lines,htmlParserSubway.getReadJsonLines());
    }

    @Test
    @DisplayName("Получение списка станций из Json файла")
    void testReadJsonStations() throws IOException{
        List<String> stations = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\stationsFromJson"));
        htmlParserSubway.readFromJsonFile();
        assertEquals(stations,htmlParserSubway.getReadJsonStations());
    }

    @Test
    @DisplayName("Получение списка переходов из Json файла")
    void testReadJsonTransitions() throws IOException{
        List<String> transition = Files.readAllLines(Paths.get("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\test\\resources\\transitionsFromJson"));
        htmlParserSubway.readFromJsonFile();
        assertEquals(transition,htmlParserSubway.getReadJsonTransitions());
    }







}

