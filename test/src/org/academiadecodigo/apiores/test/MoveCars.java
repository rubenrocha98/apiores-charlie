package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MoveCars {

    private int height= 50;
    private int width= 80;
    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;

    public MoveCars(){
        rectangle = new Rectangle(1000-width, 250,width,height);
        rectangle2 = new Rectangle(1000-width, 250, width, height);
        rectangle3 = new Rectangle(1000-width, 250, width, height);


    }

    public void moveCarTrack(){
        rectangle.fill();
        rectangle.translate(-10,0);
        if(rectangle2.isFilled()){

            rectangle2.translate(-10, 0);
        }

        if(rectangle3.isFilled()){

            rectangle3.translate(-10, 0);
        }

        if(rectangle.getX() == 200){
            rectangle2.fill();
        }

        if(rectangle2.getX() == 200){

            rectangle3.fill();
        }

        if(rectangle.getX() == -20){
            rectangle.delete();
            rectangle = new Rectangle(1000-width,250,width,height);
        }


        if(rectangle2.getX() == -20){
            rectangle2.delete();
            rectangle2 = new Rectangle(1000-width, 250, width, height);
            rectangle2.fill();
        }

        if(rectangle3.getX() == -20){
            rectangle3.delete();
            rectangle3 = new Rectangle(1000-width, 250, width, height);
            rectangle3.fill();
        }


    }
}
