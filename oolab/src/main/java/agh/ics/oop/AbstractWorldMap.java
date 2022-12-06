package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grass_list = new HashMap<>();
    protected Vector2d lower_left = new Vector2d(0,0);
    protected Vector2d upper_right;

    public abstract Vector2d getUpperRight();

    public abstract Vector2d getLowerLeft();

    public AbstractWorldMap(Vector2d lower_left, Vector2d upper_right){
        this.lower_left = lower_left;
        this.upper_right = upper_right;
    }

    public Map<Vector2d, Grass> getGrass(){
        return this.grass_list;
    }

    public Map<Vector2d, Animal> getAnimals(){
        return this.animals;
    }


    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(lower_left) &&
               position.precedes(upper_right) &&
                (!isOccupied(position) || !(objectAt(position) instanceof Animal));
    }

    @Override
    public void positionChanged(Vector2d old_position, Vector2d new_position) {
        Animal animal = animals.get(old_position);
        animals.put(new_position, animal);
        animals.remove(old_position, animal);
    }
    @Override
    public boolean place(Animal animal){
        Vector2d current_position = animal.getPosition();
        if (!canMoveTo(current_position)) {
            throw new IllegalArgumentException(current_position + " is not legal move specification.");
        }
        animals.put(current_position, animal);
        return true;
    }

    @Override
    public void removeObject(Object object){
        if (object instanceof Animal){
            this.animals.remove(((Animal) object).position);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grass_list.containsKey(position)) {
            return grass_list.get(position);
        }
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }
}
