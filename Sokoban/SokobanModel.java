package Sokoban;

import Sokoban.framework.gObject;
import Sokoban.framework.model;
import Sokoban.objects.*;

/**
 * SokobanModel which extends model
 * model holds the gamelogic used for the game
 * @author Fabian Henrysson
 */
public class SokobanModel extends model {
    private int[][] map;
    private int[][] mapState;
    private player player;
    private boolean state = true;

    /**
     * Seter the level
     * @param map the map/level to be used
     */
    public SokobanModel(int[][] map) {
        this.map = map;
    }

    /**
     * Getter for the map/level
     * @return map
     */
    public int[][] getLvl() {
        return map;
    }

    /**
     * Setter for the player object to be used in controller etc.
     * @param object player
     */
    public void setPlayer(player object) {
        if (object instanceof player) {
            this.player = object;
        } else {
            System.out.println("Bad player init");
        }
    }

    /**
     * Getter for the player object
     * @return player
     */
    public player getPlayer() {
        return player;
    }

    /**
     * Print method for the current map state in terminal
     * Used for debugg and more
     */
    public void printState() {
        for (int y = 0; y<getObjectList()[0].length; y++) {
            for (int x=0; x<getObjectList().length; x++) {
                System.out.print(mapState[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Setter for the current boolean game state
     * @param state state
     */
    public void setState(boolean state){
        this.state = state;
    }

    /**
     * Getter of the boolean state
     */
    public boolean getState(){
        return state;
    }
    
    /**
     * Implementation of statceCheck which returns if the game is won or still running
     * also writes the current state of the game into a 2d array to be printed in terminal
     */
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
