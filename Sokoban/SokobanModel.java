package Sokoban;

import Sokoban.framework.gObject;
import Sokoban.framework.model;
import Sokoban.objects.crate;
import Sokoban.objects.player;

/*
 * the model holds the gamelogic
 */
public class SokobanModel extends model{
    private int[][] map;
    private player player;

    public SokobanModel(int[][] map) {
        this.map = map;
    }

    public int[][] getLvl() {
        return map;
    }

    public void setPlayer(player object) {
        if (object instanceof player) {
            this.player = object;
        } else {
            System.out.println("Bad player init");
        }
    }

    public player getPlayer() {
        return player;
    }

    @Override
    public boolean stateCheck() {
        int count = 0;
        int length = getObjectList().length;
        int height = getObjectList()[0].length;
        int[][] mapState = new int[length][height];

        for (gObject[] row : getObjectList()) {
            for (gObject cell : row) {
                if (cell instanceof crate) {
                    count++;
                }

     
            }
        }

        System.out.println(player.getX() + ", " + player.getY());
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

}
