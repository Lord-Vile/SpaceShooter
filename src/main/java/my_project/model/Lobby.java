package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Lobby extends GraphicalObject {

    public Lobby() {
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawFilledRectangle(250, 100, 100, 100);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawText(280, 150, "Level 1");//Level 1 Button

        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledRectangle(450, 100, 100, 100);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawText(480, 150, "Level 2");//Level 2 Button

        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledRectangle(250, 350, 100, 100);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawText(280, 400, "Level 3");//Level 3 Button

        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledRectangle(450, 350, 100, 100);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawText(480, 400, "Level 4");//Level 4 Button

        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledRectangle(335, 530, 150, 150);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawText(370, 600, "BOSS LEVEL");//Level 5 (BOSS LEVEL) Button





    }

}