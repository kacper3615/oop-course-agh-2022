package agh.ics.oop;

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
    public Object objectAt(Vector2d position){
        if (animals.containsKey(position)) {
            return animals.get(position);
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
