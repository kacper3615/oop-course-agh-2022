package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grass_list = new ArrayList<>();
    protected Vector2d lower_left = new Vector2d(0,0);
    protected Vector2d upper_right;

    public abstract Vector2d getUpperRight();

    public abstract Vector2d getLowerLeft();

    public AbstractWorldMap(Vector2d lower_left, Vector2d upper_right){
        this.lower_left = lower_left;
        this.upper_right = upper_right;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(lower_left) &&
               position.precedes(upper_right) &&
                (!isOccupied(position) || !(objectAt(position) instanceof Animal));
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
            if(animal.getPosition().equals(position))
                return true;
        }
        for(Grass grass : this.grass_list){
            if(grass.getPosition().equals(position))
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
        for(Grass grass : this.grass_list){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }
}
