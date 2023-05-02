package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.movingGObject;

public class crate extends movingGObject{
    private JLabel image;

    public crate(int x, int y) {
        super(x, y);
        image = new JLabel("crate.png");
        setImage(image);
    }
    
}
