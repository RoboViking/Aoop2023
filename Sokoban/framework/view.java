package Sokoban.framework;

import javax.swing.JFrame;
/**
 * Abstract view with general methods for tile game creation
 */
public abstract class view extends JFrame{

    private int columns, rows;
    /**
     * General update method
     */
    public abstract void update();

    /**
     * Setter for tile game width
     * @param columns columns
     */
    public void setWidth(int columns) {
        this.columns=columns;
    }

    /**
     * Setter of game height
     * @param rows rows
     */
    public void setHeight(int rows) {
        this.rows=rows;
    }

    /**
     * Getter of game width
     * @return columns
     */
    public int getWidth() {
        return columns;
    }

    /**
     * Getter for game height
     * @return rows
     */
    public int getHeight() {
        return rows;
    }
}
