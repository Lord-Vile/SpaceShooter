package my_project.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BossLevel extends Enemies {


    public BossLevel(int y) {
        super(y /* lx, ly, lx1, ly1, lx2, ly2, lx3, ly3, lx4, ly4, lx5, ly5, lx6, ly6*/);

        this.setNewImage("src/main/resources/graphic/Boss.gif");
        hoverUp = true;
        this.y = y + 50;
    }

    public void rotate() {
        try {
            // Load the image
            BufferedImage originalImage = ImageIO.read(new File("src/main/resources/graphic/Boss.gif"));

            // Create a new image with swapped dimensions
            BufferedImage rotatedImage = new BufferedImage(originalImage.getHeight(), originalImage.getWidth(), originalImage.getType());

            // Create a graphics context
            Graphics2D g2d = rotatedImage.createGraphics();

            // Rotate the image
            AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(90), originalImage.getWidth() / 2, originalImage.getHeight() / 2);
            g2d.drawImage(originalImage, transform, null);
            g2d.dispose();

            // Save the rotated image
            ImageIO.write(rotatedImage, "jpg", new File("path/to/your/rotated_image.jpg"));

            System.out.println("Image rotated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
