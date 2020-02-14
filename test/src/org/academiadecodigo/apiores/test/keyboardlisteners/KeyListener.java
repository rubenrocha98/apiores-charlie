package org.academiadecodigo.apiores.test.keyboardlisteners;


import org.academiadecodigo.apiores.test.levels.*;
import org.academiadecodigo.apiores.test.Game;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyListener implements KeyboardHandler {

    private Movable movable;
    private int speed;
    private boolean stepIsEven;



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




        if(Game.getCurrentLevel().isDead()){
            return;
        }
        switch (keyboardEvent.getKey()) {


            case KeyboardEvent.KEY_UP:
                if(Game.getCurrentLevel() instanceof Level2) {
                    if (Game.getCurrentLevel().getDuck().getY() - speed < 40) {
                        return;
                    }

                }else if(Game.getCurrentLevel() instanceof Level3){
                    if(Game.getCurrentLevel().getDuck().getY()-speed<40){
                        return;
                    }

                }else if (Game.getCurrentLevel().getDuck().getY() - speed < 10) {
                    return;
                }
                movable.translate(0, -speed);
                stepIsEven ^= true;
                if (Game.getCurrentLevel() instanceof Level4) {

                } else {
                    if (stepIsEven) {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck1.png");
                    } else {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck3.png");
                    }
                }

                break;

            case KeyboardEvent.KEY_DOWN:

                if (Game.getCurrentLevel().getDuck().getY() + speed + 50 > Game.getCurrentLevel().getHEIGHT() -
                        Game.getCurrentLevel().getDuck().getHeight() + 10) {
                    return;
                }
                movable.translate(0, speed);
                stepIsEven ^= true;

                if (Game.getCurrentLevel() instanceof Level4) {

                } else {
                    if (stepIsEven) {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck10.png");
                    } else {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck12.png");
                    }
                }
                break;
            case KeyboardEvent.KEY_RIGHT:

                if (Game.getCurrentLevel().getDuck().getX() + speed >
                        Game.getCurrentLevel().getWIDTH() - Game.getCurrentLevel().getDuck().getWidth() - 80) {
                    return;
                }

                movable.translate(speed, 0);
                if (Game.getCurrentLevel() instanceof Level4) {

                } else {
                    stepIsEven ^= true;
                    if (stepIsEven) {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck4.png");
                    } else {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck6.png");
                    }

                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (Game.getCurrentLevel().getDuck().getX() - speed < 100) {
                    return;
                }

                movable.translate(-speed, 0);
                stepIsEven ^= true;
                if (Game.getCurrentLevel() instanceof Level4) {

                } else {
                    if (stepIsEven) {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck7.png");
                    } else {
                        Game.getCurrentLevel().getDuck().load("resources/duck/Duck9.png");
                    }


                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_R:
                if(LevelStructure.getLives()==0){
                    Game.getCurrentLevel().restart();
                }
        }

    }



}




