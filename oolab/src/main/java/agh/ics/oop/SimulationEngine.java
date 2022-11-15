package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private IWorldMap map;
    private MoveDirection[] moves;
    public List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.map = map;
        this.moves = moves;
        this.animals = addAnimals(positions);
    }

    public List<Animal> addAnimals(Vector2d[] positions){
        List<Animal> animal_list = new ArrayList<>();
        for(Vector2d position: positions) {
            Animal animal = new Animal(this.map, position, MapDirection.NORTH);
            animal_list.add(animal);
            this.map.place(animal);
        }
        return animal_list;
    }

    private void generateContent(JLabel label){
        label.setText("<html>" + map.toString().replaceAll("\n", "<br/>") + "</html>");
        try {
            Thread.sleep(300);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private JLabel generateLabel(){
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.BLACK);

        return label;
    }

    @Override
    public void run() {
        JLabel label = generateLabel();
        SimulationFrame frame = new SimulationFrame();
        frame.add(label);

        generateContent(label);
        for (int i = 0; i < this.moves.length; i++){
            this.animals.get(i % animals.size()).move(this.moves[i]);
            generateContent(label);
        }
    }
}
