import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static int countProcess = Runtime.getRuntime().availableProcessors();
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:/Users/maxpr/Documents/src";
        String dstFolder = "C:/Users/maxpr/Documents/dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int base = 0;

        if(files.length < countProcess) {
            countProcess = files.length;
        }
        File[] evenFiles = Arrays.copyOfRange(files,0,(files.length/countProcess) * countProcess);
        File[] oddFiles = Arrays.copyOfRange(files,evenFiles.length,files.length);
        int subEvenLength = evenFiles.length/countProcess;
        int stepLength = subEvenLength;

        for(int i = 0;i < countProcess;i++){

            File[] subFiles = Arrays.copyOfRange(evenFiles,base,stepLength);
            new ImageResizer(subFiles,newWidth,dstFolder);

            if(i < oddFiles.length){
                new ImageResizer(Arrays.copyOfRange(oddFiles,i,i+1),newWidth,dstFolder);
            }
            base+=subEvenLength;
            stepLength+=subEvenLength;
        }
    }
}
