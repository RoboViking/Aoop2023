package Sokoban;

import javax.swing.*;
import java.awt.*;
import Sokoban.framework.view;
import Sokoban.objects.blank;
import Sokoban.objects.blankMarked;
import Sokoban.objects.crate;
import Sokoban.objects.crateMarked;
import Sokoban.objects.player;
import Sokoban.objects.wall;

/**
 * Extends the view.
 * Holds the logic for initialising the view and updating logic.
 * @author Fabian Henrysson
 */
public class SokobanView extends view{
    
    private SokobanModel model;
    private JPanel panel;

    /*
     * The maps are stored in a 2d int array
     * 0: blank
     * 1: wall
     * 2: crate
     * 3: blank goal
     * 4: crate marked (a crate that is on a goal)
     * 5: player
     */

    /**
     * Constructor for the initial game panel
     * @param model model
     */
    public SokobanView(SokobanModel model) {
        this.model = model;

        //new
        setHeight(model.getLvl().length);
        setWidth(model.getLvl()[0].length);

        panel = new JPanel(new GridLayout(getHeight(), getWidth()));
        panel.setSize(getHeight() * 32, getWidth() * 32);

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                JLabel tempLable = model.getInMap(x, y).getImage();
                panel.add(tempLable);
            }
        }
    }
    
    /**
     * Getter for the panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Update implementation of the panel
     */
    @Override
    public void update() {
        panel.removeAll();
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                JLabel tempLable = model.getInMap(x, y).getImage();
                panel.add(tempLable);
            }
        }
        panel.revalidate();
        panel.repaint();
    }

}
