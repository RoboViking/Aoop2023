package Sokoban;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Sokoban.framework.controller;
import Sokoban.framework.gObject;
import Sokoban.objects.*;


/**
 * Controller implementation
 * @author Fabian Henrysson
 */
public class SokobanController extends controller {
    private SokobanModel model;
    private SokobanView view;
    private gObject player;
    private gObject preObject;

    private int y;
    private int x;

    ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
    ImageIcon blankMarkedImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png");
    ImageIcon crateImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png");
    ImageIcon crateMarkedImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png");

    /**
     * Constructor for the controller which extends the controller
     * @param model model
     * @param view view
     */
    public SokobanController(SokobanModel model, SokobanView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
        player = model.getPlayer();
    }

    /**
     * Method that is used to remember the object which the player stands upon
     * @param preObject the previous object
    */
    public void setPreObject(gObject preObject) {
        this.preObject = preObject;
    }

    /**
     * Getter for the previous object
     * @return preObject
     */
    public gObject getPreObject() {
        return preObject;
    }

    /**
     * Method to add a ground object at the spot which you are moving away from
     * unless the previous object was a marked ground object (blankMarked)
     */
    public void blankPrint() {

        if (!(getPreObject() instanceof blankMarked)) {
            model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
        }
    }

    /**
     * Method used for standard movement logic
     * @param preObject previous object
     * @param xMove movement change in x direction
     * @param yMove movement change in y direction
     */
    public void stdMove(gObject preObject, int xMove, int yMove) {
        player.setX(player.getX() + xMove);
        player.setY(player.getY() + yMove);
        blankPrint();
        model.setToMap(player, player.getX(), player.getY());
        setPreObject(preObject);
    }

