package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.Levels.*;
import org.academiadecodigo.apiores.test.Levels.LevelStructure;

public class Main {

    private static int curentLevelIndex = 0;
    private static LevelStructure[] levels = {new Level1(), new Level2(), new FinalLevel()};

    public static void main(String[] args) throws InterruptedException {






        while(true){

            levels[curentLevelIndex].start();
            curentLevelIndex++;
            levels[curentLevelIndex].start();
            curentLevelIndex++;
            levels[curentLevelIndex].start();

        }


    }





    public static LevelStructure getCurrentLevel(){
        return levels[curentLevelIndex];
    }


}
