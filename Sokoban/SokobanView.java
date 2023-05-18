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
        
        setHeight(model.getLvl().length);
        setWidth(model.getLvl()[0].length);
        model.setObjectListSize(getWidth(), getHeight());

        panel = new JPanel(new GridLayout(getHeight(), getWidth()));
        panel.setSize(getHeight() * 32, getWidth() * 32);

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {

                JLabel tempLable = new JLabel();

                switch (model.getLvl()[y][x]) {
                    case 0:
                        ImageIcon blankImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        tempLable.setIcon(blankImage);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        break;
                    case 1:
                        ImageIcon wallImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/wall.png");
                        tempLable.setIcon(wallImage);
                        model.setToMap(new wall(x, y, new JLabel(wallImage)), x, y);
                        break;
                    case 2:
                        ImageIcon crateImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png");
                        tempLable.setIcon(crateImage);
                        model.setToMap(new crate(x, y, new JLabel(crateImage)), x, y);
                        break;
                    case 3:
                        ImageIcon blankMarkedImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png");
                        tempLable.setIcon(blankMarkedImage);
                        model.setToMap(new blankMarked(x, y, new JLabel(blankMarkedImage)), x, y);
                        break;
                    case 4:
                        ImageIcon crateMarkedImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png");
                        tempLable.setIcon(crateMarkedImage);
                        model.setToMap(new crateMarked(x, y, new JLabel(crateMarkedImage)), x, y);
                        break;
                    case 5:
                        ImageIcon playerImage = new ImageIcon(
                                "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/player.png");
                        tempLable.setIcon(playerImage);

                        player player = new player(x, y, new JLabel(playerImage));
                        model.setToMap(player, x, y);
                        model.setPlayer(player);
                        break;
                }
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
