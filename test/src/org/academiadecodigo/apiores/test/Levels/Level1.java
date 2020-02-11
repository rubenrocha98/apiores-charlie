package org.academiadecodigo.apiores.test.Levels;

import org.academiadecodigo.apiores.test.Duck;
import org.academiadecodigo.apiores.test.KeyboardListener.KeyListener;
import org.academiadecodigo.apiores.test.Obstacles.Cars;
import org.academiadecodigo.apiores.test.Obstacles.Obstacles;
import org.academiadecodigo.apiores.test.Obstacles.Robots;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class Level1 extends LevelStructure {

        private final int PADDING = 10;
        private  int cellSize= 20;
        private int  maxCols = 50;
        private  int maxRows = 25;
        private final  int width = cellSize * maxCols + PADDING;
        private final  int height = cellSize * maxRows + PADDING;
        private Rectangle duck;
        private Cars[] firstTrack = new Cars[5];
        private Cars[] secondTrack = new Cars[3];
        private Cars[] thirdTrack = new Cars[5];
        private Cars[] fourthTrack = new Cars[4];

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

                if(cleared){
                    clearLevel();
                    level2.start();
                }

                duck.delete();
                levelObjective.delete();
                duck = new Duck();
                levelObjective = new Rectangle(600, 10, 30, 30);

                KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED


                duck.setColor(Color.BLUE);
                duck.fill();

                levelObjective.setColor(Color.ORANGE);
                levelObjective.fill();


                createCars(firstTrack, 20, 125, 140);
                createCars(secondTrack, -20, 290, 330);
                createCars(thirdTrack, 12, 150, 390);
                createCars(fourthTrack, -20, 245, 200);

                Rectangle borderLeft = new Rectangle(10, 10, 90, height);
                Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
                borderRight.setColor(Color.BLUE);
                borderLeft.setColor(Color.BLUE);
                borderLeft.fill();
                borderRight.fill();
                while (!dead && !cleared) {

                    checkCleared();

                    for (Cars obstacle : firstTrack) {
                        obstacle.moveObstacle();
                        checkDead(obstacle);

                    }
                    for (Cars obstacle : secondTrack) {
                        obstacle.moveObstacle();
                        checkDead(obstacle);

                    }
                    for (Cars obstacle : thirdTrack) {
                        obstacle.moveObstacle();
                        checkDead(obstacle);
                    }

                    for (Cars obstacle : fourthTrack) {
                        obstacle.moveObstacle();
                        checkDead(obstacle);
                    }
                    Thread.sleep(75);


                }

                if(dead){
                    duck.setColor(Color.RED);
                }

                while (dead) {

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



        public void createCars(Cars[]track, int speed, int atX, int atY){
            for (int i = 0; i < track.length; i++) {

                track[i] = new Cars((i+1)*atX, atY,speed);

            }

        }

        public void createObstacles(Buses[]track, int speed, int atX, int atY){

            System.out.println();
        }

        public void createRobots(Robots[]track, int speed, int atX, int atY){

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



}
