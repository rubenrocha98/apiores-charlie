package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.levels.*;
import org.academiadecodigo.apiores.test.levels.LevelStructure;
import org.academiadecodigo.apiores.test.mainmenu.MainMenu;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int currentLevel =0;
    private static LevelStructure[] levels={new Level3(),new Level2(),new Level3() };
    private MainMenu startMenu = new MainMenu();

    public void game() throws InterruptedException {


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
            Picture end = new Picture();



        }

    }

    public static LevelStructure getCurrentLevel(){
        return levels[currentLevel];
    }


}
