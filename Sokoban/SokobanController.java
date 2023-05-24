package Sokoban;

import java.awt.event.*;
import Sokoban.framework.controller;


/**
 * Controller implementation
 * @author Fabian Henrysson
 */
public class SokobanController extends controller {
    private SokobanModel model;
    private SokobanView view;

    /**
     * Constructor for the controller which extends the controller
     * @param model model
     * @param view  view
     */
    public SokobanController(SokobanModel model, SokobanView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
        //player = model.getPlayer();
    }

    /**
     * keyPress
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                model.move(0, -1, 2);
                break;
            case KeyEvent.VK_DOWN:
                model.move(0, 1, 3);
                break;
            case KeyEvent.VK_LEFT:
                model.move(-1, 0, 0);
                break;
            case KeyEvent.VK_RIGHT:
                model.move(1, 0, 1);
                break;
        }
    }

    /**
     * Empty implementation
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Empty implementation
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}