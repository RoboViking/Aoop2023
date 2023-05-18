package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

/**
 * blankMarked implementation which extends game object (gObject)
 * @author Fabian Henrysson
 */
public class blankMarked extends gObject{

    /**
     * Constructor of blankMarked space
     * @param x
     * @param y
     * @param image
     */
    public blankMarked(int x, int y, JLabel image) {
        super(x, y, image);
    }

    /**
     * Collision logic implementation
     * @param object the object which moves
     * @param direction the direction of your movement
     * @param objectList object list of the current game state
     */
    @Override
    public boolean collision(gObject object, int direction, gObject[][] objectList) {
        return true;
    }
    
}
