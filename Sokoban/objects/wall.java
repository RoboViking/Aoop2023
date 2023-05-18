package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

/**
 * Wall object implementation which extends game object
 * @author Fabian Henrysson
 */
public class wall extends gObject{

    /**
     * Constructor of a wall object
     * @param x x cordinate
     * @param y y cordinate
     * @param image image of the object
     */
    public wall(int x, int y, JLabel image) {
        super(x, y, image);
    }

    /**
     * Collision implementation of a wall object
     */
    @Override
    public boolean collision(gObject object, int direction, gObject[][] objectList) {
        return false;
    }  
}
