package Sokoban;
import Sokoban.framework.view;

/**
 * SokobanTextView which extends view
 * @author Fabian Henrysson
 */
public class SokobanTextView extends view {

    private SokobanModel model;

    /**
     * Constructor for text view
     * @param model sokobanmodel
     */
    public SokobanTextView(SokobanModel model){
        this.model = model;
    }

    /**
     * Print method for the current map state for a view in terminal
     * Used for debugg and more
     */
    public void printCurrentMap() {
        for (int y = 0; y<model.getObjectList()[0].length; y++) {
            for (int x=0; x<model.getObjectList().length; x++) {
                System.out.print(model.getCurrentMap()[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Updator and win state checker for the current map in model
     */
    @Override
    public void update() {
        model.setState(model.stateCheck());
    }
    
}
