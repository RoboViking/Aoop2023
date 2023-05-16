package Sokoban;

import javax.swing.*;
import java.awt.*;

/**
 * Holds the main game loop
 * initializes the model, controller and view
 * also holds the initial data for the map
 */

public class Sokoban {

    private SokobanModel model;
    private SokobanView view;
    private SokobanController controller;

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

        // init framework
        model = new SokobanModel(map);
        view = new SokobanView(model);
        controller = new SokobanController(model, view);

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
            // view update
            view.update();

            try {
                Thread.sleep(32); // makes sure that the cpu doesnt over heat ~32 ms is about 30 fps
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

    public static void main(String[] args) {
        new Sokoban();
    }

}