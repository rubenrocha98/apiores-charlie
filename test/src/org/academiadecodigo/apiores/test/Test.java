package org.academiadecodigo.apiores.test;
import org.academiadecodigo.simplegraphics.graphics.*;



public class Test {
    private final int PADDING = 10;
    private  int cellSize= 20;
    private int  maxCols = 50;
    private  int maxRows = 25;
    private final  int width = cellSize * maxCols + PADDING;
    private final  int height = cellSize * maxRows + PADDING;
    private  Rectangle rectangle;
    private MoveCars[] firstTrack = new MoveCars[4];
    private MoveCars[] secondTrack = new MoveCars[2];
    private MoveCars[] thirdTrack = new MoveCars[3];

    private boolean dead = false;


    public Test() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);
        rectangle = new Rectangle(480, 450, 50, 50);
    }

    public void start() throws InterruptedException {

        while(true) {
            rectangle.delete();
            rectangle = new Rectangle(480, 450, 50, 50);

            KeyListener keyboard = new KeyListener(rectangle, 20);
            rectangle.setColor(Color.BLUE);
            rectangle.fill();


            createCars(firstTrack, 15, 200, 140);
            createCars(secondTrack, -20, 500, 260);
            createCars(thirdTrack, 15, 300, 320);

            Rectangle borderLeft = new Rectangle(10, 10, 90, height);
            Rectangle borderRight = new Rectangle(width - 80, 10, 90, height);
            borderRight.setColor(Color.BLUE);
            borderLeft.setColor(Color.BLUE);
            borderLeft.fill();
            borderRight.fill();
            while (!dead) {
                for (MoveCars car : firstTrack) {
                    car.moveCarLeft();
                    checkDead(car);

                }
                for (MoveCars car : secondTrack) {
                    car.moveCarLeft();
                    checkDead(car);

                }
                for (MoveCars car : thirdTrack) {
                    car.moveCarLeft();
                    checkDead(car);
                }
                Thread.sleep(75);


            }
            rectangle.setColor(Color.RED);

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

    public  Rectangle getRectangle(){
        return rectangle;
    }



    public void createCars(MoveCars[]track,int speed, int atX,int atY){
        for (int i = 0; i < track.length; i++) {

            track[i] = new MoveCars((i+1)*atX, atY,speed);

        }

    }


    public void checkDead(MoveCars car){


            for(int j = rectangle.getX(); j<=rectangle.getX()+rectangle.getWidth();j++) {
                for(int k = rectangle.getY(); k<=rectangle.getY()+rectangle.getHeight();k++){

                    if(car.getRectangle().getX() < j &&  car.getRectangle().getX()+car.getWidth() > j &&
                        car.getRectangle().getY() < k && car.getRectangle().getY()+car.getHeight() >k){
                        dead = true;
                    }
                }

        }
    }

    public boolean isDead() {
        return dead;
    }

    public void restart() {


        rectangle.delete();
        deleteCars(firstTrack);
        deleteCars(secondTrack);
        deleteCars(thirdTrack);
        dead=false;

    }

    public void deleteCars(MoveCars[]track){
        for (int i = 0; i < track.length; i++) {

            track[i].getRectangle().delete();

        }

    }

}
