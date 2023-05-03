package Sokoban;
import javax.swing.JLabel;

public abstract class gObject {
    private int x, y;
    private JLabel image;
    private final int collisionLeft = 0;
    private final int collisionRight = 1;
    private final int collisionUp = 2;
    private final int collisionDown = 3;

    public gObject(int x, int y, JLabel image){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    /*
     * Getters and setters for x and y position
     */
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

    /*
     * Getters and setters for object images
     */
    public void setImage(JLabel lable){
        this.image = lable;
    }

    public JLabel getImage(){
        return this.image;
    }

    /*
     * Checkers for collisions of moving objects
     */
    public boolean leftCollision(gObject object){
        
        return false;
    }

    public boolean rightCollision(gObject object){
        return false;
    }

    public boolean upCollision(gObject object){
        return false;
    }

    public boolean downCollision(gObject object){
        return false;
    }

 
}
