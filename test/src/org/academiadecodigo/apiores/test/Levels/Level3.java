package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.Bus;
import org.academiadecodigo.apiores.test.Obstacles.Car;
import org.academiadecodigo.apiores.test.Obstacles.Obstacles;
import org.academiadecodigo.apiores.test.Obstacles.Robot;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level3 extends LevelStructure{

    private final int PADDING = 10;
    private final int WIDTH =  1000 + PADDING;
    private final int HEIGHT =  500 + PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new Robot[7];
    private Obstacles[] secondTrack = new Robot[4];
    private Obstacles[] thirdTrack = new Robot[5];
    private Obstacles[] fourthTrack = new Robot[4];
    private Obstacles[] fifthTrack = new Robot[4];
    private Obstacles[] sixthTrack = new Robot[7];
    private Obstacles[] seventhTrack = new Robot[7];
    private Obstacles[] eightTrack = new Robot[7];
    private boolean dead = false;
    private Rectangle levelObjective= new Rectangle(600, 10, 30, 30);
    private Picture gameOverLet;
    private Picture grave;
    Picture hp = new Picture(110,490, "fullhp.png");
    Picture border = new Picture(10,10,"border.png");
    Picture level3 = new Picture(850,483,"lvl3.png");

    public Level3() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, WIDTH, HEIGHT);
        canvas.show(rec);
        Picture textureDesert = new Picture(105, 20, "Texture_Desert.png");
        textureDesert.draw();
        duck = new Duck();
        gameOverLet = new Picture(425,197,"gameover1.png");
    }

    public void start() throws InterruptedException {

        while (true) {
            border.delete();
            level3.delete();

            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            if(lives == 3){
                hp.load("fullHp.png");
            }
            if(lives==2){
                hp.load("2hpleft.png");
            }
            if(lives==1){
                hp.load("1hpleft.png");
            }
            if(lives==0){
                hp.load("nohpleft.png");
            }
            hp.delete();
            hp.draw();
            while (!dead) {


                if (checkCleared()) {
                    Thread.sleep(1500);
                    deleteLevel();
                    hp.delete();
                    return;
                }
                for (Obstacles obstacle : firstTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);

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
                for (Obstacles obstacle : sixthTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }
                for (Obstacles obstacle : seventhTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }
                for (Obstacles obstacle : eightTrack) {
                    obstacle.moveObstacle();
                    checkDead(obstacle);
                }

                Thread.sleep(75);


            }


            if (dead) {
                grave = new Picture(duck.getX() - 6, duck.getY() - 5, "grave_resized.png");
                grave.draw();
                lives--;
                Thread.sleep(1500);
                restartLevel();
                grave.delete();
                hp.delete();
                if(lives==2){
                    hp = new Picture(110,490, "2hpleft.png");
                }
                if(lives==1){
                    hp = new Picture(110,490, "1hpleft.png");
                }
                if(lives==0){
                    hp = new Picture(110, 490,"nohpleft.png");
                }
                if (lives != 0) {
                    continue;
                }
            }

            hp.draw();
            while(lives == 0) {
                grave.draw();
                border.draw();
                level3.draw();
                gameOverLet.draw();
                gameOver=true;

            }
            hp.delete();

            gameOverLet.delete();
            grave.delete();
            border.delete();
            level3.delete();

            return;

        }

    }

    public  int getWIDTH(){
        return WIDTH;


    }
    public  int getHEIGHT(){
        return HEIGHT;
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

    public void createRobot(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new Robot((i + 1) * atX, atY, speed) {
            };

        }

    }

    public void createRobotDuck(Obstacles[]track, int speed, int atX, int atY){
        for (int i = 0; i < track.length; i++) {


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
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);
        deleteObstacles(fifthTrack);
        deleteObstacles(sixthTrack);
        deleteObstacles(seventhTrack);
        deleteObstacles(eightTrack);
        border.delete();
        level3.delete();

        dead=false;
    }
    public void restart(){
        lives=3;
    }


    public void deleteLevel() {
        duck.delete();
        deleteObstacles(firstTrack);
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);
        deleteObstacles(fifthTrack);
        deleteObstacles(sixthTrack);
        deleteObstacles(seventhTrack);
        deleteObstacles(eightTrack);

    }

    public void deleteObstacles(Obstacles[]track){
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

    public void createLevel(){
        duck.delete();
        duck = new Duck();
        levelObjective = new Rectangle(10, 10, WIDTH, 30);
        duck.draw();

        createRobot(firstTrack, 15, 100, 400);
        createRobot(secondTrack, 15, 120, 350);
        createRobot(thirdTrack, -15, 100, 300);
        createRobot(fourthTrack, 20, 200, 250);
        createRobot(fifthTrack, -30, 100, 200);
        createRobot(sixthTrack, -30, 70, 130);
        createRobot(seventhTrack, 30, 70, 100);
        createRobot(eightTrack, 30, 100, 50);

        border.draw();
        level3.draw();

    }



}
