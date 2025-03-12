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

    public Enemies(){
        this.setNewImage("src/main/resources/graphic/gegner.png");
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (scene == 1) {
            drawTool.drawImage(getMyImage(), 700, 240 + hoverY);
            drawTool.drawImage(getMyImage(), 700, 350 + hoverY);
            drawTool.drawImage(getMyImage(), 700, 460 + hoverY);
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