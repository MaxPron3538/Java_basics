import net.sf.saxon.expr.Component;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HTMLParserSubway {

    private String outputPath;
    private Document document;
    private List<Object> stations;
    private List<Object> lines;
    private List<Object> transitions;
    private Map<String,String> mapSubwayLines;
    private Map<String,String> mapSubwayStations;
    private  Map<String,String> mapSubwayTransitions;

    HTMLParserSubway(String outputPath)throws IOException {
        document = Jsoup.connect("https://skillbox-java.github.io/").maxBodySize(0).get();
        this.outputPath = outputPath;
    }

    private HashMap<String,String> parseHTMLSubwayObjects(String tag) throws IOException{
        HashMap<String,String> mapSubway = new HashMap<>();
        Elements elements = document.select(tag);

        List<String>  firstArgs = elements.eachAttr("data-line");
        List<String> secondArgs = elements.stream().filter(element -> element.hasAttr("data-line"))
                    .map(element -> element.text()).collect(Collectors.toList());
        firstArgs.forEach(s -> mapSubway.put(s,secondArgs.get(firstArgs.indexOf(s))));

        return mapSubway;
    }

    private HashMap<String,String> parseHTMLSubwayTransition(String tag) throws IOException{
        HashMap<String,String> mapTransition = new HashMap<>();
        Elements elements = document.select(tag);

        List<String>  linesArgs = elements.stream().filter(element -> element.hasAttr("data-line"))
                .map(element -> element.select("span").eachAttr("class")
                        .stream().filter(s -> s.contains("ln")).map(s -> s.concat(";")).collect(Collectors.joining())).collect(Collectors.toList());

        List<String> stationsArgs = elements.stream().filter(element -> element.hasAttr("data-line"))
                .map(element -> element.select("span").eachAttr("title").stream().map(s -> s.concat(";"))
                        .collect(Collectors.joining())).collect(Collectors.toList());
        linesArgs.forEach(s -> mapTransition.put(s,stationsArgs.get(linesArgs.indexOf(s))));

        return mapTransition;
    }

    private JSONObject packInJsonLines() throws IOException{
        mapSubwayLines = parseHTMLSubwayObjects("span");
        JSONArray jsonArray = new JSONArray();

        for(Map.Entry<String,String> entry : mapSubwayLines.entrySet()){
            JSONObject jsonObjInfo = new JSONObject();
            jsonObjInfo.put("number", entry.getKey());
            jsonObjInfo.put("name", entry.getValue());
            jsonArray.add(jsonObjInfo);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lines",jsonArray);

        return jsonObject;
    }

    private JSONObject packInJsonStations() throws IOException{
        mapSubwayStations = parseHTMLSubwayObjects("div");
        JSONArray jsonArray = new JSONArray();

        for(Map.Entry<String,String> entry : mapSubwayStations.entrySet()){
            JSONObject jsonObjInfo = new JSONObject();
            List<String> listStations = Arrays.asList(entry.getValue().split("\\d{1,}\\.\\s"));
            listStations = listStations.stream().map(s -> s.trim()).collect(Collectors.toList());
            jsonObjInfo.put(entry.getKey(),listStations.subList(1,listStations.size()));
            jsonArray.add(jsonObjInfo);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stations",jsonArray);

        return jsonObject;
    }

    private JSONObject packInJsonTransitions() throws IOException{
        mapSubwayTransitions = parseHTMLSubwayTransition("div");
        JSONArray jsonArray = new JSONArray();

        for(Map.Entry<String,String> entry : mapSubwayTransitions.entrySet()){
            JSONArray jsonArray1 = new JSONArray();

            List<String> listLines = Arrays.asList(entry.getKey().split(";"))
                    .stream().map(s -> s.substring(s.lastIndexOf("-")+1,s.length())).collect(Collectors.toList());
            List<String> listTransition = Arrays.asList(entry.getValue().split(";"))
                    .stream().map(s -> s.substring(s.indexOf("«")+1,s.lastIndexOf("»"))).collect(Collectors.toList());

            for(int i = 0;i < listLines.size();i++){
                JSONObject jsonObjInfo = new JSONObject();
                jsonObjInfo.put("line",listLines.get(i));
                jsonObjInfo.put("station",listTransition.get(i));
                jsonArray1.add(jsonObjInfo);
            }
            jsonArray.add(jsonArray1);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("transitions",jsonArray);

        return jsonObject;
    }

    public void writeInJsonFile() throws IOException{
        File file = new File(outputPath);
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        JSONObject jsonObject = new JSONObject();

        jsonObject.putAll(packInJsonLines());
        jsonObject.putAll(packInJsonStations());
        jsonObject.putAll(packInJsonTransitions());
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    private List<Object> parseJsonStations(JSONArray jsonStations) throws ParseException{
        List<Object> listStations = new ArrayList<>();

        jsonStations.stream().forEach(jObject -> {
            JSONObject stationJsonObject = (JSONObject) jObject;
            Set<Object> jsonLines = stationJsonObject.keySet();
            for (Object line : jsonLines){
                JSONArray jsonArray = (JSONArray) stationJsonObject.get(line);
                listStations.addAll(jsonArray.subList(0,jsonArray.size()));
                printCountOfStations(line.toString(),String.valueOf(jsonArray.size()));
            }
        });
        return listStations;
    }

    private List<Object> parseJsonLines(JSONArray jsonLines) throws ParseException{
        List<Object> listLines = new ArrayList<>();

        jsonLines.stream().forEach(jObject -> {
            JSONObject lineObject = (JSONObject) jObject;
            listLines.add(lineObject.get("name"));
        });
        return listLines;
    }

    private List<Object> parseJsonTransitions(JSONArray jsonTransition) throws ParseException{
        List<Object> listTransition = new ArrayList<>();

        jsonTransition.stream().forEach(jArray -> {
             JSONArray jsonStations = (JSONArray) jArray;
             jsonStations.forEach(jObject -> {
                JSONObject jsonObject = (JSONObject) jObject;
                listTransition.add(jsonObject.get("station"));
            });
        });
        return listTransition;
    }

    public void readFromJsonFile() throws IOException{
        String subwayObjects = Files.readAllLines(Paths.get(outputPath)).stream().collect(Collectors.joining());
        JSONParser jsonParser = new JSONParser();

        try {
           JSONObject jsonData = (JSONObject) jsonParser.parse(subwayObjects);

           JSONArray jsonStations = (JSONArray) jsonData.get("stations");
           stations = parseJsonStations(jsonStations);

           JSONArray jsonLines = (JSONArray) jsonData.get("lines");
           lines = parseJsonLines(jsonLines);

           JSONArray jsonTransitions = (JSONArray) jsonData.get("transitions");
           transitions = parseJsonTransitions(jsonTransitions);
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
    }

    private void printCountOfStations(String line,String countStation){
        System.out.println("Количество станций на линии " + line + " = " + countStation);
    }

    public void printCountOfTransitions(){
        System.out.println("Кодичество переходов в московском метро - " + transitions.size());
    }

    public Map<String,String> getMapStations(){
        return mapSubwayStations;
    }
    public Map<String,String> getMapLines(){
        return mapSubwayLines;
    }
    public Map<String,String> getMapTransitions(){
        return mapSubwayTransitions;
    }

    public List<Object> getReadJsonStations(){
        return stations;
    }
    public List<Object> getReadJsonLines(){
        return lines;
    }
    public List<Object> getReadJsonTransitions(){
        return transitions;
    }

}
