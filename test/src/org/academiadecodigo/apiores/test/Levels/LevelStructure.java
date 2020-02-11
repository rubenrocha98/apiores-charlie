package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Obstacles.Obstacles;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.*;

public abstract class LevelStructure {


     static int lives = 3;


     private boolean dead = false;

     // trying to implement level cleared conditions

     private boolean cleared = false;
     private Rectangle levelObjective;



     public abstract void start() throws InterruptedException;

     public  abstract int getWidth();

     public  abstract int getHeight();

     public  abstract Picture getDuck();

     public abstract void createObstacles(Obstacles[]track, int speed, int atX, int atY);

     public abstract void checkDead(Obstacles obstacles);

     public abstract boolean checkCleared();

     public abstract boolean isDead();



     public abstract void deleteObstacles(Obstacles[]track);

     public abstract void restartLevel();

     public abstract void restart();

     public abstract void createLevel();

     public abstract void deleteLevel();

     public void lifeLoss(){
          lives--;
     }

     public static int getLives(){
          return lives;
     }





}
