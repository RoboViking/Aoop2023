package Sokoban.objects;

import javax.swing.JLabel;
import Sokoban.gObject;

public class blankMarked extends gObject{
    private JLabel image;

    public blankMarked(int x, int y) {
        super(x, y);
        image = new JLabel("blankMarked.png");
        setImage(image);
    }
    
}
