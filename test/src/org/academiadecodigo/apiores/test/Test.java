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
    private KeyListener keyboard;
    private MoveCars[] firstTrack = new MoveCars[4];
    private MoveCars[] secondTrack = new MoveCars[2];
    private MoveCars[] thirdTrack = new MoveCars[3];
    private boolean dead = false;


    public Test() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);

    }

    public void start() throws InterruptedException{


        rectangle = new Rectangle(470, 450, 50, 50);
        keyboard = new KeyListener(rectangle,20);

        rectangle.fill();


        createCars(firstTrack,15,200,140);
        createCars(secondTrack,-20, 500,260);
        createCars(thirdTrack,15,300,320);

        Rectangle borderLeft = new Rectangle(10,10, 90,height);
        Rectangle borderRight = new Rectangle(width-80,10,90,height);
        borderRight.setColor(Color.BLUE);
        borderLeft.setColor(Color.BLUE);
        borderLeft.fill();
        borderRight.fill();
        while(true){
            for (MoveCars car : firstTrack) {
                car.moveCarLeft();


            }
            for (MoveCars car: secondTrack) {
                car.moveCarLeft();

            }
            for(MoveCars car: thirdTrack){
                car.moveCarLeft();
            }
            Thread.sleep(75);



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


    public boolean checkDead(MoveCars[] track){

            if()
        dead = true;
    }
}
