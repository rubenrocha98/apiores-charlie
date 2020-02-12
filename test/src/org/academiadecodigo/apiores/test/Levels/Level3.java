package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.*;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level3 extends LevelStructure {

    private final int PADDING = 10;
    private final  int width =  1000 + PADDING;
    private final  int height =  500 + PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new RobotDuck[5];


    /*
    private Obstacles[] secondTrack = new RobotDuck[3];
    private Obstacles[] thirdTrack = new RobotDuck[5];
    private Obstacles[] fourthTrack = new RobotDuck[4];
    private Obstacles[] fifthTrack = new RobotDuck[4];

    */

    private boolean dead = false;
    private boolean cleared = false;
    private Rectangle levelObjective;



    public Level3() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
        Picture textureDesert = new Picture(105, 20, "Texture_Desert.png");
        textureDesert.draw();
        duck = new Duck();

        // when rectangle and levelObjective share the same position the level clears

        levelObjective = new Rectangle(600, 10, 30, 30);

    }

    public void start() throws InterruptedException {

        while(true) {

            if(cleared){
                break;
            }
            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            while (!dead) {


                if(checkCleared()){
                    Thread.sleep(1500);
                    deleteLevel();
                    return;
                }
                for (Obstacles obstacle : firstTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);

                    /*

                }
                for (Obstacles obstacle : secondTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);

                }
                for (Obstacles obstacle : thirdTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }

                for (Obstacles obstacle : fourthTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }
                for (Obstacles obstacle : fifthTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }

                */

                Thread.sleep(75);


            }


            if(dead){
                lives--;
                Thread.sleep(1500);
                restartLevel();
            }
            while(lives ==0){
                System.out.println();
            }


        }
    }
    public  int getWidth(){
        return width;


    }
    public  int getHeight(){
        return height;
    }

    public  Picture getDuck(){
        return duck;
    }

    public void createObstacles(Obstacles[]track,int speed,int atX,int atY){

    }

    public void createCars(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Car((i + 1) * atX, atY, speed) {
            };

        }

    }

    public void createBuses(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Bus((i + 1) * atX, atY, speed) {
            };

        }
    }

    public void createRobots(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Robot((i + 1) * atX, atY, speed) {
            };

        }
    }

    public void createRobotDucks(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Robot((i + 1) * atX, atY, speed) {
            };

        }
    }



    public void checkDead(Obstacles obstacle){


        for(int j = duck.getX(); j<=duck.getX()+duck.getWidth();j++) {
            for(int k = duck.getY(); k<=duck.getY()+duck.getHeight();k++){

                if(obstacle.getObstacle().getX() < j &&  obstacle.getObstacle().getX()+obstacle.getWidth() > j &&
                        obstacle.getObstacle().getY() < k && obstacle.getObstacle().getY()+obstacle.getHeight() >k){
                    dead = true;
                }
            }

        }
    }

    public boolean checkCleared() {


        if(duck.getY()==PADDING){
            return true;
        }


        return false;
    }



    public boolean isDead() {
        return dead;
    }
    public void restartLevel(){
        duck.delete();
        deleteObstacles(firstTrack);

        /*
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);
        deleteObstacles(fifthTrack);
        */
        levelObjective.delete();
        dead=false;
    }
    public void restart(){
        lives=3;
    }



    public void deleteLevel() {
        duck.delete();
        deleteObstacles(firstTrack);
        /*
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);
        deleteObstacles(fifthTrack);

        */
        levelObjective.delete();
    }

    public void deleteObstacles(Obstacles[]track){
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

    public void createLevel(){
        duck.delete();
        levelObjective.delete();
        duck = new Duck();
        levelObjective = new Rectangle(10, 10, width, 30);
        levelObjective.setColor(Color.ORANGE);
        levelObjective.fill();
        duck.draw();


        createRobotDucks(firstTrack, 15, 145, 400);

        /*
        createRobotDucks(secondTrack, 15, 250, 350);
        createRobotDucks(thirdTrack, -15, 150, 250);
        createRobotDucks(fourthTrack, 15, 145, 150);
        createRobotDucks(fifthTrack, -12, 115, 100);
        */




        Rectangle borderLeft = new Rectangle(10, 10, 90, height);
        Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
        borderRight.setColor(Color.BLUE);
        borderLeft.setColor(Color.BLUE);
        borderLeft.fill();
        borderRight.fill();

    }

}
