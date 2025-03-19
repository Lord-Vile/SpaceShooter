package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.model.*;
import my_project.view.InputManager;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern.
 * Hinweise:
 * - Der Konstruktor sollte nicht geändert werden.
 * - Sowohl die startProgram()- als auch die updateProgram(...)-Methoden müssen vorhanden sein und ihre Signatur sollte
 *   nicht geändert werden
 * - Zusätzliche Methoden sind natürlich gar kein Problem
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player p1;
    private Laser l1;
    private Enemies e1;
    private int currentScene;
    Enemies[] enemies;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Hier sollte also alles geregelt werden,
     * was zu diesem Zeipunkt passieren muss.
     */
    public void startProgram() {
        // Vorbereitungen
        InputManager inputManager = new InputManager(this);
        currentScene = 0;

        // Startbildschirm (Szene 0)
        // Ton
        viewController.getSoundController().loadSound("src/main/resources/sound/bgm_startScreen.mp3","startBGM", true);
        SoundController.playSound("startBGM");
        // Bild
        StartBackground sback = new StartBackground();
        viewController.draw(sback,0);

        Picture titleText = new Picture(100, 200, "src/main/resources/graphic/title_text.png");
        viewController.draw(titleText,0);
        // Interaktion
        viewController.register(inputManager,0);

        // Spielbildschirm (Szene 1)
        viewController.getSoundController().loadSound("src/main/resources/sound/GUILES THEMES1.mp3","startLevelA", true);
        viewController.getSoundController().loadSound("src/main/resources/sound/whoosh.mp3","whoosh", false);
        viewController.createScene();
        viewController.draw(sback,1);
        l1 = new Laser();
        viewController.draw(l1,1);
        viewController.register(l1,1);
        p1 = new Player();
        viewController.draw(p1,1);
        viewController.register(p1,1);

        e1 = new Enemies(350);
        viewController.draw(e1,1);
        viewController.register(e1,1);


        // Endbildschirm (Szene 2)
    }

    /**
     * Diese Methode wird vom ViewController-Objekt automatisch mit jedem Frame aufgerufen (ca. 60mal pro Sekunde)
     * @param dt Zeit seit letztem Frame in Sekunden
     */
    public void updateProgram(double dt){

    }

    public void processKeyboardInput(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE && currentScene == 0) {
            currentScene = 1;
            viewController.showScene(currentScene);
            SoundController.stopSound("startBGM");
            SoundController.playSound("startLevelA");
            SoundController.playSound("whoosh");
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

}
