package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.*;
import org.academiadecodigo.simplegraphics.graphics.*;

public class Level1 extends LevelStructure {

        private final int PADDING = 10;
        private  int cellSize= 20;
        private int  maxCols = 50;
        private  int maxRows = 25;
        private final  int width = cellSize * maxCols + PADDING;
        private final  int height = cellSize * maxRows + PADDING;
        private Rectangle duck;
        private Car[] firstTrack = new Car[5];
        private Car[] secondTrack = new Car[3];
        private Car[] thirdTrack = new Car[5];
        private Car[] fourthTrack = new Car[4];

        private LevelStructure level2;

        private boolean dead = false;

        // trying to implement level cleared conditions

        private boolean cleared = false;
        private Rectangle levelObjective;



        public Level1() {

            Canvas canvas = Canvas.getInstance();
            Shape rec = new Rectangle(10, 10, width , height);
            canvas.show(rec);
            duck = new Duck();

            // when rectangle and levelObjective share the same position the level clears

            levelObjective = new Rectangle(600, 10, 30, 30);

        }

        public void start() throws InterruptedException {

            while(true) {
                if(checkCleared()){
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
                    for (Car obstacle : secondTrack) {
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


        public void createObstacles(Obstacles[]track, int speed, int atX, int atY){
            for (int i = 0; i < track.length; i++) {

                track[i] = new Car((i+1)*atX, atY,speed);

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
        public void restart(){
            lives =3;

        }
        public void restartLevel() {


            duck.delete();
            deleteCars(firstTrack);
            deleteCars(secondTrack);
            deleteCars(thirdTrack);
            deleteCars(fourthTrack);
            levelObjective.delete();

            dead=false;

        }


        public void clearLevel(){
            duck.delete();
            deleteCars(firstTrack);
            deleteCars(secondTrack);
            deleteCars(thirdTrack);
            deleteCars(fourthTrack);
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


            createObstacles(firstTrack, 20, 125, 140);
            createObstacles(secondTrack, -20, 290, 330);
            createObstacles(thirdTrack, 12, 150, 390);
            createObstacles(fourthTrack, -20, 245, 200);

            Rectangle borderLeft = new Rectangle(10, 10, 90, height);
            Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
            borderRight.setColor(Color.BLUE);
            borderLeft.setColor(Color.BLUE);
            borderLeft.fill();
            borderRight.fill();

        }



}
