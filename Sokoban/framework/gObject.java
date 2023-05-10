package Sokoban.framework;

import javax.swing.JLabel;

public abstract class gObject{
    private int x, y;
    private JLabel image;

    public gObject(int x, int y, JLabel image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    /*
     * Getters and setters for x and y position
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
     * Getters and setters for object images
     */
    public void setImage(JLabel lable) {
        this.image = lable;
    }

    public JLabel getImage() {
        return this.image;
    }

    /*
     * Check for collisions of moving objects
     */
    public abstract boolean collision(gObject object, int direction, gObject[][] objectList);
}
