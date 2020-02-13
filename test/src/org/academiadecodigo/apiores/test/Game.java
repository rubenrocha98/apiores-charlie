package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.Levels.*;
import org.academiadecodigo.apiores.test.Levels.LevelStructure;

public class Game {

    private static int currentLevel =0;
    private static LevelStructure[] levels={new Level1(),new Level2(),new Level3() };
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



        }

    }

    public static LevelStructure getCurrentLevel(){
        return levels[currentLevel];
    }


}
