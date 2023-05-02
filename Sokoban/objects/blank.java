package Sokoban.objects;

import javax.swing.JLabel;
import Sokoban.gObject;

public class blank extends gObject{
    private JLabel image;

    public blank(int x, int y) {
        super(x, y);
        image = new JLabel("blank.png");
        setImage(image);
    }    
}
