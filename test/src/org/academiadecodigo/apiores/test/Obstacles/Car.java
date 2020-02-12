package org.academiadecodigo.apiores.test.Obstacles;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car implements Obstacles{

    private int height= 25;
    private int width= 40;
    private Picture obstacle;
    private int speed;




    public Car(int atX, int atY, int speed){
        if(speed>0){
            obstacle = new Picture(atX-width, atY, "Car2_Resized_Left.png");

        }else {
            obstacle = new Picture(atX-width,atY,"Car1_Resized.png");
        }

        this.speed = speed;
        obstacle.draw();



    }

    public void moveObstacle(){

        obstacle.translate(-speed,0);


        if(obstacle.getX() < 10){

            obstacle.translate(900,0);
        }
        if(obstacle.getX() > 920){
            obstacle.translate(-900,0);
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
