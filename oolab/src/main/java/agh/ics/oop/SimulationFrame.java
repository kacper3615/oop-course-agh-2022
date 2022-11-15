package agh.ics.oop;

import javax.swing.*;
import java.awt.*;

public class SimulationFrame extends JFrame {
    static final int SCREEN_WIDTH = 250;
    static final int SCREEN_HEIGHT = 250;

    public SimulationFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
    }
}