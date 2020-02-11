package org.academiadecodigo.apiores.test;

import org.academiadecodigo.apiores.test.Levels.Level2;
import org.academiadecodigo.apiores.test.Levels.LevelStructure;

public class Main {

    public static LevelStructure level;
    public static void main(String[] args) throws InterruptedException{

        level = new Level2();

        level.start();

    }
}
