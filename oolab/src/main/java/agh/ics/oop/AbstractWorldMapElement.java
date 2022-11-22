package agh.ics.oop;

public class AbstractWorldMapElement {
    protected Vector2d position;

    public AbstractWorldMapElement(Vector2d position){
        this.position = position;
    }

    public boolean isAt(Vector2d pos){
        return this.position.equals(pos);
    }
    public Vector2d getPosition(){
        return this.position;
    }
}
