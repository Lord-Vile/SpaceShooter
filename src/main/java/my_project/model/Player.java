package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    int direction = 0;
    public double x = 50;
    public double y = 300;

    double playerCooldown = 3;
    double startPlayerCooldown = 3;
    double lx = x;
    double ly = y;
    boolean shoot = false;


    public Player(){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);

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

        if (direction == 1){
            this.y += 100*dt;
        }
        if (direction == 2) {
            this.x += 100*dt;
        }
        if (direction == 3) {
            this.y -= 100*dt;
        }
        if (direction == 4) {
            this.x -= 100*dt;
        }

        playerCooldown -= dt;

        if (playerCooldown <= 0){
            playerCooldown = startPlayerCooldown;
            shoot = true;
        }

        if (shoot == true){
            lx += 500*dt;
        }
    }

    @Override
    public void keyPressed(int keyCode){
        if (keyCode == KeyEvent.VK_W){
            direction = 3;
        }
        if (keyCode == KeyEvent.VK_S){
            direction = 1;
        }
        if (keyCode == KeyEvent.VK_A){
            direction = 4;
        }
        if (keyCode == KeyEvent.VK_D) {
            direction = 2;
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void keyReleased(int keyCode){
        if (keyCode == KeyEvent.VK_W){
            direction = 0;
        }
        if (keyCode == KeyEvent.VK_S){
            direction = 0;
        }
        if (keyCode == KeyEvent.VK_A){
            direction = 0;
        }
        if (keyCode == KeyEvent.VK_D){
            direction = 0;
        }
    }

}