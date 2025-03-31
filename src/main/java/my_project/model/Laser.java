package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Laser extends GraphicalObject {

    double playerCooldown = 1;
    double shots = 0;
    double startPlayerCooldown = 1;

    private double x = 50;
    private double y = 350;
    private int width = 20;
    private int height = 10;

    private boolean shoot = false;

    public Laser(){

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledRectangle(this.x + 10, this.y + 25, this.width, this.height);
    }

    @Override
    public void update(double dt) {
        playerCooldown -= dt;

        if (playerCooldown <= 0 && shots == 0) {
            shoot = true;
            shots = 0;
            playerCooldown = startPlayerCooldown;
        }

        if (shoot) {
            this.x += 500 * dt;
        }

        if (this.x > Config.WINDOW_WIDTH) {
            this.x = Player.x;
            this.y = Player.y;
            shoot = false;
        }

        if (shoot == false){
            this.x = Player.x;
            this.y = Player.y;
        }
    }
}