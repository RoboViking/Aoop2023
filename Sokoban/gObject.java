package Sokoban;
import javax.swing.JLabel;

public abstract class gObject {
    private int x, y;
    private JLabel image;

    public gObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setImage(JLabel lable){
        this.image = lable;
    }

    public JLabel getImage(){
        return this.image;
    }

 
}
