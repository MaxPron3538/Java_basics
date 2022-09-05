import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOfSite extends RecursiveTask<String>{

    private String pathToUrl;
    private String indent;

    MapOfSite(String pathToUrl,String indent){
        this.pathToUrl = pathToUrl;
        this.indent = indent.concat("   ");
    }

    @Override
    public String compute() {
        try {
            Thread.sleep(100);
            try {
                 List<MapOfSite> taskList = new ArrayList<>();
                 List<String> listURI = Arrays.stream(pathToUrl.split("//")).toList();
                 String basePath = listURI.get(0)+"//"+listURI.get(1)
                    .replaceFirst(listURI.get(1).substring(listURI.get(1).indexOf("/")),"");

                 Document doc = Jsoup.connect(pathToUrl).get();
                 Elements elements = doc.select("a");

                 List<String> listRef = elements.eachAttr("href").stream().map(s -> {
                 if(!s.contains(listURI.get(0)))
                    return basePath + s;
                 return s; }).collect(Collectors.toList());

                 listRef = listRef.stream().filter(s -> s.charAt(0) != '#').filter(s -> s.contains(pathToUrl))
                    .filter(s -> !pathToUrl.equals(s)).filter(s -> !s.contains("extlink")).collect(Collectors.toList());

                 for(String url : listRef){
                    MapOfSite task = new MapOfSite(url,indent);
                    taskList.add(task);
                    task.fork();
                 }
                 for (MapOfSite task : taskList){
                    pathToUrl = pathToUrl.concat("\n" + indent + task.join());
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return pathToUrl;
    }
}
