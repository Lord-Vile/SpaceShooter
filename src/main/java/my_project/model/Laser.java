package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Laser extends GraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    public double x = 50;
    public double y = 350;
    private int direction;

    double playerCooldown = 1;
    double shots = 0;
    double startPlayerCooldown = 1;

    static double lx = 50;
    public double ly = 350;

    private boolean shoot = false;
    private boolean shoot1 = false;
    private boolean shoot2 = false;
    private boolean shoot3 = false;
    private boolean shoot4 = false;
    private boolean shoot5 = false;
    private boolean shoot6 = false;




    public Laser(){
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (shoot) {
            drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);
        }
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
            lx += 500 * dt;
        }


        if (lx > Config.WINDOW_WIDTH) {
            lx = Player.x;
            ly = Player.y;
            shoot = false;
        }
    }
}