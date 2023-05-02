package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.gObject;

public class wall extends gObject{
    private JLabel image;

    public wall(int x, int y) {
        super(x, y);
        image = new JLabel("wall.png");
        setImage(image);
    }
    
}
