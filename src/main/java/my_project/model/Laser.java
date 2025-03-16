package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Laser extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    public double x = 50;
    public double y = 350;
    private int direction;

    double playerCooldown = 1;
    double shots = 0;
    double startPlayerCooldown = 1;

    double lx = x;
    double ly = y;
    double lx1 = x;
    double ly1 = y;
    double lx2 = x;
    double ly2 = y;
    double lx3 = x;
    double ly3 = y;
    double lx4 = x;
    double ly4 = y;
    double lx5 = x;
    double ly5 = y;
    double lx6 = x;
    double ly6 = y;
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
        drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);
        drawTool.drawFilledRectangle(lx1 + 10, ly1 + 25, 20, 10);
        drawTool.drawFilledRectangle(lx2 + 10, ly2 + 25, 20, 10);
        drawTool.drawFilledRectangle(lx3 + 10, ly3 + 25, 20, 10);
        drawTool.drawFilledRectangle(lx4 + 10, ly4 + 25, 20, 10);
        drawTool.drawFilledRectangle(lx5 + 10, ly5 + 25, 20, 10);
        drawTool.drawFilledRectangle(lx6 + 10, ly6 + 25, 20, 10);
    }

    @Override
    public void update(double dt){

        playerCooldown -= dt;

        if (playerCooldown <= 0 && shots == 0){
            shoot = true;
            shots = 1;
            playerCooldown = startPlayerCooldown;
        } else if (playerCooldown <= 0 && shots == 1){
            shoot1 = true;
            shots = 2;
            playerCooldown = startPlayerCooldown;
        }else if (playerCooldown <= 0 && shots == 2){
            shoot2 = true;
            shots = 3;
            playerCooldown = startPlayerCooldown;
        }else if (playerCooldown <= 0 && shots == 3){
            shoot3 = true;
            shots = 4;
            playerCooldown = startPlayerCooldown;
        }else if (playerCooldown <= 0 && shots == 4){
            shoot4 = true;
            shots = 5;
            playerCooldown = startPlayerCooldown;
        }else if (playerCooldown <= 0 && shots == 5){
            shoot5 = true;
            shots = 6;
            playerCooldown = startPlayerCooldown;
        }else if (playerCooldown <= 0 && shots == 6){
            shoot6 = true;
            shots = 0;
            playerCooldown = startPlayerCooldown;
        }

        if (shoot){
            lx += 500*dt;
        }
        if (shoot1){
            lx1 += 500*dt;
        }
        if (shoot2){
            lx2 += 500*dt;
        }
        if (shoot3){
            lx3 += 500*dt;
        }
        if (shoot4){
            lx4 += 500*dt;
        }
        if (shoot5){
            lx5 += 500*dt;
        }
        if (shoot6){
            lx6 += 500*dt;
        }

        if (lx > Config.WINDOW_WIDTH){
            lx = x;
            shoot = false;
        }
        if (lx1 > Config.WINDOW_WIDTH){
            lx1 = x;
            shoot1 = false;
        }
        if (lx2 > Config.WINDOW_WIDTH){
            lx2 = x;
            shoot2 = false;
        }
        if (lx3 > Config.WINDOW_WIDTH){
            lx3 = x;
            shoot3 = false;
        }
        if (lx4 > Config.WINDOW_WIDTH){
            lx4 = x;
            shoot4 = false;
        }
        if (lx5 > Config.WINDOW_WIDTH){
            lx5 = x;
            shoot5 = false;
        }
        if (lx6 > Config.WINDOW_WIDTH){
            lx6 = x;
            shoot6 = false;
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