package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

public class wall extends gObject{

    public wall(int x, int y, JLabel image) {
        super(x, y, image);
    }

    @Override
    public boolean collision(gObject object, int direction, gObject[][] objectList) {
        return false;
    }  
}
