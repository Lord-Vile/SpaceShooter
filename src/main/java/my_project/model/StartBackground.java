package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

/**
 * Dient zum Zeichnen von nicht beweglichen Objekten im Hintergrund
 */
public class StartBackground extends GraphicalObject {

    private double x = 70;
    private double y = 30;
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.black);
        drawTool.drawFilledRectangle(0,0,800,800);
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawFilledCircle(x,y,2);
        drawTool.drawFilledCircle(x+100,y+30,2);
        drawTool.drawFilledCircle(x-50,y+200,2);
        drawTool.drawFilledCircle(x+330,y+100,2);
        drawTool.drawFilledCircle(x+160,y+500,2);
        drawTool.drawFilledCircle(x+630,y+600,2);
        drawTool.drawFilledCircle(x+630,y+200,2);
        drawTool.drawFilledCircle(x+30,y+60,2);
        drawTool.drawFilledCircle(x-40,y+430,2);
        drawTool.drawFilledCircle(x+230,y+110,2);
        drawTool.drawFilledCircle(x+550,y+530,2);
        drawTool.drawFilledCircle(x+680,y+290,2);
        drawTool.drawFilledCircle(x+590,y+440,2);
    }

    public void update(double dt) {
        x -= 150*dt;
        if (x < -10){
            x = 900;
            y = Math.random()*800;
        }
    }
}
