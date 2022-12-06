package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {


    Comparator<Vector2d> xCompX = new VectorComparator(true);
    Comparator<Vector2d> xCompY = new VectorComparator(false);
    SortedSet<Vector2d> sortedSetX = new TreeSet<>(xCompX);
    SortedSet<Vector2d> sortedSetY = new TreeSet<>(xCompY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d element){
        sortedSetX.add(element);
        sortedSetY.add(element);
    }

    public void removeElement(Vector2d element){
        sortedSetY.remove(element);
        sortedSetX.remove(element);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(sortedSetX.first().x,sortedSetY.first().y);
    }

    public Vector2d upperRight(){
        return new Vector2d(sortedSetX.last().x, sortedSetY.last().y);
    }

}