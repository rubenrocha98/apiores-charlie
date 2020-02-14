package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.cutscene.Cutscene;
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
        Picture devs = new Picture(10,10,"resources/credits/Developers.png");
        Picture mcs = new Picture(10,10,"resources/credits/Special-Thanks.png");
        Sound alleyCat = new Sound(" resources/05 Alleycat Blues (1).wav");
        Sound shadow = new Sound(" resources/24-Shadow-Master.wav");
        Sound corneria = new Sound(" resources/06 Corneria (1).wav");
        Sound moon = new Sound(" resources/09-the-moon.wav");
        Cutscene cutscene = new Cutscene();

        while (true) {
            alleyCat.stop();
            shadow.stop();
            corneria.stop();
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
                cutscene.rocketCutscene();
            corneria.stop();

            shadow.play(true);
            currentLevel++;
            levels[currentLevel].start();
            if(LevelStructure.isGameOver()){
                continue;
            }
            shadow.stop();

            moon.play(true);
            cutscene.landingCutscene();

            Picture end = new Picture(10,10,"resources/backgrounds/end.png");

            end.draw();
            Thread.sleep(7000);
            end.delete();

            devs.draw();
            Thread.sleep(5000);
            devs.delete();

            mcs.draw();
            Thread.sleep(7000);
            mcs.delete();

            moon.stop();

        }

    }

    public static LevelStructure getCurrentLevel(){
        return levels[currentLevel];
    }


}
