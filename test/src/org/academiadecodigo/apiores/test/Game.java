package org.academiadecodigo.apiores.test;

import com.sun.tools.javac.Main;
import org.academiadecodigo.apiores.test.Levels.*;
import org.academiadecodigo.apiores.test.Levels.LevelStructure;

public class Game {

    private static int curentLevelIndex =0;
    private static LevelStructure[] levels={new Level1(),new Level2(),new Level3() };
    private MainMenu startMenu = new MainMenu();

    private boolean mainMenu=true;
    public void game() throws InterruptedException {


        while (true) {

            startMenu.startMenu();

            curentLevelIndex = 0;
            levels[curentLevelIndex].start();
            if (LevelStructure.isGameOver()) {
                continue;
            }
            curentLevelIndex++;
            levels[curentLevelIndex].start();
            if (LevelStructure.isGameOver()) {
                continue;
            }
            curentLevelIndex++;
            levels[curentLevelIndex].start();
            if(LevelStructure.isGameOver()){
                continue;
            }



        }

    }

    public static LevelStructure getCurrentLevel(){
        return levels[curentLevelIndex];
    }


}
