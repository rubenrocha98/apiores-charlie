package org.academiadecodigo.apiores.test;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MoveObstacles {

    private int height= 25;
    private int width= 40;
    private Picture obstacle;
    private int speed;
    private int atX;
    private int atY;



    public MoveObstacles(int atX, int atY, int speed){
        obstacle = new Picture(atX-width, atY, "Car1_Resized.png");
        this.speed = speed;
        this.atX = atX;
        this.atY = atY;
        obstacle.draw();



    }

    public void moveCarLeft(){

        obstacle.translate(-speed,0);


        if(obstacle.getX() < 10){
            //rectangle.delete();
            //rectangle = new Rectangle(1000-width,250,width,height);
            //rectangle.fill();

            obstacle.translate(900,0);
        }
        if(obstacle.getX() > 920){
            obstacle.translate(-920,0);
        }


    }

    public Picture getObstacle() {
        return obstacle;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
