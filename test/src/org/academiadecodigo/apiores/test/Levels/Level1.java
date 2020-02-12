package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.*;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level1 extends LevelStructure {

    private final int PADDING = 10;
    private final int WIDTH =  1000+ PADDING;
    private final int HEIGHT = 500+ PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new Car[5];
    private Obstacles[] secondTrack = new Car[3];
    private Obstacles[] thirdTrack = new Car[5];
    private Obstacles[] fourthTrack = new Car[4];
    private Picture grave;
    private Picture gameOverLet;

    Picture hp = new Picture(110,490, "fullhp.png");

    private boolean dead = false;
    private Rectangle levelObjective;
    Picture border = new Picture(10,10,"border.png");




    public Level1() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, WIDTH, HEIGHT);
        canvas.show(rec);
        Picture textureDesert = new Picture(105, 10, "Texture_Desert.png");
        textureDesert.grow(10,0);
        textureDesert.draw();
        duck = new Duck();
        gameOverLet = new Picture(375,185,"gameover1.png");
        levelObjective = new Rectangle(600, 10, 30, 30);

    }

    public void start() throws InterruptedException {
        gameOver=false;
        border.delete();
        hp.load("fullHp.png");

        while (true) {
            if (checkCleared()) {
                break;
            }
            hp.delete();
            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
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
                Thread.sleep(75);


            }


            if (dead) {
                grave = new Picture(duck.getX() - 6, duck.getY() - 5, "grave_resized.png");
                grave.draw();
                lives--;
                Thread.sleep(1500);
                restartLevel();
                grave.delete();

                if(lives==2){
                    hp.load("2hpleft.png");
                }
                if(lives==1){
                    hp.load("1hpleft.png");
                }
                if(lives==0){
                    hp.load("nohpleft.png");
                }
                if (lives != 0) {
                    continue;
                }
            }

            while(lives == 0) {
                grave.draw();
                gameOverLet.draw();
                gameOver=true;
                border.draw();
                hp.load("fullHp.png");
            }
            border.delete();
            gameOverLet.delete();
            grave.delete();
            hp.delete();

            return;
        }
    }

    public int getWIDTH() {
        return WIDTH;


    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Picture getDuck() {
        return duck;
    }


    public void createObstacles(Obstacles[] track, int speed, int atX, int atY) {
        for (int i = 0; i < track.length; i++) {

            track[i] = new Car((i + 1) * atX, atY, speed);

        }
    }


    public void checkDead(Obstacles obstacle) {


        for (int j = duck.getX(); j <= duck.getX() + duck.getWidth(); j++) {
            for (int k = duck.getY(); k <= duck.getY() + duck.getHeight(); k++) {

                if (obstacle.getObstacle().getX() < j && obstacle.getObstacle().getX() + obstacle.getWidth() > j &&
                        obstacle.getObstacle().getY() < k && obstacle.getObstacle().getY() + obstacle.getHeight() > k) {
                    dead = true;
                }
            }

        }
    }

    public boolean checkCleared() {


        if (duck.getY() == PADDING) {
            return true;
        }


        return false;
    }

    public boolean isDead() {
        return dead;
    }

    public void restart() {
        lives = 3;

    }

    public void restartLevel() {


        duck.delete();
        deleteObstacles(firstTrack);
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);
        border.delete();


        dead = false;

    }


    public void deleteLevel() {
        duck.delete();
        deleteObstacles(firstTrack);
        deleteObstacles(secondTrack);
        deleteObstacles(thirdTrack);
        deleteObstacles(fourthTrack);

    }

    public void deleteObstacles(Obstacles[] track) {
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

    public void createLevel() {
        duck.delete();
        duck = new Duck();
        levelObjective = new Rectangle(10, 10, WIDTH, 30);
        duck.draw();


        createObstacles(firstTrack, 20, 125, 140);
        createObstacles(secondTrack, -20, 290, 330);
        createObstacles(thirdTrack, 12, 150, 390);
        createObstacles(fourthTrack, -20, 245, 200);
        border.draw();
    }

    public void changeLives(){
        if(lives==0){

        }
    }



}
