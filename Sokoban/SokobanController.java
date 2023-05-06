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

    public void update(){
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int y = model.getPlayer().getY();
        int x = model.getPlayer().getX();

        switch(key){
            case KeyEvent.VK_UP:
                player.setY(y++);
                System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                player.setY(y--);
                break;
            case KeyEvent.VK_LEFT:
                player.setX(x--);
                break;
            case KeyEvent.VK_RIGHT:
                player.setX(x++);
                break;
            case KeyEvent.VK_W:
                player.setY(y++);
                System.out.println("UP");
                break;
            case KeyEvent.VK_S:
                player.setY(y--);
                break;
            case KeyEvent.VK_A:
                player.setX(x--);
                break;
            case KeyEvent.VK_D:
                player.setX(x++);
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
