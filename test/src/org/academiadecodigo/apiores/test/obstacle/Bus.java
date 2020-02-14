package org.academiadecodigo.apiores.test.obstacle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bus implements Obstacles {


    private int height = 25;
    private int width = 71;
    private Picture obstacle;
    private int speed;



    public Bus(int atX, int atY, int speed) {
        if(speed>0){
            obstacle = new Picture(atX-width,atY, "resources/bus/Bus-left.png");
        }else{
            obstacle = new Picture(atX-width, atY, "resources/bus/Bus.png");
        }
        this.speed = speed;
        obstacle.draw();
    }

    public void moveObstacle() {

        obstacle.translate(-speed, 0);


        if (obstacle.getX() < 10) {


            obstacle.translate(900, 0);
        }
        if (obstacle.getX() > 920) {
            obstacle.translate(-900, 0);
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


