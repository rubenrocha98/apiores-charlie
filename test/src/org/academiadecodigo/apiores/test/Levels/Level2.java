package org.academiadecodigo.apiores.test.Levels;


import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.*;
import org.academiadecodigo.simplegraphics.graphics.*;

public class Level2 extends LevelStructure {

    private final int PADDING = 10;
    private final  int width =  1000+ PADDING;
    private final  int height =  500+ PADDING;
    private Rectangle duck;
    private Car[] firstTrack = new Car[5];
    private Bus[] secondTrack = new Bus[3];
    private Car[] thirdTrack = new Car[5];
    private Car[] fourthTrack = new Car[4];
    private Car[] fifthTrack = new Car[4];



    private boolean dead = false;

    // trying to implement level cleared conditions

    private boolean cleared = false;
    private Rectangle levelObjective;



    public Level2() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
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

            while (!dead && !cleared) {

                checkCleared();

                for (Car obstacle : firstTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);

                }
                for (Bus obstacle : secondTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);

                }
                for (Car obstacle : thirdTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }

                for (Car obstacle : fourthTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }
                for (Car obstacle : fifthTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }

                Thread.sleep(75);


            }

            if(dead){
                duck.setColor(Color.RED);
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

    public  Rectangle getDuck(){
        return duck;
    }

    public void createObstacles(Obstacles[]track,int speed,int atX,int atY){

    }

    public void createCars(Car[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Car((i + 1) * atX, atY, speed) {
            };

        }

    }

    public void createBuses(Bus[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Bus((i + 1) * atX, atY, speed) {
            };

        }
    }

    public void createRobots(Robot[]track, int speed, int atX, int atY){

        System.out.println();
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

    public boolean checkCleared(){
        if(duck.getX() == levelObjective.getX() && duck.getY() == levelObjective.getY()){
            duck.delete();
            return true;
        }
        return false;
    }


    public boolean isDead() {
        return dead;
    }
    public void restartLevel(){
        duck.delete();
        deleteCars(firstTrack);
        deleteCars(secondTrack);
        deleteCars(thirdTrack);
        deleteCars(fourthTrack);
        deleteCars(fifthTrack);
        levelObjective.delete();

        dead=false;
    }



    public void deleteCars(Obstacles[]track){
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

    public void createLevel(){
        duck.delete();
        levelObjective.delete();
        duck = new Duck();
        levelObjective = new Rectangle(600, 10, 30, 30);



        duck.setColor(Color.BLUE);
        duck.fill();

        levelObjective.setColor(Color.ORANGE);
        levelObjective.fill();


        createCars(firstTrack, 15, 145, 400);
        createBuses(secondTrack, 15, 250, 350);
        createCars(thirdTrack, -15, 150, 250);
        createCars(fourthTrack, 15, 145, 150);
        createCars(fifthTrack, -12, 115, 100);

        Rectangle borderLeft = new Rectangle(10, 10, 90, height);
        Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
        borderRight.setColor(Color.BLUE);
        borderLeft.setColor(Color.BLUE);
        borderLeft.fill();
        borderRight.fill();
    }



}
