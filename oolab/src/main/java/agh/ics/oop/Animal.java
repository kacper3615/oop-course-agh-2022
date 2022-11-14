package agh.ics.oop;

import static agh.ics.oop.MapDirection.*;
public class Animal {
<<<<<<< Updated upstream
    private MapDirection direction
            = NORTH;
    private Vector2d position = new Vector2d(2, 2);
=======
    private MapDirection orientation = NORTH;;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;
    public Animal(){}

    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection direction){
        this.position = initialPosition;
        this.orientation = direction;
        this.map = map;
    }
>>>>>>> Stashed changes

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

<<<<<<< Updated upstream
    public MapDirection getDirection(){
        return direction;
    }

=======
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {return orientation;}

>>>>>>> Stashed changes
    public boolean checkPosition(Vector2d position){
        return position.x>=0 && position.x<=4 && position.y>=0 && position.y<=4;
    }
    public void move(MoveDirection direction){
<<<<<<< Updated upstream
        switch (direction) {
            case LEFT: {
                this.direction = this.direction.previous();
                break;
            }
            case RIGHT: {
                this.direction = this.direction.next();
                break;
            }
            case FORWARD: {
                Vector2d new_position = position.add(this.direction.toUnitVector());
                if (checkPosition(new_position)) {
                    position = new_position;
                }
                break;
            }
            case BACKWARD: {
                Vector2d new_position = position.subtract(this.direction.toUnitVector());
                if (checkPosition(new_position)) {
                    position = new_position;
                break;
                }
            };
=======
        Vector2d new_position = this.position;
        switch (direction) {
            case LEFT -> this.orientation = orientation.previous();
            case RIGHT -> this.orientation = orientation.next();
            case FORWARD -> new_position = new_position.add(orientation.toUnitVector());
            case BACKWARD -> new_position = new_position.subtract(orientation.toUnitVector());
        }
        if (map.canMoveTo(new_position)) {
            this.position = new_position;
>>>>>>> Stashed changes
        }
    };

    @Override
    public String toString(){
<<<<<<< Updated upstream
        return this.direction + ", " + this.position.toString();
=======
        return switch(this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
>>>>>>> Stashed changes
    }
}
