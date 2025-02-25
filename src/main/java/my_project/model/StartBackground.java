package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

import static my_project.Config.WINDOW_HEIGHT;
import static my_project.Config.WINDOW_WIDTH;

/**
 * Dient zum Zeichnen von nicht beweglichen Objekten im Hintergrund
 */
public class StartBackground extends GraphicalObject {

    private double x = Math.random()*WINDOW_WIDTH;
    private double y = Math.random()*800;
    private double radius = Math.random()*4;

    private double x1 = Math.random()*WINDOW_WIDTH;
    private double y1 = Math.random()*800;
    private double radius1 = Math.random()*4;

    private double x2 = Math.random()*WINDOW_WIDTH;
    private double y2 = Math.random()*800;
    private double radius2 = Math.random()*4;

    private double x3 = Math.random()*WINDOW_WIDTH;
    private double y3 = Math.random()*800;
    private double radius3 = Math.random()*4;

    private double x4 = Math.random()*WINDOW_WIDTH;
    private double y4 = Math.random()*800;
    private double radius4 = Math.random()*4;

    private double x5 = Math.random()*WINDOW_WIDTH;
    private double y5 = Math.random()*800;
    private double radius5 = Math.random()*4;

    private double x6 = Math.random()*WINDOW_WIDTH;
    private double y6 = Math.random()*800;
    private double radius6 = Math.random()*4;

    private double x7 = Math.random()*WINDOW_WIDTH;
    private double y7 = Math.random()*800;
    private double radius7 = Math.random()*4;

    private double x8 = Math.random()*WINDOW_WIDTH;
    private double y8 = Math.random()*800;
    private double radius8 = Math.random()*4;

    private double x9 = Math.random()*WINDOW_WIDTH;
    private double y9 = Math.random()*800;
    private double radius9 = Math.random()*4;

    private double x10 = Math.random()*WINDOW_WIDTH;
    private double y10 = Math.random()*800;
    private double radius10 = Math.random()*4;

    private double x11 = Math.random()*WINDOW_WIDTH;
    private double y11 = Math.random()*800;
    private double radius11 = Math.random()*4;

    private double x12 = Math.random()*WINDOW_WIDTH;
    private double y12 = Math.random()*800;
    private double radius12 = Math.random()*4;

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.black);
        drawTool.drawFilledRectangle(0,0,800,800);
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.drawFilledCircle(x1,y1,radius1);
        drawTool.drawFilledCircle(x2,y2,radius2);
        drawTool.drawFilledCircle(x3,y3,radius3);
        drawTool.drawFilledCircle(x4,y4,radius4);
        drawTool.drawFilledCircle(x5,y5,radius5);
        drawTool.drawFilledCircle(x6,y6,radius6);
        drawTool.drawFilledCircle(x7,y7,radius7);
        drawTool.drawFilledCircle(x8,y8,radius8);
        drawTool.drawFilledCircle(x9,y9,radius9);
        drawTool.drawFilledCircle(x10,y10,radius10);
        drawTool.drawFilledCircle(x11,y11,radius11);
        drawTool.drawFilledCircle(x12,y12,radius12);
    }

    @Override
    public void update(double dt) {
        x2 -= 150*dt;
        x3 -= 150*dt;
        x4 -= 150*dt;
        x5 -= 150*dt;
        x6 -= 150*dt;
        x7 -= 150*dt;
        x8 -= 150*dt;
        x9 -= 150*dt;
        x10 -= 150*dt;
        x11 -= 150*dt;
        x12 -= 150*dt;

        if (x < 100){
            x = 900;
            y = Math.random()*800;
        }else{
            x = x - (150 * dt);
        }

        if (x1 < -10){
            x = 900;
            y = Math.random()*800;
        }else{
            x1 = x1 - (150 * dt);
        }

        if (x2 < -10){
            x = 900;
            y = Math.random()*800;
        }

        if (x3 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x4 < -10){
            x = 900;
            y = Math.random()*800;
        }

        if (x5 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x6 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x7 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x8 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x9 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x10 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x11 < -10){
            x = 900;
            y = Math.random()*800;
        }
        if (x12 < -10){
            x = 900;
            y = Math.random()*800;
        }
    }
}
