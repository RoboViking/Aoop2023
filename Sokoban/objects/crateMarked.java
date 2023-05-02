package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.gObject;

public class crateMarked extends gObject{
    private JLabel image;

    public crateMarked(int x, int y) {
        super(x, y);
        image = new JLabel("crateMarked.png");
        setImage(image);
    }
    
}
