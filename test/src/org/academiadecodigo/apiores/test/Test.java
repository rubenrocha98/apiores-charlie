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


    public Test() {
        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(10, 10, width , height);
        canvas.show(rec);

    }

    public void start() throws InterruptedException{


        rectangle = new Rectangle(30, 30, 50, 50);
        keyboard = new KeyListener(rectangle);

        rectangle.fill();
        MoveCars car = createCars();
        while(true){
            car.moveCarTrack();
            Thread.sleep(50);
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

    public MoveCars createCars(){
        return new MoveCars();
    }

}
