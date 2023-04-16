import javax.swing.*;
import java.awt.*;
/**
 * Holds the main game loop
 * initializes the model, controller and view
 * also holds the data for the map
 */

public class Sokoban{
    public static void main(String[] args){
    
        /*
         * The maps are stored in a 2d int array
         * 0: ground
         * 1: wall
         * 2: crate
         * 3: blank goal
         * 4: crate marked (a crate that is on a goal)
         * 5: player
         */

        //the map
        int[][] map = {
            {0, 0, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 1, 0},
            {1, 3, 5, 2, 0, 0, 1, 0},
            {1, 1, 1, 0, 2, 3, 1, 0},
            {1, 3, 1, 1, 2, 0, 1, 0},
            {1, 0, 1, 0, 3, 0, 1, 1},
            {1, 2, 0, 4, 2, 2, 3, 1},
            {1, 0, 0, 0, 3, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };

        //model init
        SokobanModel model =  new SokobanModel(map);
        SokobanView view = new SokobanView(model);
        SokobanController controller = new SokobanController();

        JFrame frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 600);
        
        //frame.add(view);
        frame.setVisible(true);


        //the game loop
        while(true){

            //update the controller and repaint view
            //controller.update();
            //view.repaint();

            try{
                Thread.sleep(16); //makes sure that the cpu doesnt over heat. Will have to change this if i have the time for actuall 60 fps
            }catch(Exception e){
                System.out.println("Something went wrong");
            }
        }
    }

}