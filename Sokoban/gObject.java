package Sokoban;
import javax.swing.JLabel;

public abstract class gObject {
    private int x;
    private int y;
    private JLabel image;

    public gObject(int x, int y, JLabel image){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public JLabel getImage(){
        return image;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setImage(JLabel image){
        this.image = image;
    }
}
