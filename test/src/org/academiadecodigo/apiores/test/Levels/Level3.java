package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.Obstacles;
import org.academiadecodigo.apiores.test.Obstacles.Projectile;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level3 extends LevelStructure{

    private final int PADDING = 10;
    private final int WIDTH =  1000 + PADDING;
    private final int HEIGHT =  500 + PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new Projectile[7];
    private Obstacles[] secondTrack = new Projectile[4];
    private Obstacles[] thirdTrack = new Projectile[5];
    private Obstacles[] fourthTrack = new Projectile[4];
    private Obstacles[] fifthTrack = new Projectile[4];
    private Obstacles[] sixthTrack = new Projectile[7];
    private Obstacles[] seventhTrack = new Projectile[7];
    private Obstacles[] eightTrack = new Projectile[7];
    private boolean dead = false;
    private Rectangle levelObjective= new Rectangle(600, 10, 30, 30);
    private Picture gameOverLet;
    private Picture grave;
    private Picture hp = new Picture(110,490, "fullhp.png");
    private Picture border = new Picture(10,10,"border.png");
    private Picture level3 = new Picture(850,483,"lvl3.png");

    public Level3() {

        duck = new Duck();
        gameOverLet = new Picture(385,130,"gameOver.png");

    }

    public void start() throws InterruptedException {
        Picture nasaTexture = new Picture(95, 10, "Nasa_Texture.png");
        nasaTexture.draw();
        while (true) {
            border.delete();
            level3.delete();

            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            if(lives == 3){
                hp.load("fullhp.png");
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
                    border.delete();
                    level3.delete();
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
            nasaTexture.delete();
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


    public void createProjectile(Obstacles[]track, int speed, int atX, int atY){
        if(speed>0) {
            for (int i = 0; i < track.length; i++) {

                track[i] = new Projectile((i + 1) * atX-150, atY, speed);


            }
        }else{
            for (int i = track.length; i > 0; i--) {

                track[i-1] = new Projectile(i  * atX+150, atY, speed);


            }

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

        createProjectile(firstTrack, -15, 100, 403);
        createProjectile(secondTrack, 15, 120, 353);
        createProjectile(thirdTrack, -12, 100, 311);
        createProjectile(fourthTrack, 20, 200, 253);
        createProjectile(fifthTrack, -30, 100, 224);
        createProjectile(sixthTrack, 30, 70, 174);
        createProjectile(seventhTrack, -17, 70, 139);
        createProjectile(eightTrack, 30, 100, 87 );

        border.draw();
        level3.draw();

    }



}
