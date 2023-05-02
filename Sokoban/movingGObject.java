package Sokoban;
import javax.swing.JLabel;

public class movingGObject extends gObject{
    private int mx=0;
    private int my=0;
    private JLabel image;

    public movingGObject(int x, int y){
        super(x, y);
    }

    public void setMX(int mx){
        this.mx=mx;
    }

    public void setMY(int my){
        this.my=my;
    }

    public int getMX(){
        return mx;
    }

    public int getMY(){
        return my;
    }

    public void setImage(JLabel image){
        this.image = image;
    }

    public JLabel getImage(){
        return this.image;
    }

    /*
     * check functions for movable objects
     */
    public boolean collisionUp(){
        return false;
    }

    public boolean collisionDown(){
        return false;
    }

    public boolean collisionLeft(){
        return false;
    }

    public boolean collisionRight(){
        return false;
    }

}