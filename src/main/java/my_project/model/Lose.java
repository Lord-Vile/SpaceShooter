package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Lose extends GraphicalObject {

    public Lose() {

    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawText(70, 120, "YOU DIED");//Level 1 Button
    }
}