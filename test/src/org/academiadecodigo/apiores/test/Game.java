package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.levels.*;
import org.academiadecodigo.apiores.test.levels.LevelStructure;
import org.academiadecodigo.apiores.test.mainmenu.MainMenu;
import org.academiadecodigo.apiores.test.sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int currentLevel =0;
    private static LevelStructure[] levels={new Level1(),new Level2(),new Level3(),new Level4()};

    public void game() throws InterruptedException {
        MainMenu startMenu = new MainMenu();
        Sound alleyCat = new Sound(" resources/05 Alleycat Blues (1).wav");
        Sound shadow = new Sound(" resources/24-Shadow-Master.wav");
        Sound corneria = new Sound(" resources/06 Corneria (1).wav");
        Sound moon = new Sound(" resources/09-the-moon.wav");

        while (true) {
            alleyCat.play(true);
            startMenu.startMenu();

            currentLevel = 0;
            levels[currentLevel].start();
            if (LevelStructure.isGameOver()) {
                continue;
            }
            currentLevel++;
            levels[currentLevel].start();
            if (LevelStructure.isGameOver()) {
                continue;
            }

            alleyCat.stop();
            shadow.play(true);
            currentLevel++;
            levels[currentLevel].start();
            if(LevelStructure.isGameOver()){
                continue;
            }

            shadow.stop();
            corneria.play(true);
            currentLevel++;
            levels[currentLevel].start();
            if(LevelStructure.isGameOver()){
                continue;
            }

            Picture end = new Picture(10,10,"backgrounds/end.png");
            end.draw();
            Thread.sleep(15000);
            end.delete();

        }

    }

    public static LevelStructure getCurrentLevel(){
        return levels[currentLevel];
    }


}
