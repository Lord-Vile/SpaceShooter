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

    public Player(double x, double y){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;
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

        if (direction == 1){
            this.y += 100;
        }
        if (direction == 2) {
            this.x += 100;
        }
        if (direction == 3) {
            this.y -= 100;
        }
        if (direction == 4) {
            this.x -= 100;
        }
    }

    @Override
    public void keyPressed(int keyCode){
        if (keyCode == KeyEvent.VK_W){
            direction = 1;
            System.out.println(1);
        }
        if (keyCode == KeyEvent.VK_S){
            direction = 3;
        }
        if (keyCode == KeyEvent.VK_A){
            direction = 2;
        }
        if (keyCode == KeyEvent.VK_D) {
            direction = 4;
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

}
