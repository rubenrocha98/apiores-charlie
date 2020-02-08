package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MoveCars {

    private int height= 50;
    private int width= 80;
    private Rectangle rectangle;
    private int speed;
    private int atX;
    private int atY;



    public MoveCars(int atX, int atY, int speed){
        rectangle = new Rectangle(atX-width, atY,width,height);
        this.speed = speed;
        this.atX = atX;
        this.atY = atY;
        rectangle.fill();
    }

    public void moveCarLeft(){

        rectangle.translate(-speed,0);


        if(rectangle.getX() < 10){
            //rectangle.delete();
            //rectangle = new Rectangle(1000-width,250,width,height);
            //rectangle.fill();

            rectangle.translate(900,0);
        }
        if(rectangle.getX() > 920){
            rectangle.translate(-920,0);
        }


    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
