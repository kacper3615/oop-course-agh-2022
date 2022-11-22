package agh.ics.oop;

import static agh.ics.oop.MapDirection.*;
public class Animal extends AbstractWorldMapElement{
    private MapDirection orientation = NORTH;
    private IWorldMap map = new RectangularMap(4,4);;
    public Animal(){
        super(new Vector2d(2, 2));
    }

    public Animal(IWorldMap map) {
        super(new Vector2d(2, 2));
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection direction){
        super(initialPosition);
        this.orientation = direction;
        this.map = map;
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
            this.position = new_position;
        }
    };

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
