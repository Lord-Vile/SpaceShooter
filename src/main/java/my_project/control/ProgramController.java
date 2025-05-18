package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.*;
import my_project.view.InputManager;

import java.awt.*;
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
    private Lobby lobby;
    private Lose loose;
    private Enemies[] e1;
    private Enemies[] e2;
    private Enemies[] e3;
    private Enemies[] e4;
    private Enemies[] e5;
    private int currentScene;
    Enemies[] enemies;
    private boolean spawnEnemies = false;
    private int anzahlEnemies = 3;
    private int toteEnemies = 0;
    private int score = 0;


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

        this.l1 = new Laser();
        viewController.draw(l1, 1);


        p1 = new Player();
        viewController.draw(p1,1);
        viewController.register(p1,1);

        this.e1 = new Enemies[5];

        for (int i = 0; i < 5; i++) {
            e1[i] = new Enemies();
            viewController.draw(e1[i],1);
            viewController.register(e1[i],1);
        }


        // Endbildschirm (Szene 2)
        viewController.createScene(); //death-screen
        viewController.draw(sback,2);
        this.loose = new Lose();
        viewController.draw(loose, 2);
        lobby = new Lobby();
        viewController.draw(lobby,2);

    }

    /**
     * Diese Methode wird vom ViewController-Objekt automatisch mit jedem Frame aufgerufen (ca. 60mal pro Sekunde)
     * Zeit seit letztem Frame in Sekunden
     */


    public void updateProgram(double dt) {
        checkAndHandleCollision();

        for (Enemies enemy : e1) {
            if (enemy.tot == true){
                toteEnemies += 1;
                System.out.println(toteEnemies);
                score += 10;
            }
        }
        if (p1.health <= 0) {
            currentScene = 2;
            viewController.showScene(currentScene);
        }

        if (toteEnemies >= 5){
            spawnEnemies = true;
        }

        if (spawnEnemies) {
            // Erstelle ein neues Array mit Platz für mehr Gegner
            Enemies[] neueE1 = new Enemies[e1.length + 5];  // 5 neue Gegner hinzufügen

            // Übernehme die alten Gegner in das neue Array
            for (int i = 0; i < e1.length; i++) {
                neueE1[i] = e1[i];
            }

            // Füge die neuen Gegner zum Array hinzu
            for (int i = e1.length; i < neueE1.length; i++) {
                neueE1[i] = new Enemies();
                viewController.draw(neueE1[i], 1);
                viewController.register(neueE1[i], 1);
            }

            // Ersetze das alte Array mit dem neuen
            e1 = neueE1;
            spawnEnemies = false;
            toteEnemies = -10;  // Zurücksetzen
        }


    }


    public void processKeyboardInput(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE && currentScene == 0) {
            currentScene = 1;
            viewController.showScene(currentScene);
            SoundController.stopSound("startBGM");
            SoundController.playSound("startLevelA");
            SoundController.playSound("whoosh");
        }
    }


    public void checkAndHandleCollision() {
        for (Enemies enemy : e1) {
            if (l1.collidesWith(enemy)) {
                if (!enemy.tot) {
                    enemy.takeDamage(50);
                }
                l1.reset(); // Laser wird unabhängig vom Gegnerzustand zurückgesetzt
            }

            if (!enemy.tot && enemy.collidesWith(p1)) {
                p1.takeDamage(20);
            }
        }
    }
}