package org.academiadecodigo.apiores.test;


import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyListener implements KeyboardHandler {

    private Movable movable;
    private int speed;

    public KeyListener(Movable movable,int speed){

        this.speed = speed;
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

        KeyboardEvent rKey = new KeyboardEvent();
        rKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rKey.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(rKey);




    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {




        if(Main.test.isDead()){
            return;
        }
        switch (keyboardEvent.getKey()) {


            case KeyboardEvent.KEY_UP:

                if(Main.test.getDuck().getY() ==10 ){
                    return;
                }
                movable.translate(0, -speed);
                break;

            case KeyboardEvent.KEY_DOWN:

                if(Main.test.getDuck().getY() == Main.test.getHeight()- Main.test.getDuck().getHeight()+10){
                    return;
                }
                movable.translate(0, speed);
                break;

            case KeyboardEvent.KEY_RIGHT:

                if(Main.test.getDuck().getX() == Main.test.getWidth()-Main.test.getDuck().getWidth()-80){
                    return;
                }
                movable.translate(speed, 0);
                break;

            case KeyboardEvent.KEY_LEFT:

                if(Main.test.getDuck().getX() == 100){
                    return;
                }
                movable.translate(-speed, 0);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_R:
                if(Main.test.isDead()){
                    Main.test.restart();
                }
        }

    }



}




