package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private Vector2d lower_left = new Vector2d(0,0);
    private Vector2d upper_right;
    private ArrayList<Animal> animals = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);
    RectangularMap(int width, int height){
        upper_right = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(lower_left) && position.precedes(upper_right) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal animal : this.animals){
            if(animal.getPosition().equals((position)))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for (Animal animal : this.animals){
            if(animal.getPosition().equals((position)))
                return animal;
        }
        return null;
    }
    @Override
    public String toString(){
        return this.visualizer.draw(this.lower_left, this.upper_right);
    }
}
