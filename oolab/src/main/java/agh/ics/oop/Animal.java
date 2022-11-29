package agh.ics.oop;

import static agh.ics.oop.MapDirection.*;
import java.util.ArrayList;
import java.util.List;
public class Animal extends AbstractWorldMapElement{
    private MapDirection orientation = NORTH;
    private IWorldMap map = new RectangularMap(4,4);;
    public Animal(){
        super(new Vector2d(2, 2));
    }
    private List<IPositionChangeObserver> observer_list = new ArrayList<>();

    public Animal(IWorldMap map) {
        super(new Vector2d(2, 2));
        this.map = map;
        addObserver((IPositionChangeObserver) map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection direction){
        super(initialPosition);
        this.orientation = direction;
        this.map = map;
        addObserver((IPositionChangeObserver) map);
    }

    public MapDirection getDirection() {return orientation;}

    public boolean checkPosition(Vector2d position){
        return position.x>=0 && position.x<=4 && position.y>=0 && position.y<=4;
    }
    public void move(MoveDirection direction){
        Vector2d new_position = this.position;
        switch (direction) {
            case LEFT -> this.orientation = orientation.previous();
            case RIGHT -> this.orientation = orientation.next();
            case FORWARD -> new_position = new_position.add(orientation.toUnitVector());
            case BACKWARD -> new_position = new_position.subtract(orientation.toUnitVector());
        }
        if (this.map.isOccupied(new_position)){
            Object object = this.map.objectAt(new_position);
            if (object instanceof Grass){
                this.map.removeObject(object);
            }
        }
        if (this.map.canMoveTo(new_position)) {
            positionChanged(position, new_position);
            this.position = new_position;
        }
    };

    private void positionChanged(Vector2d old_position, Vector2d new_position) {
        for (IPositionChangeObserver observer : observer_list) {
            observer.positionChanged(old_position, new_position);
        }
    }
    void addObserver(IPositionChangeObserver observer) {
        this.observer_list.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observer_list.remove(observer);
    }
    @Override
    public String toString(){
        return switch(this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
}
