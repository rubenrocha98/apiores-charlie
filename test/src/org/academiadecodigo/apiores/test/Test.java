package org.academiadecodigo.apiores.test;
import org.academiadecodigo.simplegraphics.graphics.*;



public class Test {
    private final int PADDING = 10;
    private  int cellSize= 20;
    private int  maxCols = 50;
    private  int maxRows = 25;
    private final  int width = cellSize * maxCols + PADDING;
    private final  int height = cellSize * maxRows + PADDING;
    private  Rectangle duck;
    private MoveCars[] firstTrack = new MoveCars[4];
    private MoveCars[] secondTrack = new MoveCars[2];
    private MoveCars[] thirdTrack = new MoveCars[3];

    private boolean dead = false;

    // trying to implement level cleared conditions

    private boolean cleared = false;
    private Rectangle levelObjective;



    public Test() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
        duck = new Rectangle(480, 450, 50, 50);

        // when rectangle and levelObjective share the same position the level clears

        levelObjective = new Rectangle(0, 600, 50, 50);
    }

    public void start() throws InterruptedException {

        while(true) {

            if(cleared){
                break;
            }

            duck.delete();
            levelObjective.delete();
            duck = new Rectangle(480, 450, 50, 50);
            levelObjective = new Rectangle(600, 10, 50, 50);

            KeyListener keyboard = new KeyListener(duck, 20);
            duck.setColor(Color.BLUE);
            duck.fill();

            levelObjective.setColor(Color.ORANGE);
            levelObjective.fill();


            createCars(firstTrack, 15, 200, 140);
            createCars(secondTrack, -20, 500, 260);
            createCars(thirdTrack, 15, 300, 320);

            Rectangle borderLeft = new Rectangle(10, 10, 90, height);
            Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
            borderRight.setColor(Color.BLUE);
            borderLeft.setColor(Color.BLUE);
            borderLeft.fill();
            borderRight.fill();
            while (!dead && !cleared) {
                for (MoveCars car : firstTrack) {
                    car.moveCarLeft();
                    checkDead(car);
                    checkCleared();

                }
                for (MoveCars car : secondTrack) {
                    car.moveCarLeft();
                    checkDead(car);
                    checkCleared();

                }
                for (MoveCars car : thirdTrack) {
                    car.moveCarLeft();
                    checkDead(car);
                    checkCleared();
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



    public void createCars(MoveCars[]track,int speed, int atX,int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new MoveCars((i+1)*atX, atY,speed);

        }

    }


    public void checkDead(MoveCars car){


            for(int j = duck.getX(); j<=duck.getX()+duck.getWidth();j++) {
                for(int k = duck.getY(); k<=duck.getY()+duck.getHeight();k++){

                    if(car.getRectangle().getX() < j &&  car.getRectangle().getX()+car.getWidth() > j &&
                        car.getRectangle().getY() < k && car.getRectangle().getY()+car.getHeight() >k){
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
        levelObjective.delete();

        dead=false;

    }

    public void deleteCars(MoveCars[]track){
        for (int i = 0; i < track.length; i++) {

            track[i].getRectangle().delete();

        }

    }

}
