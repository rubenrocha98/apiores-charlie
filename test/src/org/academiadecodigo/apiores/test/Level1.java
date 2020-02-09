package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class Level1 extends LevelDesign {

    private final int PADDING = 10;
    private  int cellSize= 20;
    private int  maxCols = 50;
    private  int maxRows = 25;
    private final  int width = cellSize * maxCols + PADDING;
    private final  int height = cellSize * maxRows + PADDING;
    private Rectangle duck;
    private MoveObstacles[] firstTrack = new MoveObstacles[6];
    private MoveObstacles[] secondTrack = new MoveObstacles[3];
    private MoveObstacles[] thirdTrack = new MoveObstacles[6];
    private MoveObstacles[] fourthTrack = new MoveObstacles[4];

    private boolean dead = false;

    // trying to implement level cleared conditions

    private boolean cleared = false;
    private Rectangle levelObjective;

    public Level1(){
        super();
        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
        duck = new Duck();

        // when rectangle and levelObjective share the same position the level clears

        levelObjective = new Rectangle(600, 10, 25, 25);


    }


    @Override
    public void start() throws InterruptedException {




        while(true) {

            if(cleared){
                break;
            }

            duck.delete();
            levelObjective.delete();
            duck = new Duck();
            levelObjective = new Rectangle(600, 10, 25, 25);

            KeyListener keyboard = new KeyListener(duck, 15);
            duck.setColor(Color.BLUE);
            duck.fill();

            levelObjective.setColor(Color.ORANGE);
            levelObjective.fill();


            createObstacles(firstTrack, 12, 125, 140);
            createObstacles(secondTrack, -20, 300, 330);
            createObstacles(thirdTrack, 12, 150, 390);
            createObstacles(fourthTrack, -30, 250, 200);

            Rectangle borderLeft = new Rectangle(10, 10, 90, height);
            Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
            borderRight.setColor(Color.BLUE);
            borderLeft.setColor(Color.BLUE);
            borderLeft.fill();
            borderRight.fill();
            while (!dead && !cleared) {

                checkCleared();

                for (MoveObstacles obstacle : firstTrack) {
                    obstacle.moveCarLeft();
                    checkDead(obstacle);

                }
                for (MoveObstacles obstacle : secondTrack) {
                    obstacle.moveCarLeft();
                    checkDead(obstacle);

                }
                for (MoveObstacles obstacle : thirdTrack) {
                    obstacle.moveCarLeft();
                    checkDead(obstacle);
                }

                for (MoveObstacles obstacle : fourthTrack) {
                    obstacle.moveCarLeft();
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




    @Override
    public void restart() {


        duck.delete();
        deleteCars(firstTrack);
        deleteCars(secondTrack);
        deleteCars(thirdTrack);
        deleteCars(fourthTrack);
        levelObjective.delete();

        dead=false;

    }

}
