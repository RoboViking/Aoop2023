package Sokoban;
import java.awt.event.*;

public class SokobanController implements KeyListener{
    private SokobanModel model;
    private SokobanView view;
    private gObject player;

    public SokobanController(SokobanModel model, SokobanView view){
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
        player = model.getPlayer();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int y = model.getPlayer().getY();
        int x = model.getPlayer().getX();

        switch(key){
            case KeyEvent.VK_UP:
                if(y<view.getHeight() && y>=0){
                    player.setY(y+1);
                }
                //work on this

                break;
            case KeyEvent.VK_DOWN:
                player.setY(y-1);
                break;
            case KeyEvent.VK_LEFT:
                player.setX(x-1);
                break;
            case KeyEvent.VK_RIGHT:
                player.setX(x+1);
                break;
            case KeyEvent.VK_W:
                player.setY(y+1);
                System.out.println("UP");
                break;
            case KeyEvent.VK_S:
                player.setY(y-1);
                break;
            case KeyEvent.VK_A:
                player.setX(x-1);
                break;
            case KeyEvent.VK_D:
                player.setX(x+1);
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
