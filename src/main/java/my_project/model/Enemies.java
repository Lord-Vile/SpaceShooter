package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemies extends InteractiveGraphicalObject {
    private double hoverY;
    private boolean hoverUp;
    private int level = 1;
    public static double hp = 100;
    public static double x = 700;
    public static double y = 0;

    public Enemies(int y){
        this.setNewImage("src/main/resources/graphic/gegner.png");
        hoverUp = true;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (level == 1) {
            if (hp > 0) {
                drawTool.drawImage(getMyImage(), this.x, y + hoverY);
            }
        }
    }

    @Override
    public void update(double dt) {
        if (hoverUp) {
            hoverY = hoverY - 8 * dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8 * dt;
            if (hoverY > 5) hoverUp = true;
        }
        if (hp <= 0){
            this.x = 1000;
        }
    }
}