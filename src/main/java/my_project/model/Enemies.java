package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Enemies extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    private int level = 1;
    public double hp = 100; // HP der Gegner
    public double x = 700;
    public double y = 700;

    private double laserCooldown = 1;
    private double shots = 0;
    private final double startLaserCooldown = 1;

    public double lx = x;
    public double ly = y;
    public double lx1 = x;
    public double ly1 = y;
    public double lx2 = x;
    public double ly2 = y;
    public double lx3 = x;
    public double ly3 = y;
    public double lx4 = x;
    public double ly4 = y;
    public double lx5 = x;
    public double ly5 = y;
    public double lx6 = x;
    public double ly6 = y;

    public boolean shoot = false;
    public boolean shoot1 = false;
    public boolean shoot2 = false;
    public boolean shoot3 = false;
    public boolean shoot4 = false;
    public boolean shoot5 = false;
    public boolean shoot6 = false;


    public Enemies(int y) {
        this.setNewImage("src/main/resources/graphic/gegner.png");
        hoverUp = true;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (level == 1 && hp > 0) {
            drawTool.drawImage(getMyImage(), this.x, this.y + hoverY);
        }

        // Wenn der Gegner schießt
        drawTool.setCurrentColor(Color.RED);
        if (shoot && hp > 0) {
            drawTool.drawFilledRectangle(lx + 10, ly + 25, 20, 10);
        }
        if (shoot1 && hp > 0) {
            drawTool.drawFilledRectangle(lx1 + 10, ly1 + 25, 20, 10);
        }
        if (shoot2 && hp > 0) {
            drawTool.drawFilledRectangle(lx2 + 10, ly2 + 25, 20, 10);
        }
        if (shoot3 && hp > 0) {
            drawTool.drawFilledRectangle(lx3 + 10, ly3 + 25, 20, 10);
        }
        if (shoot4 && hp > 0) {
            drawTool.drawFilledRectangle(lx4 + 10, ly4 + 25, 20, 10);
        }
        if (shoot5 && hp > 0) {
            drawTool.drawFilledRectangle(lx5 + 10, ly5 + 25, 20, 10);
        }
        if (shoot6 && hp > 0) {
            drawTool.drawFilledRectangle(lx6 + 10, ly6 + 25, 20, 10);
        }
    }

    @Override
    public void update(double dt) {
        if (hp <= 0) {
            this.x = 1000; // Entfernen aus dem Sichtbereich
            shoot = false;
            shoot1 = false;
            shoot2 = false;
            shoot3 = false;
            shoot4 = false;
            shoot5 = false;
            shoot6 = false;

            shots = 7;
        }

        // Hover-Effekt
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

        laserCooldown -= dt;

        if (laserCooldown <= 0 && shots == 0){
            shoot = true;
            shots = 1;
            laserCooldown = startLaserCooldown;
        } else if (laserCooldown <= 0 && shots == 1){
            shoot1 = true;
            shots = 2;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 2){
            shoot2 = true;
            shots = 3;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 3){
            shoot3 = true;
            shots = 4;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 4){
            shoot4 = true;
            shots = 5;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 5){
            shoot5 = true;
            shots = 6;
            laserCooldown = startLaserCooldown;
        }else if (laserCooldown <= 0 && shots == 6){
            shoot6 = true;
            shots = 0;
            laserCooldown = startLaserCooldown;
        }

        if (shoot){
            lx -= 500*dt;
        }
        if (shoot1){
            lx1 -= 500*dt;
        }
        if (shoot2){
            lx2 -= 500*dt;
        }
        if (shoot3){
            lx3 -= 500*dt;
        }
        if (shoot4){
            lx4 -= 500*dt;
        }
        if (shoot5){
            lx5 -= 500*dt;
        }
        if (shoot6){
            lx6 -= 500*dt;
        }

        if (lx < 0){
            lx = this.x;
            ly = this.y;
            shoot = false;
        }
        if (lx1 < 0){
            lx1 = this.x;
            ly1 = this.y;
            shoot1 = false;
        }
        if (lx2 < 0){
            lx2 = this.x;
            ly2 = this.y;
            shoot2 = false;
        }
        if (lx3 < 0){
            lx3 = this.x;
            ly3 = this.y;
            shoot3 = false;
        }
        if (lx4 < 0){
            lx4 = this.x;
            ly4 = this.y;
            shoot4 = false;
        }
        if (lx5 < 0){
            lx5 = this.x;
            ly5 = this.y;
            shoot5 = false;
        }
        if (lx6 < 0){
            lx6 = this.x;
            ly6 = this.y;
            shoot6 = false;
        }

        if (shoot == false){
            lx = this.x;
            ly = this.y;
        }
        if (shoot1 == false){
            lx1 = this.x;
            ly1 = this.y;
        }
        if (shoot2 == false){
            lx2 = this.x;
            ly2 = this.y;
        }
        if (shoot3 == false){
            lx3 = this.x;
            ly3 = this.y;
        }
        if (shoot4 == false){
            lx4 = this.x;
            ly4 = this.y;
        }
        if (shoot5 == false){
            lx5 = this.x;
            ly5 = this.y;
        }
        if (shoot6 == false){
            lx6 = this.x;
            ly6 = this.y;
        }
    }

    // Methode zum Schadennehmen
    public void takeDamage(double amount) {
        this.hp -= amount;
        if (this.hp <= 0) {
            this.hp = 0;
            this.x = 1000;
            shoot = false;
            shots = 7;
        }
    }
}
