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
    public double ly = y;
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
        if (shoot) {
            drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);
        }
        if (shoot1) {
            drawTool.drawFilledRectangle(lx1 + 10, ly1 + 25, 20, 10);
        }
        if (shoot2) {
        drawTool.drawFilledRectangle(lx2 + 10, ly2 + 25, 20, 10);
        }
        if (shoot3) {
        drawTool.drawFilledRectangle(lx3 + 10, ly3 + 25, 20, 10);
        }
        if (shoot4) {
        drawTool.drawFilledRectangle(lx4 + 10, ly4 + 25, 20, 10);
        }
        if (shoot5) {
        drawTool.drawFilledRectangle(lx5 + 10, ly5 + 25, 20, 10);
        }
        if (shoot6) {
            drawTool.drawFilledRectangle(lx6 + 10, ly6 + 25, 20, 10);
        }
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
            lx = Player.x;
            ly = Player.y;
            shoot = false;
        }
        if (lx1 > Config.WINDOW_WIDTH){
            lx1 = Player.x;
            ly1 = Player.y;
            shoot1 = false;
        }
        if (lx2 > Config.WINDOW_WIDTH){
            lx2 = Player.x;
            ly2 = Player.y;
            shoot2 = false;
        }
        if (lx3 > Config.WINDOW_WIDTH){
            lx3 = Player.x;
            ly3 = Player.y;
            shoot3 = false;
        }
        if (lx4 > Config.WINDOW_WIDTH){
            lx4 = x;
            ly4 = Player.y;
            shoot4 = false;
        }
        if (lx5 > Config.WINDOW_WIDTH){
            lx5 = Player.x;
            ly5 = Player.y;
            shoot5 = false;
        }
        if (lx6 > Config.WINDOW_WIDTH){
            lx6 = Player.x;
            ly6 = Player.y;
            shoot6 = false;
        }

        if (shoot == false){
            lx = Player.x;
            ly = Player.y;
        }
        if (shoot1 == false){
            lx1 = Player.x;
            ly1 = Player.y;
        }
        if (shoot2 == false){
            lx2 = Player.x;
            ly2 = Player.y;
        }
        if (shoot3 == false){
            lx3 = Player.x;
            ly3 = Player.y;
        }
        if (shoot4 == false){
            lx4 = Player.x;
            ly4 = Player.y;
        }
        if (shoot5 == false){
            lx5 = Player.x;
            ly5 = Player.y;
        }
        if (shoot6 == false){
            lx6 = Player.x;
            ly6 = Player.y;
        }

        checkAndHandleCollision();

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

    public boolean checkAndHandleCollision() {
        if (lx >= Enemies.x && lx <= Enemies.x + 100 && ly >= Enemies.y && ly <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot = false;
        }else if (lx1 >= Enemies.x && lx1 <= Enemies.x + 100 && ly1 >= Enemies.y && ly1 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot1 = false;
        }else if (lx2 >= Enemies.x && lx2 <= Enemies.x + 100 && ly2 >= Enemies.y && ly2 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot2 = false;
        }else if (lx3 >= Enemies.x && lx3 <= Enemies.x + 100 && ly3 >= Enemies.y && ly3 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot3 = false;
        }else if (lx4 >= Enemies.x && lx4 <= Enemies.x + 100 && ly4 >= Enemies.y && ly4 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot4 = false;
        }else if (lx5 >= Enemies.x && lx5 <= Enemies.x + 100 && ly5 >= Enemies.y && ly5 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot5 = false;
        }else if (lx6 >= Enemies.x && lx6 <= Enemies.x + 100 && ly6 >= Enemies.y && ly6 <= Enemies.y + 100) {
            Enemies.hp = 0;
            shoot6 = false;
        }
        return false;
    }

}