import javax.swing.*;
import java.awt.*;

/*
 * holds the logic for painting the frames
 */
public class SokobanView extends JFrame{
    private SokobanModel model;
    private JPanel panel;
    private JLabel[][] mapState;

    /*
     * The maps are stored in a 2d int array
     * 0: blank
     * 1: wall
     * 2: crate
     * 3: blank goal
     * 4: crate marked (a crate that is on a goal)
     * the player gets it position in the controller
     */
    //init for the view
    public SokobanView(SokobanModel model){
        this.model = model;
        int rows = model.getMap().length;
        int columns = model.getMap()[0].length;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sokoban");
        setSize(rows*32, columns*32);

        panel = new JPanel(new GridLayout(rows, columns));

        mapState = new JLabel[rows][columns];
        for(int y = 0; y<rows; y++){
            for(int x=0; x<columns; x++){
                JLabel tempLable = new JLabel();
                mapState[y][x]=tempLable;

                switch(model.getMap()[y][x]){
                    case 0:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/blank.png"));
                        break;
                    case 1:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/wall.png"));
                        break;
                    case 2:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/crate.png"));
                        break;
                    case 3:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/blankmarked.png"));
                        break;
                    case 4:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/cratemarked.png"));
                        break;
                    case 5:
                        tempLable.setIcon(new ImageIcon("/home/fabian/Documents/Github/Aoop23/images/player.png"));    
                        break;
                }       
                panel.add(tempLable);
            }

        }
        add(panel);
        setVisible(true);
    }

    public void update(){
        int rows = model.getMap().length;
        int columns = model.getMap()[0].length;

        for(int y = 0; y<columns; y++){
            for(int x=0; x<rows; x++){

                switch(model.getMap()[y][x]){
                    case 0:
                        mapState[y][x].setIcon(new ImageIcon("blank.png"));
                        break;
                    case 1:
                        mapState[y][x].setIcon(new ImageIcon("wall.png"));
                        break;
                    case 2:
                        mapState[y][x].setIcon(new ImageIcon("crate.png"));
                        break;
                    case 3:
                        mapState[y][x].setIcon(new ImageIcon("blankmarked.png"));
                        break;
                    case 4:
                        mapState[y][x].setIcon(new ImageIcon("cratemarked.png"));
                        break;
                    case 5:
                        mapState[y][x].setIcon(new ImageIcon("player.png"));    
                        break;
                }

            }
        }
        panel.repaint();
    }
    
}
