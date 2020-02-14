package org.academiadecodigo.apiores.test.obstacle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RobotDuck implements Obstacles{


    private int height= 25;
    private int width= 40;
    private Picture obstacle;
    private int speed;




    public RobotDuck(int atX, int atY, int speed){
        obstacle = new Picture(atX-width, atY, "resources/cars/Car1_Resized.png");
        this.speed = speed;
        obstacle.draw();



    }

    public void moveObstacle(){

        obstacle.translate(0,-speed);


        if(obstacle.getY() < 10){

            obstacle.translate(0,400);
        }
        if(obstacle.getY() > 420){
            obstacle.translate(0,-400);
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
