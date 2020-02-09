package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class LevelDesign {

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


    public LevelDesign() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
        duck = new Duck();

        // when rectangle and levelObjective share the same position the level clears

        levelObjective = new Rectangle(600, 10, 25, 25);

    }


    public void start() throws InterruptedException {

        return;

        }

    public  int getWidth(){
        return width;


    }
    public  int getHeight(){
        return height;
    }

    public  Rectangle getDuck(){
        return duck;
    }

    public void createObstacles(MoveObstacles[]track,int speed, int atX,int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new MoveObstacles((i+1)*atX, atY,speed);

        }

    }


    public void checkDead(MoveObstacles car){


        for(int j = duck.getX(); j<=duck.getX()+duck.getWidth();j++) {
            for(int k = duck.getY(); k<=duck.getY()+duck.getHeight();k++){

                if(car.getObstacle().getX() < j &&  car.getObstacle().getX()+car.getWidth() > j &&
                        car.getObstacle().getY() < k && car.getObstacle().getY()+car.getHeight() >k){
                    dead = true;
                }
            }

        }
    }

    public void checkCleared(){
        if(duck.getX() == levelObjective.getX() && duck.getY() == levelObjective.getY()){
            duck.delete();
            cleared = true;
        }

    }


    public boolean isDead() {
        return dead;
    }

    public void restart() {


        duck.delete();
        levelObjective.delete();

        dead=false;

    }

    public void deleteCars(MoveObstacles []track){
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }





}
