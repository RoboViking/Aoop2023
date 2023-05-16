package Sokoban.objects;

import javax.swing.JLabel;

import Sokoban.framework.gObject;

public class player extends gObject{
    private final int collisionLeft = 0;
    private final int collisionRight = 1;
    private final int collisionUp = 2;
    private final int collisionDown = 3;

    public player(int x, int y, JLabel image) {
        super(x, y, image);
    }
    
    @Override
    public boolean collision(gObject object, int direction, gObject[][] objectList) {
        int y = object.getY();
        int x = object.getX();

        switch (direction) {
            case collisionLeft:
                gObject oLeft = objectList[x - 1][y];
                if (oLeft instanceof wall) {
                    return false;
                }else if(oLeft instanceof crate){
                    return true;
                }else if(oLeft instanceof crateMarked){
                    return true;
                }else if(oLeft instanceof blank){
                    return true;
                }else if(oLeft instanceof blankMarked){
                    return true;
                }
                break;
            case collisionRight:
                gObject oRight = objectList[x + 1][y];
                if (oRight instanceof wall) {
                    return false;
                }else if(oRight instanceof crate){
                    return true;
                }else if(oRight instanceof crateMarked){
                    return true;
                }else if(oRight instanceof blank){
                    return true;
                }else if(oRight instanceof blankMarked){
                    return true;
                }
                break;
            case collisionUp:
                gObject oUp = objectList[x][y - 1];
                if (oUp instanceof wall) {
                    return false;
                }else if(oUp instanceof crate){
                    return true;
                }else if(oUp instanceof crateMarked){
                    return true;
                }else if(oUp instanceof blank){
                    return true;
                }else if(oUp instanceof blankMarked){
                    return true;
                }
                break;
            case collisionDown:
                gObject oDown = objectList[x][y + 1];
                if (oDown instanceof wall) {
                    return false;
                }else if(oDown instanceof crate){
                    return true;
                }else if(oDown instanceof crateMarked){
                    return true;
                }else if(oDown instanceof blank){
                    return true;
                }else if(oDown instanceof blankMarked){
                    return true;
                }
                break;
        }
        return true;
    }
    
}
