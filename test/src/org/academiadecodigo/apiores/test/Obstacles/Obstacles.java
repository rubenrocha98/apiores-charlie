package org.academiadecodigo.apiores.test.Obstacles;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Obstacles{

    private int height;
    private int width;
    private Rectangle obstacle;
    private int speed;
    private int atX;
    private int atY;

    public abstract void moveObstacle();

    public abstract Rectangle getObstacle();

    public abstract int getWidth();

    public abstract int getHeight();






}
