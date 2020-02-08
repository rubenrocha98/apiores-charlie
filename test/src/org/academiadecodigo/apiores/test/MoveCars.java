package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MoveCars {

    private int height= 50;
    private int width= 80;
    private Rectangle rectangle;
    public MoveCars(){
        rectangle = new Rectangle(1000-width, 250,width,height);




    }

    public void moveCarLeft(){
        rectangle.fill();
        rectangle.translate(-10,0);

        if(rectangle.getX()== -20){
            rectangle.delete();
            rectangle = new Rectangle(1000-width,250,width,height);
        }
    }
}
