package Sokoban.framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Abstract controller implementation which extends KeyListener
 * @author Fabian Henrysson
 */
public abstract class controller implements KeyListener{

    /**
     * Empty implementation
     */
    @Override
    public void keyPressed(KeyEvent e){
    }

    /**
     * Empty implementation
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Empty implementation
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
