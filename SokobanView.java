import javax.swing.*;
import java.awt.*;

/*
 * holds the logic for painting the frames
 */
public class SokobanView extends JFrame{
    private SokobanModel model;
    private JPanel panel;
    private int rows;
    private int columns;


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

        panel = new JPanel(new GridLayout(rows, columns));
        panel.setSize(rows*32, columns*32);

        for(int y = 0; y<rows; y++){
            for(int x=0; x<columns; x++){
                JLabel tempLable = new JLabel();
                
                switch(model.getMap()[y][x]){
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
                }       
                panel.add(tempLable);
            }
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    public void update(){
        panel.removeAll();
        for(int y = 0; y<rows; y++){
            for(int x=0; x<columns; x++){
                JLabel tempLable = new JLabel();
                
                switch(model.getMap()[y][x]){
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
                }       
                panel.add(tempLable);
            }
        }
        panel.revalidate();
        panel.repaint();
    }
    
}
