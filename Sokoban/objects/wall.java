package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.gObject;
import Sokoban.movingGObject;

public class wall extends movingGObject{

    public wall(int x, int y, JLabel image) {
        super(x, y, image);
    }
    
}
