package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.movingGObject;

public class player extends movingGObject{
    private JLabel image;

    public player(int x, int y) {
        super(x, y);
        image = new JLabel("player.png");
        setImage(image);
    }
    
}
