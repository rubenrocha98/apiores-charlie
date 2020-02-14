package org.academiadecodigo.apiores.test.mainmenu;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.apiores.test.keyboardlisteners.*;


public class MainMenu {
    private final int PADDING = 10;
    private static boolean inMenu;


    public void startMenu(){
        Picture start = new Picture(PADDING,PADDING, "resources/backgrounds/startMenu.png");
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