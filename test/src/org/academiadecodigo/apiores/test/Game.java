package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.levels.*;
import org.academiadecodigo.apiores.test.levels.LevelStructure;
import org.academiadecodigo.apiores.test.mainmenu.MainMenu;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int currentLevel =0;
    private static LevelStructure[] levels={new Level1(),new Level2(),new Level3(),new Level4()};

    public void game() throws InterruptedException {
        MainMenu startMenu = new MainMenu();

        while (true) {

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
            currentLevel++;
            levels[currentLevel].start();
            if(LevelStructure.isGameOver()){
                continue;
            }

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
