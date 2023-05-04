package Sokoban;
import javax.swing.JLabel;

public abstract class movingGObject extends gObject{
    private int mx=0, my=0;
    private final int collisionLeft = 0;
    private final int collisionRight = 1;
    private final int collisionUp = 2;
    private final int collisionDown = 3;

    public movingGObject(int x, int y, JLabel image){
        super(x, y, image);
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

    public void moveUp(){
        setMY(getMY()+1);
    }

    public void moveDown(){
        setMY(getMY()-1);
    }

    public void moveLeft(){
        setMX(getMX()-1);
    }

    public void moveRight(){
        setMX(getMX()+1);
    }

    /*
     * check functions for movable objects
     */
     public boolean wallCollision(movingGObject object,int direction){
        switch(direction){
            case collisionLeft:

                break;
            case collisionRight:

                break;
            case collisionUp:

                break;
            case collisionDown:

                break;
        }
        return false;
    }

    public boolean crateCollision(movingGObject object, int direction){
        switch(direction){
            case collisionLeft:

                break;
            case collisionRight:

                break;
            case collisionUp:

                break;
            case collisionDown:

                break;
        }
        return false;
    }

 

}