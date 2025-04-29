package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

/**
 * Dient zur unbeweglichen Anzeige von Bildern an einer bestimmten Position.
 */
public class Picture extends GraphicalObject {

    /*    public void create() {
        // Load space backgrounds
        backgrounds = new Texture[] {
            new Texture("bg1.png"),
            new Texture("bg2.png"),
            new Texture("bg3.png")
                };

        this.setScreen(new LobbyScreen(this));
    }

   public void dispose() {
        for (Texture bg : backgrounds) {
            bg.dispose();
        }
        super.dispose();
    }
     */

    public Picture(double x, double y, String path){
        setNewImage(path);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),x,y);
    }

}
