package Sokoban;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Sokoban.framework.gObject;
import Sokoban.framework.model;
import Sokoban.objects.*;
import Sokoban.framework.view;

/**
 * SokobanModel which extends model
 * model holds the gamelogic used for the game
 * 
 * @author Fabian Henrysson
 */
public class SokobanModel extends model {
    private int[][] map;
    private int[][] currentMap;
    private ArrayList<view> viewArray = new ArrayList<view>();;
    private player player;
    private boolean state = true;
    private gObject preObject;

    ImageIcon wallImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/wall.png");
    ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
    ImageIcon blankMarkedImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png");
    ImageIcon crateImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png");
    ImageIcon crateMarkedImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png");
    ImageIcon playerImage = new ImageIcon(
            "/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/player.png");

    /**
     * Seter the level
     * 
     * @param map the map/level to be used
     */
    public SokobanModel(int[][] map) {
        this.map = map;
    }

    /**
     * Getter for the map/level
     * 
     * @return map
     */
    public int[][] getLvl() {
        return map;
    }

    /**
     * Setter for the player object to be used in controller etc.
     * 
     * @param object player
     */
    public void setPlayer(player object) {
        if (object instanceof player) {
            this.player = object;
        } else {
            System.out.println("Bad player init");
        }
    }

    /**
     * Getter for the player object
     * 
     * @return player
     */
    public player getPlayer() {
        return player;
    }

