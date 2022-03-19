import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        try {
            String outPath = "C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_5\\src\\main\\subway.json";
            HTMLParserSubway htmlParserSubway = new HTMLParserSubway(outPath);
            htmlParserSubway.writeInJsonFile();
            System.out.println("---------------------------------------------");
            htmlParserSubway.readFromJsonFile();
            System.out.println("---------------------------------------------");
            htmlParserSubway.printCountOfTransitions();
            System.out.println("---------------------------------------------");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
