package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemies extends InteractiveGraphicalObject {
    private double hoverY;
    private boolean hoverUp;
    private int scene = 1;
    public static double hp = 100;
    public static double x = 700;
    public static double y = 350;

    public Enemies(){
        this.setNewImage("src/main/resources/graphic/gegner.png");
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (scene == 1) {
            if (hp > 0) {
                drawTool.drawImage(getMyImage(), this.x, y + hoverY);
            }
        }
    }

    @Override
    public void update(double dt){
        if (hoverUp){
            hoverY = hoverY - 8*dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8*dt;
            if (hoverY > 5) hoverUp = true;
        }
    }
}