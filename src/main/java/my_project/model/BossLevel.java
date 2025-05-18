package my_project.model;

import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BossLevel extends Enemies {

    protected double hoverY;
    protected boolean hoverUp;
    protected int level = 1;
    public double hp = 1000; // HP der Gegner
    private double x = 1000;
    private double y = 50;
    private double gehtBis = 600;
    public boolean tot = false;
    public boolean wurdeGezaehlt = false;

    protected double laserCooldown = 1;
    protected double shots = 0;
    protected final double startLaserCooldown = 1;
  // Zeit bis zum nächsten Respawn
 // Sekunden


    public double lx = x;
    public double ly = y;
    public double lx1 = x;
    public double ly1 = y;
    public double lx2 = x;
    public double ly2 = y;
    public double lx3 = x;
    public double ly3 = y;
    public double lx4 = x;
    public double ly4 = y;
    public double lx5 = x;
    public double ly5 = y;
    public double lx6 = x;
    public double ly6 = y;

    public boolean shoot = false;
    public boolean shoot1 = false;
    public boolean shoot2 = false;
    public boolean shoot3 = false;
    public boolean shoot4 = false;
    public boolean shoot5 = false;
    public boolean shoot6 = false;

    public static int score = 0;

    public static int time = 0;



    public BossLevel(int y) {


        this.setNewImage("src/main/resources/graphic/Boss.png");
        hoverUp = true;
        this.y = y;
    }

/*    public void rotate() {
        try {
            // Load the image
            BufferedImage originalImage = ImageIO.read(new File("src/main/resources/graphic/Boss.png"));

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
*/
@Override
public void draw(DrawTool drawTool) {
    if (time == 5 && hp > 0) {
        drawTool.drawImage(getMyImage(), this.x, this.y);
    }

    // Wenn der Boss schießt
    drawTool.setCurrentColor(new Color(123, 234, 217));
    if (shoot && hp > 0) {
        drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY, 20, 3);
    }
    if (shoot1 && hp > 0) {
        drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY, 20, 3);
    }
    if (shoot2 && hp > 0) {
        drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY*3, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY*3, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY*3, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY*3, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY*3, 20, 3);
    }
    if (shoot3 && hp > 0) {
        drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY*2, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY*2, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY*2, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY*2, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY*2, 20, 3);
    }
    if (shoot4 && hp > 0) {
        drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY*5, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY*5, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY*5, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY*5, 20, 3);
        drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY*5, 20, 3);
    }
    if (shoot5 && hp > 0) {
        int timer = 3;
        if (timer > 0) {

            drawTool.drawFilledRectangle(lx + 10, ly + 10 + hoverY, 30 + lx5*2, 3);
            drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY, 30 + lx5*2, 3);
            drawTool.drawFilledRectangle(lx + 10, ly + 100 + hoverY, 30 + lx5*2, 3);
            drawTool.drawFilledRectangle(lx + 10, ly + 153 + hoverY, 30 + lx5*2, 3);
            drawTool.drawFilledRectangle(lx + 10, ly + 210 + hoverY, 30 + lx5*2, 3);
        }
    }
    if (shoot6 && hp > 0) {
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 13 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 33 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 53 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 73 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 100 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 120 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 153 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 173 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 210 + hoverY*2, 15, 2);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 230 + hoverY*2, 15, 2);
    }
}

    @Override
    public void update(double dt) {

    time = (int) (time + dt);
        if (tot) {
            System.out.println("DU HAST DEN BOSS BESIEGT");
        }






        if (this.x > gehtBis){
            this.x = this.x - 150*dt;
        }

        laserCooldown -= dt;

        if (laserCooldown <= 0 && shots == 0){
            shoot = true;
            shots = 1;
            laserCooldown = startLaserCooldown;
        } else if (laserCooldown <= 0 && shots == 1){
            shoot1 = true;
            shots = 2;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 2){
            shoot2 = true;
            shots = 3;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 3){
            shoot3 = true;
            shots = 4;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 4){
            shoot4 = true;
            shots = 5;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 5){
            shoot5 = true;
            shots = 6;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 6){
            shoot6 = true;
            shots = 0;
            laserCooldown = startLaserCooldown;
        }

        if (shoot){
            lx -= 500*dt;
        }
        if (shoot1){
            lx1 -= 500*dt;
        }
        if (shoot2){
            lx2 -= 500*dt;
        }
        if (shoot3){
            lx3 -= 500*dt;
        }
        if (shoot4){
            lx4 -= 500*dt;
        }
        if (shoot5){
            lx5 -= 500*dt;
        }
        if (shoot6){
            lx6 -= 500*dt;
        }

        if (lx < 0){
            lx = this.x;
            ly = this.y;
            shoot = false;
        }
        if (lx1 < 0){
            lx1 = this.x;
            ly1 = this.y;
            shoot1 = false;
        }
        if (lx2 < 0){
            lx2 = this.x;
            ly2 = this.y;
            shoot2 = false;
        }
        if (lx3 < 0){
            lx3 = this.x;
            ly3 = this.y;
            shoot3 = false;
        }
        if (lx4 < 0){
            lx4 = this.x;
            ly4 = this.y;
            shoot4 = false;
        }
        if (lx5 < 0){
            lx5 = this.x;
            ly5 = this.y;
            shoot5 = false;
        }
        if (lx6 < 0){
            lx6 = this.x;
            ly6 = this.y;
            shoot6 = false;
        }

        if (shoot == false){
            lx = this.x;
            ly = this.y;
        }
        if (shoot1 == false){
            lx1 = this.x;
            ly1 = this.y;
        }
        if (shoot2 == false){
            lx2 = this.x;
            ly2 = this.y;
        }
        if (shoot3 == false){
            lx3 = this.x;
            ly3 = this.y;
        }
        if (shoot4 == false){
            lx4 = this.x;
            ly4 = this.y;
        }
        if (shoot5 == false){
            lx5 = this.x;
            ly5 = this.y;
        }
        if (shoot6 == false){
            lx6 = this.x;
            ly6 = this.y;
        }
    }

    // Methode zum Schadennehmen
    public void takeDamage(double amount) {
        this.hp -= amount;
        if (this.hp <= 0 && !tot) {
            tot = true;
            System.out.println("Enemy HP: " + hp);
            score += 10;
        }
    }

    public boolean collidesWith(Player p) {
        // Hier wird eine einfache Rechteck-Kollision geprüft
        return (this.lx + this.width > p.x/2 && this.lx < p.x/2 + p.getWidth()) &&
                (this.ly + this.height > p.y && this.ly < p.y + 10) ||

                (this.lx1 + this.width > p.x/2 && this.lx1 < p.x - 30 + p.getWidth()) &&
                        (this.ly1 + this.height > p.y && this.ly1 < p.y + 10) ||

                (this.lx2 + this.width > p.x/2 && this.lx2 < p.x/2 + p.getWidth()) &&
                        (this.ly2 + this.height > p.y && this.ly2 < p.y + 10) ||

                (this.lx3 + this.width > p.x/2 && this.lx3 < p.x/2 + p.getWidth()) &&
                        (this.ly3 + this.height > p.y && this.ly3 < p.y + 10) ||

                (this.lx4 + this.width > p.x/2 && this.lx4 < p.x/2 + p.getWidth()) &&
                        (this.ly4 + this.height > p.y && this.ly4 < p.y + 10) ||

                (this.lx5 + this.width > p.x/2 && this.lx5 < p.x/2 + p.getWidth()) &&
                        (this.ly5 + this.height > p.y && this.ly5 < p.y + 10) ||

                (this.lx6 + this.width > p.x/2 && this.lx6 < p.x/2 + p.getWidth()) &&
                        (this.ly6 + this.height > p.y && this.ly6 < p.y + 10);

    }


}

