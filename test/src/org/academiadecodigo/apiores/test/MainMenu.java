package org.academiadecodigo.apiores.test;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.apiores.test.KeyboardListener.*;
import org.academiadecodigo.apiores.test.Obstacles.*;

public class MainMenu {
    private final int PADDING = 10;
    private final int WIDTH = 1000 + PADDING;
    private final int HEIGHT = 500 + PADDING;
    private static boolean inMenu;

    public MainMenu() {

        Canvas canvas = Canvas.getInstance();
        Shape rec = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        canvas.show(rec);


    }


    public void startMenu(){
        Picture start = new Picture(361,210,"start.png");
        EnterKeyListener enter = new EnterKeyListener(start);
        inMenu=true;
        while(inMenu){

            start.draw();

        }
        start.delete();
    }

    public static void exitMenu(){
        inMenu=false;
    }

    public static boolean isInMenu(){
        return inMenu;
    }

}