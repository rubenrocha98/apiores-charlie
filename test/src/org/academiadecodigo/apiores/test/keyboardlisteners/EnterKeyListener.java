package org.academiadecodigo.apiores.test.keyboardlisteners;

import org.academiadecodigo.apiores.test.mainmenu.MainMenu;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.*;

public class EnterKeyListener implements KeyboardHandler{

    private Movable mov;
    public EnterKeyListener(Movable mov){


        this.mov = mov;

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (MainMenu.isInMenu()) {
                MainMenu.exitMenu();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
