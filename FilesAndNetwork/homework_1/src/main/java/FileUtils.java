import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {

    public static long calculateFolderSize(String path) {

        File file = new File(path);
        if(!file.exists()) throw new NullPointerException("Нет такого пути к файлу или директории!");

        File[] listFiles = file.listFiles();
        long space = 0;

        if (listFiles != null) {
            for (File internFile : listFiles) {
                space += calculateFolderSize(internFile.getAbsolutePath());
            }
            return space;
        }
        return file.length();
    }
}