    /**
     * Init for lvl
     * @param map lvl
     */
    public void mapInit(int[][] map) {

        setObjectListSize(map[0].length, map.length);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {

                switch (map[y][x]) {
                    case 0:
                        setToMap(new blank(x, y, new JLabel(blankImage)), x, y);
                        break;
                    case 1:
                        setToMap(new wall(x, y, new JLabel(wallImage)), x, y);
                        break;
                    case 2:
                        setToMap(new crate(x, y, new JLabel(crateImage)), x, y);
                        break;
                    case 3:
                        setToMap(new blankMarked(x, y, new JLabel(blankMarkedImage)), x, y);
                        break;
                    case 4:
                        setToMap(new crateMarked(x, y, new JLabel(crateMarkedImage)), x, y);
                        break;
                    case 5:
                        player = new player(x, y, new JLabel(playerImage));
                        setToMap(player, x, y);
                        setPlayer(player);
                        break;
                }
            }
        }
    }

    /**
     * Getter for the views
     * 
     * @return view arraylist
     */
    public ArrayList<view> getViews() {
        return viewArray;
    }

    /**
     * Print method for the current map state in terminal
     */
    public void printCurrentMap() {
        for (int y = 0; y < getObjectList()[0].length; y++) {
            for (int x = 0; x < getObjectList().length; x++) {
                System.out.print(currentMap[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Getter for current map
     * @return currentMap
     */
    public int[][] getCurrentMap() {
        return currentMap;
    }

    /**
     * Setter for the current boolean game state
     * @param state state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Getter of the boolean state
     */
    public boolean getState() {
        return state;
    }

    /**
     * Setter for the previous object
     * @param preObject
     */
    public void setPreObject(gObject preObject) {
        this.preObject = preObject;
    }

    /**
     * Returns the previous object
     * @return preobject
     */
    public gObject getPreObject() {
        return preObject;
    }

    /**
     * method to print blank tiles for normal movement
     */
    public void blankPrint() {
        if (!(getPreObject() instanceof blankMarked)) {
            setToMap(new blank(getPlayer().getX(), getPlayer().getY(), new JLabel(blankImage)), getPlayer().getX(),
                    getPlayer().getY());

        }
    }

    /**
     * Standard moves used in the move method
     * @param xMove step to move in the x axis
     * @param yMove step to move in the y axis
     */
    public void stdMove(int xMove, int yMove) {
        blankPrint();
        player.setX(player.getX() + xMove);
        player.setY(player.getY() + yMove);
        setToMap(player, player.getX(), player.getY());

    }

    /**
     * Direction:
     * left: 0
     * rigth: 1
     * up: 2
     * down: 3
     * Movement method
     * @param xMove     step to move in the x axis
     * @param yMove     step to move in the y axis
     * @param direction the direcion used in the collision logic
     */
    public void move(int xMove, int yMove, int direction) {
        if (player.getY() > 0 && player.collision(player, direction, getObjectList())) {

            gObject nextO = getInMap(player.getX() + xMove, player.getY() + yMove);
            gObject nexttwoO = getInMap(nextO.getX() + xMove, nextO.getY() + yMove);

            if (getPreObject() instanceof blankMarked) {
                if (!((nextO instanceof crate || nextO instanceof crateMarked) &&
                        (nexttwoO instanceof crate || nexttwoO instanceof crateMarked))) {
                    setToMap(preObject, preObject.getX(), preObject.getY());
                } else if (nexttwoO instanceof crateMarked) {
                }
            }

            if (nextO instanceof blank || nextO instanceof blankMarked) {
                stdMove(xMove, yMove);

                if (nextO instanceof blankMarked) {
                    setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                } else {
                    setPreObject(new blank(player.getX(), player.getY(), new JLabel(blankImage)));
                }
            }

            if (nextO instanceof crate && nextO.collision(nextO, direction, getObjectList())) {
               
                    if (nexttwoO instanceof blankMarked) {
                        setToMap(
                                new crateMarked(nexttwoO.getX(), nexttwoO.getY(), new JLabel(crateMarkedImage)),
                                nexttwoO.getX(), nexttwoO.getY());
                        stdMove(xMove, yMove);
                        setPreObject(new blank(player.getX(), player.getY(), new JLabel(blankImage)));
                    } else if (nexttwoO instanceof crate) {
                    } else if (nexttwoO instanceof crateMarked) {
                    } else if (nexttwoO instanceof wall) {
                    } else {
                        nextO.setX(nextO.getX() + xMove);
                        nextO.setY(nextO.getY() + yMove);
                        setToMap(nextO, nextO.getX(), nextO.getY());
                        stdMove(xMove, yMove);
                        setPreObject(new blank(getPlayer().getX(), getPlayer().getY(), new JLabel(blankImage)));
                    }
            }

            if (nextO instanceof crateMarked && nextO.collision(nextO, direction, getObjectList())) {
                if (!(nexttwoO instanceof crate)) {
                    nextO.setX(nextO.getX() + xMove);
                    nextO.setY(nextO.getY() + yMove);
                    setToMap(
                            new crate(nextO.getX(), nextO.getY(), new JLabel(crateImage)),
                            nextO.getX(), nextO.getY());

                    blankPrint();
                    player.setX(player.getX() + xMove);
                    player.setY(player.getY() + yMove);

                    setToMap(player, player.getX(), player.getY());
                    setPreObject(new blankMarked(player.getX(), player.getY(), new JLabel(blankMarkedImage)));
                }
            }
        }
    }

    /**
     * Implementation of statceCheck which returns if the game is won or still running 
     * also writes the current state of the game into a 2d array to be printed in terminal
     */
    @Override
    public boolean stateCheck() {
        int count = 0;
        int width = getObjectList().length;
        int height = getObjectList()[0].length;
        currentMap = new int[width][height];
        int x = 0;
        int y = 0;

        for (gObject[] row : getObjectList()) {
            for (gObject cell : row) {
                if (cell instanceof blank) {
                    currentMap[x][y] = 0;
                } else if (cell instanceof wall) {
                    currentMap[x][y] = 1;
                } else if (cell instanceof crate) {
                    currentMap[x][y] = 2;
                    count++;
                } else if (cell instanceof blankMarked) {
                    currentMap[x][y] = 3;
                } else if (cell instanceof crateMarked) {
                    currentMap[x][y] = 4;
                } else if (cell instanceof player) {
                    currentMap[x][y] = 5;
                }
                y++;
            }
            y = 0;
            x++;
        }

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

}
