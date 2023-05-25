package Sokoban;

import javax.swing.*;
import java.awt.*;

/**
 * Sokoban game implementation
 * @author Fabian Henrysson
 * @since 2023-04-14
 */

public class Sokoban {

    private SokobanModel model;
    private SokobanView view;
    private SokobanTextView txtView;
    private SokobanController controller;

    /*
     * Sokoban constructor that holds the main game loop,
     * init of the framework,
     * and initial map.
     */
    public Sokoban(){
        // the map
        int[][] map = {
                { 0, 0, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 1, 0 },
                { 1, 3, 5, 2, 0, 0, 1, 0 },
                { 1, 1, 1, 0, 2, 3, 1, 0 },
                { 1, 3, 1, 1, 2, 0, 1, 0 },
                { 1, 0, 1, 0, 3, 0, 1, 1 },
                { 1, 2, 0, 4, 2, 2, 3, 1 },
                { 1, 0, 0, 0, 3, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        // inits framework
        model = new SokobanModel(map);
        model.mapInit(map);
        view = new SokobanView(model);
        txtView = new SokobanTextView(model); 
        controller = new SokobanController(model, view);

        //adding views to array for observer pattern
        model.getViews().add(view);
        model.getViews().add(txtView);

        // frame init
        JFrame frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setSize(32 * 8, 36 * 9);
        frame.add(view.getPanel());
        frame.addKeyListener(controller);
        frame.pack();
        frame.setVisible(true);

        // the game loop
        while (true) {            
            /*
             * view observer update
             */
            for(int x = 0; x<model.getViews().size(); x++){
                model.getViews().get(x).update();
            }

            txtView.printCurrentMap();

            try {
                Thread.sleep(32); // ~32 ms is about 30 fps
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }

            if (!model.getState()) {
                System.out.println("YOU WON");
                frame.removeKeyListener(controller);
                break;
            }
        }
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        new Sokoban();
    }

}