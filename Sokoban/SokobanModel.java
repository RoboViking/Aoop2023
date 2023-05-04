package Sokoban;
import java.util.ArrayList;

/*
 * the model holds the gamelogic
 */
public class SokobanModel{
    private int[][] map;
    private boolean state = false;//int to check if the game is won or not
    //private ArrayList<gObject> objectList = new ArrayList<gObject>(); 
    private gObject[][] objectList;

    public SokobanModel(int[][] map){
        this.map = map;
        this.state = stateCheck();
    }

    public int[][] getMap(){
        return map;
    }

    public boolean getState(){
        return state;
    }

    /*public void addToList(gObject object){
        objectList.add(object);
    }*/

    public void setToObjectMap(gObject object, int x, int y){
        objectList[y][x] = object;

    }

    /* public ArrayList<gObject> getObjectList(){
        return objectList;
    }

    public void setObjectList(ArrayList<gObject> objectList){
        this.objectList = objectList;
    }*/

    public gObject[][] getObjectList(){
        return objectList;
    }

    public void setObjectListSize(int x, int y){
        objectList = new gObject[y][x];
    }


    //checks if the map hold any crates which means that they aren't markedCrates
    boolean stateCheck(){
        int count = 0;
        for(int[] row : map){
            for(int cell : row){
                if(cell == 2){
                    count++;
                }
            }
        }

        if(count>=1){
            return true;
        }else{
            return false;
        }
    }  

}
