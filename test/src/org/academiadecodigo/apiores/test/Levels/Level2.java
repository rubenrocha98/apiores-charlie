package org.academiadecodigo.apiores.test.Levels;


import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.*;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level2 extends LevelStructure {

    private final int PADDING = 10;
    private final  int WIDTH =  1000+ PADDING;
    private final  int HEIGHT =  500+ PADDING;
    private Picture duck;
    private Obstacles[] firstTrack = new Car[5];
    private Obstacles[] secondTrack = new Bus[3];
    private Obstacles[] thirdTrack = new Car[5];
    private Obstacles[] fourthTrack = new Car[4];
    private Obstacles[] fifthTrack = new Car[4];
    private Obstacles[] sixthTrack = new Car[4];

    private boolean dead = false;
    private Rectangle levelObjective = new Rectangle(600, 10, 30, 30);
    private Picture gameOverLet;
    private Picture grave;
    private Picture hp = new Picture(110,490,"fullHp.png");
    Picture border = new Picture(10,10,"border.png");
    Picture level2 = new Picture(850,483,"lvl2.png");

    public Level2() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, WIDTH, HEIGHT);
        canvas.show(rec);
        Picture textureDesert = new Picture(105, 20, "Texture_Desert.png");
        textureDesert.draw();
        duck = new Duck();
        gameOverLet = new Picture(425,197,"gameover1.png");

        // when rectangle and levelObjective share the same position the level clears


    }

    public void start() throws InterruptedException {
        while(true) {
            border.delete();
            level2.delete();


            hp.delete();
            createLevel();
            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED
            if(lives==3){
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


                    if(checkCleared()){
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
                for (Obstacles obstacle: fourthTrack){
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
                level2.draw();

            }

            hp.delete();
            gameOverLet.delete();
            grave.delete();
            border.delete();
            level2.delete();

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
        border.delete();
        level2.delete();
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


        createCars(firstTrack, 12, 145, 400);
        createBuses(secondTrack, 17, 250, 350);
        createCars(thirdTrack, -15, 150, 220);
        createCars(fourthTrack,15,145,270);
        createCars(fifthTrack, 14, 145, 150);
        createCars(sixthTrack, -12, 115, 100);
        border.draw();
        level2.draw();


    }



}
