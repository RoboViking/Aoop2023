package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

/**
 * blank object implementation which extends game object(gObject)
 */
public class blank extends gObject{

    /**
     * Constructor of blank object
     * @param x x cordinate
     * @param y y cordinate
     * @param image image of object
     */
    public blank(int x, int y, JLabel image) {
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
