package Sokoban;

import Sokoban.framework.gObject;
import Sokoban.framework.model;
import Sokoban.objects.*;

/*
 * the model holds the gamelogic
 */
public class SokobanModel extends model {
    private int[][] map;
    private int[][] mapState;
    private player player;
    private boolean state = true;

    public SokobanModel(int[][] map) {
        this.map = map;
    }

    public int[][] getLvl() {
        return map;
    }

    public void setPlayer(player object) {
        if (object instanceof player) {
            this.player = object;
        } else {
            System.out.println("Bad player init");
        }
    }

    public player getPlayer() {
        return player;
    }

    public void printState() {
        for (int y = 0; y<getObjectList()[0].length; y++) {
            for (int x=0; x<getObjectList().length; x++) {
                System.out.print(mapState[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }
    
    @Override
    public boolean stateCheck() {
        int count = 0;
        int width = getObjectList().length;
        int height = getObjectList()[0].length;
        mapState = new int[width][height];
        int x = 0;
        int y = 0;
 
        for (gObject[] row : getObjectList()){
            for (gObject cell : row) { 
                if(cell instanceof blank){
                     mapState[x][y] = 0; 
                }else if(cell instanceof wall){
                     mapState[x][y] = 1;
                }else if (cell instanceof crate) {
                    mapState[x][y] = 2;
                     count++; 
                }else if(cell instanceof blankMarked){
                     mapState[x][y] = 3; 
                }else if(cell instanceof crateMarked){
                     mapState[x][y] = 4; 
                }else if(cell instanceof player){
                    mapState[x][y] = 5;
                }
                y++;
            }  
            y=0;
            x++;
        }

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

}
