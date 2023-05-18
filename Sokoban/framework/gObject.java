package Sokoban.framework;

import javax.swing.JLabel;

/**
 * Abstract implementation of a gObject (game object)
 * @author Fabian Henrysson
 */
public abstract class gObject{
    private int x, y;
    private JLabel image;

    /**
     * Constructor of a game object
     * @param x x cordinate
     * @param y y cordinate
     * @param image image of object as a JLable
     */
    public gObject(int x, int y, JLabel image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    /**
     * X cordinate getter
     * @return x cordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Y cordinate getter
     * @return y cordinate
     */
    public int getY() {
        return y;
    }

    /**
     * X cordinate setter
     * @param x x cordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Y cordinate setter
     * @param y y cordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Setter of the image as JLable
     * @param lable image
     */
    public void setImage(JLabel lable) {
        this.image = lable;
    }

    /**
     * Getter of image as JLable
     * @return image as JLable
     */
    public JLabel getImage() {
        return this.image;
    }

    /**
     * Abstract implementation collision
     * @param object the object which will collide with another object
     * @param direction direction of the object
     * @param objectList game object 2d list
     * @return boolean if it collided
     */
    public abstract boolean collision(gObject object, int direction, gObject[][] objectList);
}
