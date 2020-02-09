package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class LevelStructure {


     private final int PADDING = 10;
     private  int cellSize= 20;
     private int  maxCols = 50;
     private  int maxRows = 25;
     private final  int width = cellSize * maxCols + PADDING;
     private final  int height = cellSize * maxRows + PADDING;
     private Rectangle duck;


     private boolean dead = false;

     // trying to implement level cleared conditions

     private boolean cleared = false;
     private Rectangle levelObjective;



     public abstract void start() throws InterruptedException;

     public  abstract int getWidth();

     public  abstract int getHeight();

     public  abstract Rectangle getDuck();

     public abstract void createObstacles(MoveObstacles[]track,int speed, int atX,int atY);

     public abstract void checkDead(MoveObstacles car);

     public abstract void checkCleared();

     public abstract boolean isDead();

     public abstract void restart();

     public abstract void deleteCars(MoveObstacles []track);





}
