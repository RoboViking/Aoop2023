package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

public class crateMarked extends gObject{

    public crateMarked(int x, int y, JLabel image) {
        super(x, y, image);
    }

    @Override
    public boolean collision(gObject object, int direction, gObject[][] objectList) {
        return true;
    }
    
}
