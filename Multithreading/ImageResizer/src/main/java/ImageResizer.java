import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class ImageResizer extends Thread{

    private File[] files;
    private String dstFolder;
    private int newWidth;
    private long start;

    public ImageResizer(File[] files,int newWidth,String dstFolder){
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = System.currentTimeMillis();;
        start();
    }

    @Override
    public void run(){
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);

                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = Scalr.resize(image, Scalr.Method.QUALITY,newWidth,newHeight,Scalr.OP_ANTIALIAS);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
