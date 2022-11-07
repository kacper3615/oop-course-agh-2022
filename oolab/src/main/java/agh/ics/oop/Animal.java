package agh.ics.oop;

import static agh.ics.oop.MapDirection.*;
public class Animal {
    private MapDirection direction
            = NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public MapDirection getDirection(){
        return direction;
    }

    public boolean checkPosition(Vector2d position){
        return position.x>=0 && position.x<=4 && position.y>=0 && position.y<=4;
    }
    public void move(MoveDirection direction){
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
        }
    };

    @Override
    public String toString(){
        return this.direction + ", " + this.position.toString();
    }
}
