package Sokoban;
import javax.swing.*;
import java.awt.*;
import Sokoban.objects.blank;
import Sokoban.objects.blankMarked;
import Sokoban.objects.crate;
import Sokoban.objects.crateMarked;
import Sokoban.objects.player;
import Sokoban.objects.wall;

/*
 * holds the logic for painting the frames
 */
public class SokobanView extends JFrame{
    private JPanel panel;
    private int rows;
    private int columns;
    private SokobanModel model;
    //private gObject object;


    /*
     * The maps are stored in a 2d int array
     * 0: blank
     * 1: wall
     * 2: crate
     * 3: blank goal
     * 4: crate marked (a crate that is on a goal)
     * 5: player
     */
    //init for the view
    public SokobanView(SokobanModel model){
        this.model = model;
        this.rows = model.getMap().length;
        this.columns = model.getMap()[0].length;
        model.setObjectListSize(columns, rows);

        panel = new JPanel(new GridLayout(rows, columns));
        panel.setSize(rows*32, columns*32);

        for(int y = 0; y<rows; y++){
            for(int x=0; x<columns; x++){
                
                JLabel tempLable = new JLabel();
                
                switch(model.getMap()[y][x]){
                    case 0:
                        ImageIcon blankImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png");
                        tempLable.setIcon(blankImage);
                        //model.addToList(new blank(x,y, new JLabel(blankImage)));
                        model.setToObjectMap(new blank(x,y, new JLabel(blankImage)), x, y);
                        break;
                    case 1:
                        ImageIcon wallImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/wall.png");
                        tempLable.setIcon(wallImage);
                        //model.addToList(new wall(x,y, new JLabel(wallImage)));
                        model.setToObjectMap(new wall(x,y, new JLabel(wallImage)), x, y);
                        break;
                    case 2:
                        ImageIcon crateImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png");
                        tempLable.setIcon(crateImage);
                        //model.addToList(new crate(x,y, new JLabel(crateImage)));
                        model.setToObjectMap(new crate(x,y, new JLabel(crateImage)), x, y);
                        break;
                    case 3:
                        ImageIcon blankMarkedImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png");
                        tempLable.setIcon(blankMarkedImage);
                        //model.addToList(new blankMarked(x,y, new JLabel(blankMarkedImage)));
                        model.setToObjectMap(new blankMarked(x,y, new JLabel(blankMarkedImage)), x, y);
                        break;
                    case 4:
                        ImageIcon crateMarkedImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png");
                        tempLable.setIcon(crateMarkedImage);
                        //model.addToList(new crateMarked(x,y, new JLabel(crateMarkedImage)));
                        model.setToObjectMap(new crateMarked(x,y, new JLabel(crateMarkedImage)), x, y);
                        break;
                    case 5:
                        ImageIcon playerImage = new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/player.png");
                        tempLable.setIcon(playerImage);
                        //model.addToList(new player(x,y, new JLabel(playerImage)));
                        model.setToObjectMap(new player(x,y, new JLabel(playerImage)), x, y);
                        break;
                }       
                panel.add(tempLable); 
            }
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    //updates the view with 
    public void update(){
        panel.removeAll();
        for(int y = 0; y<rows; y++){
            for(int x=0; x<columns; x++){
                JLabel tempLable = new JLabel();
                
                /*switch(model.getObjecctList[y][x]){
                    case 0:
                        tempLable.setIcon(new ImageIcon("blank.png"));
                        break;
                    case 1:
                        tempLable.setIcon(new ImageIcon("wall.png"));
                        break;
                    case 2:
                        tempLable.setIcon(new ImageIcon("crate.png"));
                        break;
                    case 3:
                        tempLable.setIcon(new ImageIcon("blankmarked.png"));
                        break;
                    case 4:
                        tempLable.setIcon(new ImageIcon("cratemarked.png"));
                        break;
                    case 5:
                        tempLable.setIcon(new ImageIcon("player.png"));    
                        break;
                }*/
                
                if(model.getObjectList()[y][x] instanceof blank){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blank.png"));
                }
                
                if(model.getObjectList()[y][x] instanceof wall){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/wall.png"));
                }
                
                if(model.getObjectList()[y][x] instanceof crate){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/crate.png"));
                }
                
                if(model.getObjectList()[y][x] instanceof blankMarked){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/blankmarked.png"));
                }
                
                if(model.getObjectList()[y][x] instanceof crateMarked){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/cratemarked.png"));
                }
                
                if(model.getObjectList()[y][x] instanceof player){
                    tempLable.setIcon(new ImageIcon("/home/fhenrysson/Documents/github/Aoop2023/Sokoban/images/player.png"));
                }

                panel.add(tempLable);
            }
        }
        panel.revalidate();
        panel.repaint();
    }
    
}
