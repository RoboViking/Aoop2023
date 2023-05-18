package Sokoban.framework;

/**
 * Abstract implementation of a game model
 * @author Fabian Henrysson
 */
public abstract class model{
    private gObject[][] objectList;
    private boolean state = false;

    /**
     * Getter for the 2d game object list
     * @return objectList
     */
    public gObject[][] getObjectList() {
        return objectList;
    }

    /**
     * Setter for the game object list
     * @param x object list width
     * @param y object list height
     */
    public void setObjectListSize(int x, int y) {
        objectList = new gObject[x][y];
    }

    /**
     * Method to add game object to the game object list
     * @param object the game object
     * @param x x cordinate
     * @param y y cordinate
     */
    public void setToMap(gObject object, int x, int y) {
        objectList[x][y] = object;
    }

    /**
     * Getter for object in the game object list
     * @param x x cordinate
     * @param y y cordinate
     * @return the object in the list at x-/y-position
     */
    public gObject getInMap(int x, int y) {
        return objectList[x][y];
    }

    /**
     * Getter for if the game state (is it running or won)
     * @return
     */
    public boolean getState() {
        return state;
    }

    /*
     * Abstract method for state check (if the game is won or running)
     */
    public abstract boolean stateCheck();

}
