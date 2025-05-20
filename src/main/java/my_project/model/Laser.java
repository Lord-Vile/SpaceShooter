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

    public double x = 50;
    public double y = 350;
    public int width = 20;
    public int height = 2;
    double x1 = x;
    double y1 = y;
    double x2 = x;
    double y2 = y;
    double x3 = x;
    double y3 = y;
    double x4 = x;
    double y4 = y;
    double x5 = x;
    double y5 = y;
    double x6 = x;
    double y6 = y;
    private boolean shoot = false;
    private boolean shoot1 = false;
    private boolean shoot2 = false;
    private boolean shoot3 = false;
    private boolean shoot4 = false;
    private boolean shoot5 = false;
    private boolean shoot6 = false;

    public Laser(){

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLUE);
        if (shoot) {
            drawTool.drawFilledRectangle(x + 10, y + 25, width, height);
        }
        if (shoot1) {
            drawTool.drawFilledRectangle(x1 + 10, y1 + 25, width, height);
        }
        if (shoot2) {
            drawTool.drawFilledRectangle(x2 + 10, y2 + 25, width, height);
        }
        if (shoot3) {
            drawTool.drawFilledRectangle(x3 + 10, y3 + 25, width, height);
        }
        if (shoot4) {
            drawTool.drawFilledRectangle(x4 + 10, y4 + 25, width, height);
        }
        if (shoot5) {
            drawTool.drawFilledRectangle(x5 + 10, y5 + 25, width, height);
        }
        if (shoot6) {
            drawTool.drawFilledRectangle(x6 + 10, y6 + 25, width, height);
        }
    }

    @Override
    public void update(double dt) {
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

        if (shoot) {
            this.x += 500 * dt;
        }
        if (shoot1){
            x1 += 500*dt;
        }
        if (shoot2){
            x2 += 500*dt;
        }
        if (shoot3){
            x3 += 500*dt;
        }
        if (shoot4){
            x4 += 500*dt;
        }
        if (shoot5){
            x5 += 500*dt;
        }
        if (shoot6){
            x6 += 500*dt;
        }

        if (this.x > Config.WINDOW_WIDTH) {
            this.x = Player.x;
            this.y = Player.y;
            shoot = false;
        }
        if (x1 > Config.WINDOW_WIDTH){
            x1 = this.x;
            y1 = this.y;
            shoot1 = false;
        }
        if (x2 > Config.WINDOW_WIDTH){
            x2 = this.x;
            y2 = this.y;
            shoot2 = false;
        }
        if (x3 > Config.WINDOW_WIDTH){
            x3 = this.x;
            y3 = this.y;
            shoot3 = false;
        }
        if (x4 > Config.WINDOW_WIDTH){
            x4 = this.x;
            y4 = this.y;
            shoot4 = false;
        }
        if (x5 > Config.WINDOW_WIDTH){
            x5 = this.x;
            y5 = this.y;
            shoot5 = false;
        }
        if (x6 > Config.WINDOW_WIDTH){
            x6 = this.x;
            y6 = this.y;
            shoot6 = false;
        }

        if (shoot == false){
            this.x = Player.x;
            this.y = Player.y;
        }
        if (shoot1 == false){
            x1 = Player.x;
            y1 = Player.y;
        }
        if (shoot2 == false){
            x2 = Player.x;
            y2 = Player.y;
        }
        if (shoot3 == false){
            x3 = Player.x;
            y3 = Player.y;
        }
        if (shoot4 == false){
            x4 = Player.x;
            y4 = Player.y;
        }
        if (shoot5 == false){
            x5 = Player.x;
            y5 = Player.y;
        }
        if (shoot6 == false){
            x6 = Player.x;
            y6 = Player.y;
        }
    }

    public void reset() {
        if (shoot) {
            shoot = false;
        }else if(shoot1){
            shoot1 = false;// Laser stoppen
        }else if(shoot2){
            shoot2 = false;
        }else if (shoot3){
            shoot3 = false;
        }else if (shoot4){
            shoot4 = false;
        }else if (shoot5){
            shoot5 = false;
        }else if (shoot6){
            shoot6 = false;
        }
    }

    public boolean collidesWith(Enemies enemy) {
        // Hier wird eine einfache Rechteck-Kollision geprüft
        return (this.x + this.width > enemy.x && this.x < enemy.x + enemy.getWidth()) &&
                (this.y + this.height > enemy.y && this.y < enemy.y + enemy.getHeight()) ||

                (this.x1 + this.width > enemy.x && this.x1 < enemy.x + enemy.getWidth()) &&
                (this.y1 + this.height > enemy.y && this.y1 < enemy.y + enemy.getHeight()) ||

                (this.x2 + this.width > enemy.x && this.x2 < enemy.x + enemy.getWidth()) &&
                (this.y2 + this.height > enemy.y && this.y2 < enemy.y + enemy.getHeight()) ||

                (this.x3 + this.width > enemy.x && this.x3 < enemy.x + enemy.getWidth()) &&
                (this.y3 + this.height > enemy.y && this.y3 < enemy.y + enemy.getHeight()) ||

                (this.x4 + this.width > enemy.x && this.x4 < enemy.x + enemy.getWidth()) &&
                (this.y4 + this.height > enemy.y && this.y4 < enemy.y + enemy.getHeight()) ||

                (this.x5 + this.width > enemy.x && this.x5 < enemy.x + enemy.getWidth()) &&
                (this.y5 + this.height > enemy.y && this.y5 < enemy.y + enemy.getHeight()) ||

                (this.x6 + this.width > enemy.x && this.x6 < enemy.x + enemy.getWidth()) &&
                (this.y6 + this.height > enemy.y && this.y6 < enemy.y + enemy.getHeight()) ; //||

        }
}

