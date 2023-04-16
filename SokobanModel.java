/*
 * the model holds the gamelogic
 */
public class SokobanModel {
    private int[][] map;
    private boolean state = false;//int to check if the game is won or not

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

    //checks if the map hold any crates which means that they aren't markedCrates
    private boolean stateCheck(){
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
