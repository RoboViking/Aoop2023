package Sokoban;
import Sokoban.objects.crate;
import Sokoban.objects.player;
/*
 * the model holds the gamelogic
 */
public class SokobanModel{
    private int[][] map;
    private boolean state = false;//int to check if the game is won or not
    //private ArrayList<gObject> objectList = new ArrayList<gObject>(); 
    private gObject[][] objectList;
    private gObject player;

    public SokobanModel(int[][] map){
        this.map = map;
    }

    public int[][] getLvl(){
        return map;
    }

    public gObject[][] getObjectList(){
        return objectList;
    }

    public void setObjectListSize(int x, int y){
        objectList = new gObject[y][x];
    }

    public void setToMap(gObject object, int x, int y){
        objectList[y][x] = object;

    }

    public gObject getInMap(int x, int y){
        return objectList[y][x];
    }

    public void setPlayer(gObject object){
        if(object instanceof player){
            this.player = object;
        }else{
            System.out.println("Bad player init");
        }
    }

    public gObject getPlayer(){
        return player;
    }

    //checks if the map hold any crates which means that they aren't markedCrates
    public boolean getState(){
        return state;
    }

    boolean stateCheck(){
        int count = 0;
        for(gObject[] row : objectList){
            for(gObject cell : row){
                if(cell instanceof crate){
                    count++;
                }
            }
        }

        System.out.println(player.getX()+", "+player.getY());
        if(count>=1){
            return true;
        }else{
            return false;
        }
    }  

}
