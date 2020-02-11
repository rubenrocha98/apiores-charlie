package org.academiadecodigo.apiores.test.Obstacles;

import org.academiadecodigo.apiores.test.Obstacles.Obstacles;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Car implements Obstacles {

    private int height= 25;
    private int width= 40;
    private Rectangle obstacle;
    private int speed;




    public Car(int atX, int atY, int speed){
        obstacle = new Rectangle(atX-width, atY,width,height);
        this.speed = speed;

        obstacle.fill();
    }

    public void moveObstacle(){

        obstacle.translate(-speed,0);


        if(obstacle.getX() < 10){
            //rectangle.delete();
            //rectangle = new Rectangle(1000-width,250,width,height);
            //rectangle.fill();

            obstacle.translate(900,0);
        }
        if(obstacle.getX() > 920){
            obstacle.translate(-900,0);
        }


    }

    public Rectangle getObstacle() {
        return obstacle;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
