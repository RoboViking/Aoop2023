import javax.swing.*;
import java.awt.*;

/*
 * holds the logic for painting the frames
 */
public class SokobanView extends JFrame{
    private SokobanModel model;
    private JPanel panel;
    private JFrame frame;

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
        panel = new JPanel(new GridLayout(rows*32, columns*32, 0, 0));
        panel.setBackground(Color.darkGray);
        panel.setMaximumSize(new Dimension(columns*50, rows*50));//50 could be 32
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        for(){
            
        }
    }
    
}
