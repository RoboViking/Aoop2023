package Sokoban;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Sokoban.framework.controller;
import Sokoban.framework.gObject;
import Sokoban.objects.*;

public class SokobanController extends controller {
    private SokobanModel model;
    private SokobanView view;
    private gObject player;
    private gObject preObject;

    public SokobanController(SokobanModel model, SokobanView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
        player = model.getPlayer();
    }

    public void setPreObject(gObject preObject) {
        this.preObject = preObject;
    }

    public gObject getPreObject() {
        return preObject;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int y = model.getPlayer().getY();
        int x = model.getPlayer().getX();
        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
        // ImageIcon blankMarkedImage = new
        // ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png");
        // ImageIcon crateImage = new
        // ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png");
        // ImageIcon crateMarkedImage = new
        // ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png");

        switch (key) {
            case KeyEvent.VK_UP:
                if (y > 0 && player.collision(player, 2, model.getObjectList())) {
                    gObject upO = model.getInMap(player.getX(), player.getY() - 1);

                    if (upO instanceof blank || upO instanceof blankMarked) {
                        player.setY(player.getY() - 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (upO instanceof crate && upO.collision(upO, 2, model.getObjectList())) {
                        upO.setY(upO.getY() - 1);
                        model.setToMap(upO, upO.getX(), upO.getY());

                        player.setY(player.getY() - 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (preObject instanceof blankMarked) {
                        model.setToMap(new blankMarked(x, y, new JLabel(blankImage)), x, y);
                    }

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    if (upO.collision(upO, 2, model.getObjectList())) {
                        setPreObject(upO);
                    }
                }
                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_DOWN:
                if (y <= view.getHeight() && player.collision(player, 3, model.getObjectList())) {

                    gObject downO = model.getInMap(player.getX(), player.getY() + 1);

                    if (downO instanceof blank || downO instanceof blankMarked) {
                        player.setY(player.getY() + 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (downO instanceof crate && downO.collision(downO, 3, model.getObjectList())) {
                        downO.setY(downO.getY() + 1);
                        model.setToMap(downO, downO.getX(), downO.getY());

                        player.setY(player.getY() + 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    setPreObject(downO);

                }

                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0 && player.collision(player, 0, model.getObjectList())) {

                    gObject leftO = model.getInMap(player.getX() - 1, player.getY());

                    if (leftO instanceof blank || leftO instanceof blankMarked) {
                        player.setX(player.getX() - 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (leftO instanceof crate && leftO.collision(leftO, 0, model.getObjectList())) {
                        leftO.setX(leftO.getX() - 1);
                        model.setToMap(leftO, leftO.getX(), leftO.getY());

                        player.setX(player.getX() - 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    setPreObject(leftO);

                }
                model.setState(model.stateCheck());
                model.printState();
                break;
            case KeyEvent.VK_RIGHT:
                if (x <= view.getWidth() && player.collision(player, 1, model.getObjectList())) {

                    gObject rightO = model.getInMap(player.getX() + 1, player.getY());

                    if (rightO instanceof blank || rightO instanceof blankMarked) {
                        player.setX(player.getX() + 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (rightO instanceof crate && rightO.collision(rightO, 1, model.getObjectList())) {
                        rightO.setX(rightO.getX() + 1);
                        model.setToMap(rightO, rightO.getX(), rightO.getY());

                        player.setX(player.getX() + 1);
                        model.setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        model.setToMap(player, player.getX(), player.getY());
                    }

                    if (getPreObject() instanceof blankMarked) {
                        model.setToMap(preObject, preObject.getX(), preObject.getY());
                    }

                    setPreObject(rightO);

                }
                model.setState(model.stateCheck());
                model.printState();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
