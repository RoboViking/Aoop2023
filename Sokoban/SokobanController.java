package Sokoban;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Sokoban.objects.*;

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
                    if(y>0){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setY(y-1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(y<view.getHeight()){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setY(y+1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(x>0){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setX(x-1);
                        model.setToMap(player, player.getX(), player.getY());

                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(x<view.getWidth()){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setX(x+1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_W:
                    if(y>0){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setY(y-1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_S:
                    if(y<view.getHeight() ){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setY(y+1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_A:
                    if(x>0){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setX(x-1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
                    break;
                case KeyEvent.VK_D:
                    if(x<view.getWidth()){
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        model.setToMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        player.setX(x+1);
                        model.setToMap(player, player.getX(), player.getY());
                    }
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
