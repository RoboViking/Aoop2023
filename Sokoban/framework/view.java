package Sokoban.framework;

import javax.swing.JFrame;

public abstract class view extends JFrame{

    private int columns, rows;

    public abstract void update();

    public void setWidth(int columns) {
        this.columns=columns;
    }

    public void setHeight(int rows) {
        this.rows=rows;
    }

    public int getWidth() {
        return columns;
    }

    public int getHeight() {
        return rows;
    }
}
