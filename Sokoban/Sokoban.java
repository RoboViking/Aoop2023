package Sokoban;
import javax.swing.*;
import java.awt.*;
/**
 * Holds the main game loop
 * initializes the model, controller and view
 * also holds the data for the map
 */

public class Sokoban{
    public static void main(String[] args){

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

        //init
        SokobanModel model =  new SokobanModel(map);
        SokobanView view = new SokobanView(model);
        SokobanController controller = new SokobanController(model, view);

        JFrame frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setSize(32*8, 36*9);
        frame.add(view.getPanel());
        frame.pack();
        frame.setVisible(true);

        //the game loop
        while(true){

            if(!model.stateCheck()){
                System.out.println("YOU WON");
                break;
            }

            //update the controller and repaint view
            controller.update();
            view.update();

            try{
                Thread.sleep(17); //makes sure that the cpu doesnt over heat. Will have to change this if i have the time for actuall 60 fps
            }catch(Exception e){
                System.out.println("Something went wrong");
            }

            //System.out.print("f, ");
        }
    }

}