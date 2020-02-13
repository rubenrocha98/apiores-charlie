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
    private Canvas canvas = Canvas.getInstance();
    private Shape rec = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);




    public void startMenu(){
        Picture start = new Picture(10,10,"startMenu.png");
        EnterKeyListener enter = new EnterKeyListener(start);

        inMenu=true;

        while(inMenu){

            canvas.show(start);
        }

        canvas.hide(start);
    }

    public static void exitMenu(){
        inMenu=false;
    }

    public static boolean isInMenu(){
        return inMenu;
    }

}