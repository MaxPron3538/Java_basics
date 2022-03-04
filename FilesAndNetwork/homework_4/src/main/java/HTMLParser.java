import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HTMLParser {

    public static List<String> ParseReferenceHtml(String pathURL) throws IOException {

        File file = new File("C:\\Users\\maxpr\\java_basics\\FilesAndNetwork\\homework_4\\src\\main\\images");
        List<String> imgNames = new ArrayList<>();

        if(!file.exists()) {
            Files.createDirectory(Paths.get(file.getAbsolutePath()));
        }
        Document doc = Jsoup.connect(pathURL).get();
        Elements elements = doc.select("img");
        List<String> listRef = elements.eachAttr("src").stream().filter(s -> s.contains("jpg")).collect(Collectors.toList());

        for (String source : listRef) {
            BufferedImage image = ImageIO.read(new URL(source));
            String name = Arrays.stream(source.split("/")).filter(s -> s.contains("jpg")).collect(Collectors.joining());
            ImageIO.write(image, "jpg",new File(file.getAbsolutePath()+"\\"+name));
            imgNames.add(name);
        }
        return imgNames;
    }
}
