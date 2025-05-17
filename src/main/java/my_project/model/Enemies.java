package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Enemies extends InteractiveGraphicalObject {

    private double hoverY;
    private boolean hoverUp;
    private int level = 1;
    public double hp = 100; // HP der Gegner
    public double x = Math.random()*800+400;
    public double y = Math.random()*800;
    private double gehtBis = Math.random()*400 + 300;
    public boolean tot = false;
    public boolean wurdeGezaehlt = false;

    private double laserCooldown = 1;
    private double shots = 0;
    private final double startLaserCooldown = 1;
    private double respawnTimer = 0;  // Zeit bis zum nächsten Respawn
    private final double RESPAWN_TIME = 3; // Sekunden


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

    public static int score = 0;


    public Enemies() {
        this.setNewImage("src/main/resources/graphic/gegner2.png");
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (level == 1 && hp > 0) {
            drawTool.drawImage(getMyImage(), this.x, this.y + hoverY);
        }

        // Wenn der Gegner schießt
        drawTool.setCurrentColor(new Color(215, 43, 124));
        if (shoot && hp > 0) {
            drawTool.drawFilledRectangle(lx + 10, ly + 53 + hoverY, 15, 2);
        }
        if (shoot1 && hp > 0) {
            drawTool.drawFilledRectangle(lx1 + 10, ly1 + 53, 15, 2);
        }
        if (shoot2 && hp > 0) {
            drawTool.drawFilledRectangle(lx2 + 10, ly2 + 53 + hoverY*3, 15, 2);
        }
        if (shoot3 && hp > 0) {
            drawTool.drawFilledRectangle(lx3 + 10, ly3 + 53 + hoverY*2, 15, 2);
        }
        if (shoot4 && hp > 0) {
            drawTool.drawFilledRectangle(lx4 + 10, ly4 + 53 + hoverY*5, 15, 2);
        }
        if (shoot5 && hp > 0) {
            int timer = 3;
            if (timer > 0) {
                drawTool.drawFilledRectangle(lx5 - 350, ly5 + 53 + hoverY,  30 + lx5*2, 2);
            }
        }
        if (shoot6 && hp > 0) {
            drawTool.drawFilledRectangle(lx6 + 10, ly6 + 43 + hoverY*2, 15, 2);
            drawTool.drawFilledRectangle(lx6 + 10, ly6 + 63 + hoverY*2, 15, 2);
        }
    }

    @Override
        public void update(double dt) {
            if (tot) {
                respawnTimer -= dt;
                if (respawnTimer <= 0) {
                    // Gegner wiederbeleben
                    this.x = Math.random() * 800 + 900; // Rechts außerhalb
                    this.y = Math.random() * 600;
                    this.gehtBis = Math.random() * 400 + 300;
                    this.hp = 100;
                    this.shots = 0;
                    this.tot = false;
                    System.out.println("Gegner respawned!");
                    score += 10;
                }
            }

            // Wenn Gegner stirbt
            if (hp <= 0 && !tot) {
                this.x = 2000;  // Wegschieben
                this.tot = true;
                this.respawnTimer = RESPAWN_TIME;
                System.out.println("Gegner tot, respawn in " + RESPAWN_TIME + "s");
            }


            // Hover-Effekt
        if (hoverUp) {
            hoverY = hoverY - 25 * dt;
            //this.y = hoverY;
            if (hoverY < -15) hoverUp = false;
        } else {
            hoverY = hoverY + 25 * dt;
            //this.y = hoverY;
            if (hoverY > 15) hoverUp = true;
        }

        if (this.x > gehtBis){
            this.x = this.x - 150*dt;
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
        if (this.hp <= 0 && !tot) {
            tot = true;
            System.out.println("Enemy HP: " + hp);
            score += 10;
        }
    }

    public boolean collidesWith(Player p) {
        // Hier wird eine einfache Rechteck-Kollision geprüft
        return (this.lx + this.width > p.x && this.x < p.x + p.getWidth()) &&
                    (this.ly + this.height > p.y && this.y < p.y + p.getHeight()) ||

                (this.lx1 + this.width > p.x && this.lx1 < p.x + p.getWidth()) &&
                        (this.ly1 + this.height > p.y && this.ly1 < p.y + p.getHeight()) ||

                (this.lx2 + this.width > p.x && this.lx2 < p.x + p.getWidth()) &&
                        (this.ly2 + this.height > p.y && this.ly2 < p.y + p.getHeight()) ||

                (this.lx3 + this.width > p.x && this.lx3 < p.x + p.getWidth()) &&
                        (this.ly3 + this.height > p.y && this.ly3 < p.y + p.getHeight()) ||

                (this.lx4 + this.width > p.x && this.lx4 < p.x + p.getWidth()) &&
                        (this.ly4 + this.height > p.y && this.ly4 < p.y + p.getHeight()) ||

                (this.lx5 + this.width > p.x && this.lx5 < p.x + p.getWidth()) &&
                        (this.ly5 + this.height > p.y && this.ly5 < p.y + p.getHeight()) ||

                (this.lx6 + this.width > p.x && this.lx6 < p.x + p.getWidth()) &&
                        (this.ly6 + this.height > p.y && this.ly6 < p.y + p.getHeight());
    }
}