    /**
     * Keypresses logic which changes the gObject 2d array based on keypress,
     * calls collision logic,
     * calls for game state logic and prints the new state in the terminal.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        y = model.getPlayer().getY();
        x = model.getPlayer().getX();

        switch (key) {
            case KeyEvent.VK_UP:
                if (y > 0 && player.collision(player, 2, model.getObjectList())) {

                    gObject upO = model.getInMap(player.getX(), player.getY() - 1);

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    if (upO instanceof blank || upO instanceof blankMarked) {
                        stdMove(upO, 0, -1);
                    }

                    if (upO instanceof crate && upO.collision(upO, 2, model.getObjectList())) {

                        gObject uptwoO = model.getInMap(upO.getX(), upO.getY() - 1);

                        if (uptwoO instanceof blankMarked) {
                            model.setToMap(
                                    new crateMarked(uptwoO.getX(), uptwoO.getY(), new JLabel(crateMarkedImage)),
                                    uptwoO.getX(), uptwoO.getY());
                            stdMove(upO, 0, -1);
                        } else if (uptwoO instanceof crate) {
                        } else {
                            upO.setY(upO.getY() - 1);
                            model.setToMap(upO, upO.getX(), upO.getY());
                            stdMove(upO, 0, -1);
                        }

                    }

                    if (upO instanceof crateMarked && upO.collision(upO, 2, model.getObjectList())) {

                        upO.setY(upO.getY() - 1);
                        model.setToMap(
                                new crate(upO.getX(), upO.getY(), new JLabel(crateImage)),
                                upO.getX(), upO.getY());

                        player.setY(player.getY() - 1);
                        blankPrint();
                        model.setToMap(player, player.getX(), player.getY());
                        setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                    }

                }
                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_DOWN:
                if (y <= view.getHeight() && player.collision(player, 3, model.getObjectList())) {

                    gObject downO = model.getInMap(player.getX(), player.getY() + 1);

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    if (downO instanceof blank || downO instanceof blankMarked) {
                        stdMove(downO, 0, 1);
                    }

                    if (downO instanceof crate && downO.collision(downO, 3, model.getObjectList())) {
                        gObject downtwoO = model.getInMap(downO.getX(), downO.getY() + 1);
                        if (downtwoO instanceof blankMarked) {
                            model.setToMap(
                                    new crateMarked(downtwoO.getX(), downtwoO.getY(), new JLabel(crateMarkedImage)),
                                    downtwoO.getX(), downtwoO.getY());
                            stdMove(downO, 0, 1);
                        } else if (downtwoO instanceof crate) {

                        } else {
                            downO.setY(downO.getY() + 1);
                            model.setToMap(downO, downO.getX(), downO.getY());
                            stdMove(downO, 0, 1);
                        }

                    }

                    if (downO instanceof crateMarked && downO.collision(downO, 3, model.getObjectList())) {

                        downO.setY(downO.getY() + 1);
                        model.setToMap(
                                new crate(downO.getX(), downO.getY(), new JLabel(crateImage)),
                                downO.getX(), downO.getY());
                        player.setY(player.getY() + 1);
                        blankPrint();
                        model.setToMap(player, player.getX(), player.getY());

                        setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                    }

                }

                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0 && player.collision(player, 0, model.getObjectList())) {

                    gObject leftO = model.getInMap(player.getX() - 1, player.getY());

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    if (leftO instanceof blank || leftO instanceof blankMarked) {
                        stdMove(leftO, -1, 0);
                    }

                    if (leftO instanceof crate && leftO.collision(leftO, 0, model.getObjectList())) {
                        gObject lefttwoO = model.getInMap(leftO.getX() - 1, leftO.getY());

                        if (lefttwoO instanceof blankMarked) {
                            model.setToMap(
                                    new crateMarked(lefttwoO.getX(), lefttwoO.getY(), new JLabel(crateMarkedImage)),
                                    lefttwoO.getX(), lefttwoO.getY());
                            stdMove(leftO, -1, 0);
                        } else if (lefttwoO instanceof crate) {

                        } else {
                            leftO.setX(leftO.getX() - 1);
                            model.setToMap(leftO, leftO.getX(), leftO.getY());
                            stdMove(leftO, -1, 0);
                        }

                    }

                    if (leftO instanceof crateMarked && leftO.collision(leftO, 0, model.getObjectList())) {

                        leftO.setX(leftO.getX() - 1);
                        model.setToMap(
                                new crate(leftO.getX(), leftO.getY(), new JLabel(crateImage)),
                                leftO.getX(), leftO.getY());
                        player.setX(player.getX() - 1);
                        blankPrint();
                        model.setToMap(player, player.getX(), player.getY());

                        setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                    }

                }
                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_RIGHT:
                if (x <= view.getWidth() && player.collision(player, 1, model.getObjectList())) {

                    gObject rightO = model.getInMap(player.getX() + 1, player.getY());

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    if (rightO instanceof blank || rightO instanceof blankMarked) {
                        stdMove(rightO, 1, 0);
                    }

                    if (rightO instanceof crate && rightO.collision(rightO, 1, model.getObjectList())) {

                        gObject righttwoO = model.getInMap(rightO.getX() + 1, rightO.getY());

                        if (righttwoO instanceof blankMarked) {
                            model.setToMap(
                                    new crateMarked(righttwoO.getX(), righttwoO.getY(), new JLabel(crateMarkedImage)),
                                    righttwoO.getX(), righttwoO.getY());
                            stdMove(rightO, 1, 0);

                        } else if (righttwoO instanceof crate) {

                        } else {
                            rightO.setX(rightO.getX() + 1);
                            model.setToMap(rightO, rightO.getX(), rightO.getY());
                            stdMove(rightO, 1, 0);
                        }

                    }

                    if (rightO instanceof crateMarked && rightO.collision(rightO, 1, model.getObjectList())) {

                        rightO.setX(rightO.getX() + 1);
                        model.setToMap(
                                new crate(rightO.getX(), rightO.getY(), new JLabel(crateImage)),
                                rightO.getX(), rightO.getY());
                        player.setX(player.getX() + 1);
                        blankPrint();
                        model.setToMap(player, player.getX(), player.getY());

                        setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                    }

                }
                model.setState(model.stateCheck());
                model.printState();
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