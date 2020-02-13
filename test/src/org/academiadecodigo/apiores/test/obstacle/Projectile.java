package org.academiadecodigo.apiores.test.obstacle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile implements Obstacles{

    private int height= 15;
    private int width= 40;
    private Picture obstacle;
    private int speed;




    public Projectile(int atX, int atY, int speed){
        if(speed>0){
            obstacle = new Picture(atX-width, atY, "projectile/projectile-left.png");
        }else{
            obstacle = new Picture(atX-width,atY, "projectile/projectile.png");
        }

        this.speed = speed;
        obstacle.draw();



    }

    public void moveObstacle(){

        obstacle.translate(-speed,0);


        if(obstacle.getX() < 10){

            obstacle.translate(830,0);
        }
        if(obstacle.getX() > 930){
            obstacle.translate(-780,0);
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
