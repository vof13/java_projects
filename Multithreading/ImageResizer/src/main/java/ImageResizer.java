import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread {
    private final File[] files;
    private final int newWidth;
    private final String dstFolder;
    private final Long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, Long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                BufferedImage newImagePixel = pixelResizer(image);
                File newPixelFile = new File(dstFolder + "/PIXEL" + file.getName());
                ImageIO.write(newImagePixel, "jpg", newPixelFile);

                BufferedImage newImageScalr = scalrResizer(image);
                File newScalrFile = new File(dstFolder + "/SCALR" + file.getName());
                ImageIO.write(newImageScalr, "jpg", newScalrFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }


    private BufferedImage scalrResizer(BufferedImage image) {
        return Scalr.resize(image, newWidth);
    }


    private BufferedImage pixelResizer(BufferedImage image) {
        int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        int widthStep = image.getWidth() / newWidth;
        int heightStep = image.getHeight() / newHeight;
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int rgb = image.getRGB(x * widthStep, y * heightStep);
                newImage.setRGB(x, y, rgb);
            }
        }
        return newImage;
    }
}



