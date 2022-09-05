import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String pathToFile = "C://Users//maxpr//java_basics//Multithreading//RecursiveTask//src//main//RecursiveListURL.txt";

    public static void main(String[] args) {

        String path = new ForkJoinPool().invoke(new MapOfSite("https://lenta.ru/",""));

        try {
            File fileRecursiveListURL = new File(pathToFile);
            FileWriter writer = new FileWriter(fileRecursiveListURL);

            if(fileRecursiveListURL.createNewFile()){
                System.out.println("File created: " + fileRecursiveListURL.getName());
            }
            writer.write(path);
        }catch (IOException ex){
           ex.printStackTrace();
        }
    }
}
