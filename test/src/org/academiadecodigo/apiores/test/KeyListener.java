package org.academiadecodigo.apiores.test;


import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyListener implements KeyboardHandler {

    private Movable movable;


    public KeyListener(Movable movable){


        this.movable = movable;


        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upArrow.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(upArrow);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(downArrow);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftArrow);

        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightArrow);




    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {




        switch (keyboardEvent.getKey()) {


            case KeyboardEvent.KEY_UP:

                if(Main.test.getRectangle().getY() ==10 ){
                    return;
                }
                movable.translate(0, -10);
                break;

            case KeyboardEvent.KEY_DOWN:

                if(Main.test.getRectangle().getY() == Main.test.getHeight()- Main.test.getRectangle().getHeight()+10){
                    return;
                }
                movable.translate(0, 10);
                break;

            case KeyboardEvent.KEY_RIGHT:

                if(Main.test.getRectangle().getX() == Main.test.getWidth()-Main.test.getRectangle().getWidth()+10){
                    return;
                }
                movable.translate(10, 0);
                break;

            case KeyboardEvent.KEY_LEFT:

                if(Main.test.getRectangle().getX() == 10){
                    return;
                }
                movable.translate(-10, 0);
                break;




        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {



    }



}




