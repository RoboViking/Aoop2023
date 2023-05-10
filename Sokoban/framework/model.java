package Sokoban.framework;

public abstract class model{
    private gObject[][] objectList;
    private boolean state = false;

    public gObject[][] getObjectList() {
        return objectList;
    }

    public void setObjectListSize(int x, int y) {
        objectList = new gObject[x][y];
    }

    public void setToMap(gObject object, int x, int y) {
        objectList[x][y] = object;
    }

    public gObject getInMap(int x, int y) {
        return objectList[x][y];
    }

    public boolean getState() {
        return state;
    }

    /*
     * State check for if the game is won
     */
    public abstract boolean stateCheck();

}
