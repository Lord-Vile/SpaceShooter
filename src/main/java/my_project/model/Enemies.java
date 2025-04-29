package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Enemies extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    private int level = 1;
    public double hp = 100; // HP der Gegner
    public double x = 700;
    public double y = 700;

    private double laserCooldown = 1;
    private double shots = 0;
    private final double startLaserCooldown = 1;

    public double lx = x;
    public double ly = y;

    public boolean shoot = false;

    public Enemies(int y) {
        this.setNewImage("src/main/resources/graphic/gegner.png");
        hoverUp = true;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (level == 1 && hp > 0) {
            drawTool.drawImage(getMyImage(), this.x, this.y + hoverY);
        }

        // Wenn der Gegner schießt
        drawTool.setCurrentColor(Color.RED);
        if (shoot && hp > 0) {
            drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);
        }
    }

    @Override
    public void update(double dt) {
        if (hp <= 0) {
            this.x = 1000; // Entfernen aus dem Sichtbereich
            shoot = false;
            shots = 0;
        }

        // Hover-Effekt
        if (hoverUp) {
            hoverY -= 8 * dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY += 8 * dt;
            if (hoverY > 5) hoverUp = true;
        }

        // Laser-Logik
        laserCooldown -= dt;

        if (laserCooldown <= 0 && shots == 0) {
            shoot = true;
            shots = 0;
            laserCooldown = startLaserCooldown;
        }

        if (shoot) {
            lx -= 500 * dt;  // Laser bewegt sich nach links
        }

        if (lx < 0) {
            lx = this.x;
            ly = this.y;
            shoot = false;
        }

        if (!shoot) {
            lx = this.x;
            ly = this.y;
        }
    }

    // Methode zum Schadennehmen
    public void takeDamage(double amount) {
        this.hp -= amount;
        if (this.hp <= 0) {
            this.hp = 0;
            this.x = 1000;
            shoot = false;
            shots = 0;
        }
    }

    // Methode zur Kollisionserkennung
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, getMyImage().getWidth(), getMyImage().getHeight());
    }
}
