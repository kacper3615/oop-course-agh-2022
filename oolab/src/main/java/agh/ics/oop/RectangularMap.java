package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
    private MapVisualizer visualizer = new MapVisualizer(this);
    RectangularMap(int width, int height){
        super(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(lower_left) && position.precedes(upper_right) && !isOccupied(position);
    }

    @Override
    public void removeObject(Object object){
        if (object instanceof Animal){
            this.animals.remove(object);
        }
    }

    @Override
    public Object objectAt(Vector2d position){
        for (Animal animal : this.animals){
            if(animal.getPosition().equals((position)))
                return animal;
        }
        return null;
    }

    public Vector2d getLowerLeft(){
        return lower_left;
    }

    @Override
    public Vector2d getUpperRight() {
        return lower_left;
    }

    @Override
    public String toString(){
        return this.visualizer.draw(this.lower_left, this.upper_right);
    }
}
