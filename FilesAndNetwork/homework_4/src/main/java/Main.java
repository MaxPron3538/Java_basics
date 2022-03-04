import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<String> listNames = HTMLParser.ParseReferenceHtml("https://lenta.ru");
        listNames.forEach(System.out::println);
    }
}
