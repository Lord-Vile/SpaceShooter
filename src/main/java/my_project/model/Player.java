package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    public int direction = 0;
    public static double x = 50;
    public static double y = 800;
    private double speed = 300;
    public int health = 100;  // Start-Gesundheit des Spielers
    private double invulnerableTime = 0;  // Unverwundbarkeitszeit nach Treffer

    private int  goLeft;
    private int  goRight;
    private int  goUp;
    private int  goDown;

    public Player(){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        hoverUp = true;
        this.goLeft = KeyEvent.VK_A;
        this.goRight = KeyEvent.VK_D;
        this.goUp = KeyEvent.VK_W;
        this.goDown = KeyEvent.VK_S;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(), x, y + hoverY);
    }

    @Override
    public void update(double dt){
        // Bewegung auf der Stelle
        if (direction == 0){
            if (hoverUp){
                hoverY = hoverY - 30*dt;
                if (hoverY < -10) hoverUp = false;
            } else {
                hoverY = hoverY + 30*dt;
                if (hoverY > 10) hoverUp = true;
            }
        }
        moonMoving(dt);

        // Unverwundbarkeit abklingen lassen
        if (invulnerableTime > 0) {
            invulnerableTime -= dt;
        }
    }

    public void moonMoving(double dt){
        if (ViewController.isKeyDown(goLeft)){
            this.x -= speed*dt;
        }
        if (ViewController.isKeyDown(goRight)){
            this.x += speed*dt;
        }
        if (ViewController.isKeyDown(goUp)){
            this.y -= speed*dt;
        }
        if (ViewController.isKeyDown(goDown)){
            this.y += speed*dt;
        }
    }

    // Methode, um Schaden zu erleiden
    public void takeDamage(int amount) {
        if (invulnerableTime <= 0) {
            invulnerableTime = 1.5;
            this.health -= amount;
            if (this.health <= 0) {
                this.health = 0;
            }
        }
    }
}