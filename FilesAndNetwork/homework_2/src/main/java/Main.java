import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) throws IOException{

        System.out.println("Input path for source folder:");
        Scanner scannerSource = new Scanner(System.in);
        String sourceDir = scannerSource.nextLine();

        System.out.println("Input path for destination folder:");
        Scanner scannerDestination = new Scanner(System.in);
        String destinationDir = scannerDestination.nextLine();

        FileUtils.copyFolder(sourceDir,destinationDir);
    }
}
