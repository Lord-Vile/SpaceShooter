package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    public int direction = 0;
    public static double x = 50;
    public static double y = 350;
    private double speed = 300;

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
        drawTool.drawImage(getMyImage(),x,y+hoverY);
    }

    @Override
    public void update(double dt){
        // Bewegung auf der Stelle
        if (direction == 0){
            if (hoverUp){
                    hoverY = hoverY - 8*dt;
                if (hoverY < -5) hoverUp = false;
                } else {
                    hoverY = hoverY + 8*dt;
                if (hoverY > 5) hoverUp = true;
            }
        }
        moonMoving(dt);
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
}