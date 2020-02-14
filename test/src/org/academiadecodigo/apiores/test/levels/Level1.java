package org.academiadecodigo.apiores.test.levels;

import org.academiadecodigo.apiores.test.duck.Duck;
import org.academiadecodigo.apiores.test.keyboardlisteners.KeyListener;
import org.academiadecodigo.apiores.test.obstacle.*;
import org.academiadecodigo.apiores.test.sound.Sound;
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

    private Picture hp = new Picture(110,487, "hp/fullhp.png");

    private boolean dead = false;
    private Picture border = new Picture(10,10, "backgrounds/border.png");
    private Picture level = new Picture(850,483, "lvls/lvl1.png");
    private Picture textureDesert = new Picture(100, 10, "backgrounds/Desert_Texture.png");
    private Sound quack = new Sound(" resources/Quack Sound Effect  Gutlacky.wav");




    public Level1() {
        duck = new Duck();
        gameOverLet = new Picture(385,130, "dead/gameOver.png");
    }




    public void start() throws InterruptedException {
        gameOver=false;
        textureDesert.draw();
        border.delete();
        level.delete();
        hp.load("hp/fullhp.png");


        while (true) {
            hp.delete();
            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            hp.draw();
            while (!dead) {


                if (checkCleared()) {
                    duck.delete();
                    Thread.sleep(1500);
                    deleteLevel();
                    hp.delete();
                    border.delete();
                    level.delete();
                    textureDesert.delete();

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
                grave = new Picture(duck.getX() - 6, duck.getY() - 5, "dead/grave_resized.png");
                grave.draw();
                lives--;
                Thread.sleep(1500);
                restartLevel();
                grave.delete();

                if(lives==2){
                    hp.load("hp/2hpleft.png");
                }
                if(lives==1){
                    hp.load("hp/1hpleft.png");
                }
                if(lives==0){
                    hp.load("hp/nohpleft.png");
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
                level.draw();
                hp.load("hp/fullhp.png");
            }

            border.delete();
            level.delete();
            gameOverLet.delete();
            grave.delete();
            hp.delete();
            textureDesert.delete();
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


    public void createCars(Obstacles[] track, int speed, int atX, int atY) {
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
                    quack.play(true);
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
        level.delete();


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
        duck.draw();


        createCars(firstTrack, 13, 160, 140);
        createCars(secondTrack, -18, 290, 330);
        createCars(thirdTrack, 12, 150, 380);
        createCars(fourthTrack, -17, 245, 190);
        border.draw();
        level.draw();
    }




}
