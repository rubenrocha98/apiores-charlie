package org.academiadecodigo.apiores.test.levels;


import org.academiadecodigo.apiores.test.duck.DuckSpaceShip;
import org.academiadecodigo.apiores.test.keyboardlisteners.KeyListener;
import org.academiadecodigo.apiores.test.obstacle.Comet;
import org.academiadecodigo.apiores.test.obstacle.Obstacles;
import org.academiadecodigo.apiores.test.sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level4 extends LevelStructure{


    private final int PADDING = 10;
    private final int WIDTH = 1000 + PADDING;
    private final int HEIGHT = 500 + PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new Comet[7];
    private Obstacles[] secondTrack = new Comet[4];
    private Obstacles[] thirdTrack = new Comet[5];
    private Obstacles[] fourthTrack = new Comet[3];
    private Obstacles[] fifthTrack = new Comet[4];
    private Obstacles[] sixthTrack = new Comet[5];
    private Obstacles[] seventhTrack = new Comet[3];
    private Obstacles[] eightTrack = new Comet[3];
    private boolean dead = false;
    private Picture gameOverLet;
    private Picture grave;
    private Picture hp = new Picture(110, 490, "hp/fullhp.png");
    private Picture border = new Picture(10, 10, "backgrounds/border.png");
    private Picture level4 = new Picture(850, 483, "lvls/lvl4.png");
    private Sound quack = new Sound(" resources/Quack Sound Effect  Gutlacky.wav");

    public Level4() {

        duck = new DuckSpaceShip();
        gameOverLet = new Picture(385, 130, "dead/gameOver.png");

    }

    public void start() throws InterruptedException {
        Picture nasaTexture = new Picture(95, 10, "backgrounds/Space_Level.png");
        nasaTexture.draw();
        while (true) {
            border.delete();
            level4.delete();

            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            if (lives == 3) {
                hp.load("hp/fullhp.png");
            }
            if (lives == 2) {
                hp.load("hp/2hpleft.png");
            }
            if (lives == 1) {
                hp.load("hp/1hpleft.png");
            }
            if (lives == 0) {
                hp.load("hp/nohpleft.png");
            }
            hp.delete();
            hp.draw();
            while (!dead) {


                if (checkCleared()) {
                    Thread.sleep(1500);
                    deleteLevel();
                    hp.delete();
                    border.delete();
                    level4.delete();
                    nasaTexture.delete();
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
                grave = new Picture(duck.getX() - 6, duck.getY() - 5, "dead/grave_resized.png");
                grave.draw();
                lives--;
                Thread.sleep(1500);
                restartLevel();
                grave.delete();
                hp.delete();
                if (lives == 2) {
                    hp = new Picture(110, 490, "hp/2hpleft.png");
                }
                if (lives == 1) {
                    hp = new Picture(110, 490, "hp/1hpleft.png");
                }
                if (lives == 0) {
                    hp = new Picture(110, 490, "hp/nohpleft.png");
                }
                if (lives != 0) {
                    continue;
                }
            }

            hp.draw();
            while (lives == 0) {
                grave.draw();
                border.draw();
                level4.draw();
                gameOverLet.draw();
                gameOver = true;

            }
            hp.delete();

            gameOverLet.delete();
            grave.delete();
            border.delete();
            level4.delete();
            nasaTexture.delete();
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


    public void createComet(Obstacles[] track, int speed, int atX, int atY) {
        if (speed > 0) {
            for (int i = 0; i < track.length; i++) {

                track[i] = new Comet((i + 1) * atX - 150, atY, speed);


            }
        } else {
            for (int i = track.length; i > 0; i--) {

                track[i - 1] = new Comet(i * atX + 150, atY, speed);


            }

        }

    }



    public void checkDead(Obstacles obstacle) {


        for (int j = duck.getX(); j <= duck.getX() + duck.getWidth(); j++) {
            for (int k = duck.getY(); k <= duck.getY() + duck.getHeight(); k++) {

                if (obstacle.getObstacle().getX() < j && obstacle.getObstacle().getX() + obstacle.getWidth() > j &&
                        obstacle.getObstacle().getY() < k && obstacle.getObstacle().getY() + obstacle.getHeight() > k) {

                    quack.play(true);
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

    public void restartLevel() {
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
        level4.delete();

        dead = false;
    }

    public void restart() {
        lives = 3;
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

    public void deleteObstacles(Obstacles[] track) {
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

    public void createLevel() {
        duck.delete();
        duck = new DuckSpaceShip();
        duck.draw();
        createComet(firstTrack, -8, 100, 87);
        createComet(secondTrack, 10, 120, 139);
        createComet(thirdTrack, -9, 100, 174);
        createComet(fourthTrack, 15, 200, 210);
        createComet(fifthTrack, -20, 100, 300);
        createComet(sixthTrack, 20, 70, 340);
        createComet(seventhTrack, -17, 70, 360);
        createComet(eightTrack, 30, 100, 40);

        border.draw();
        level4.draw();

    }


}

