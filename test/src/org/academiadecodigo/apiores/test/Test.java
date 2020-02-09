package org.academiadecodigo.apiores.test;
import org.academiadecodigo.simplegraphics.graphics.*;



public class Test {
    private final int PADDING = 10;
    private  int cellSize= 20;
    private int  maxCols = 50;
    private  int maxRows = 25;
    private final  int width = cellSize * maxCols + PADDING;
    private final  int height = cellSize * maxRows + PADDING;
    private Rectangle duck;
    private MoveObstacles[] firstTrack = new MoveObstacles[5];
    private MoveObstacles[] secondTrack = new MoveObstacles[3];
    private MoveObstacles[] thirdTrack = new MoveObstacles[5];
    private MoveObstacles[] fourthTrack = new MoveObstacles[4];

    private boolean dead = false;

    // trying to implement level cleared conditions

    private boolean cleared = false;
    private Rectangle levelObjective;



    public Test() {

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

            duck.delete();
            levelObjective.delete();
            duck = new Duck();
            levelObjective = new Rectangle(600, 10, 30, 30);

            KeyListener keyboard = new KeyListener(duck, 10);  // NÃO MEXER NA SPEED


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
    public  int getWidth(){
        return width;


    }
    public  int getHeight(){
        return height;
    }

    public  Rectangle getDuck(){
        return duck;
    }



    public void createObstacles(MoveObstacles[]track,int speed, int atX,int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new MoveObstacles((i+1)*atX, atY,speed);

        }

    }


    public void checkDead(MoveObstacles car){


            for(int j = duck.getX(); j<=duck.getX()+duck.getWidth();j++) {
                for(int k = duck.getY(); k<=duck.getY()+duck.getHeight();k++){

                    if(car.getObstacle().getX() < j &&  car.getObstacle().getX()+car.getWidth() > j &&
                        car.getObstacle().getY() < k && car.getObstacle().getY()+car.getHeight() >k){
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

    public void deleteCars(MoveObstacles []track){
        for (int i = 0; i < track.length; i++) {

            track[i].getObstacle().delete();

        }

    }

}
