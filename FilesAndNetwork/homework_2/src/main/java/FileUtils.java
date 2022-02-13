import net.sf.saxon.trans.SymbolicName;

import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException{
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        File sourceFile = new File(sourceDirectory);
        File[] listFiles = sourceFile.listFiles();

        if (listFiles != null) {

            for (File file : listFiles) {
                String copyDirPath = destinationDirectory.concat(file.getPath().substring(file.getPath().lastIndexOf("\\")));

                if (file.isDirectory()) {
                    Files.createDirectory(Paths.get(copyDirPath));
                    copyFolder(file.getAbsolutePath(), copyDirPath);
                }
                if (file.isFile()) {
                    Files.copy(file.toPath(), Paths.get(copyDirPath), REPLACE_EXISTING);
                }
            }
        }
    }
}
