package Sokoban;
import java.awt.event.*;

public class SokobanController implements KeyListener{
    private SokobanModel model;
    private SokobanView view;

    public SokobanController(SokobanModel model, SokobanView view){
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
    }

    public void update(){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_W:
                break;
            case KeyEvent.VK_S:
                break;
            case KeyEvent.VK_A:
                break;
            case KeyEvent.VK_D:
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
