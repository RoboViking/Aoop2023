package Sokoban;
import javax.swing.JLabel;

import Sokoban.objects.wall;

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
     * Check for collisions of moving objects
     */
    public boolean collision(gObject object, int direction, gObject[][] objectList){
        int y = object.getY();
        int x = object.getX();

        
        switch(direction){
            case collisionLeft:
                gObject oLeft = objectList[x-1][y];
                if(oLeft instanceof wall){
                    return false;
                }
                break;
            case collisionRight:
                gObject oRight = objectList[x+1][y];
                if(oRight instanceof wall){
                    return false;
                }
                break;
            case collisionUp:
                gObject oUp = objectList[x][y-1];
                if(oUp instanceof wall){
                    return false;
                }
                break;
            case collisionDown:
                gObject oDown = objectList[x][y+1];
                if(oDown instanceof wall){
                    return false;
                }
                break;
        }
        return true;
    }

}
