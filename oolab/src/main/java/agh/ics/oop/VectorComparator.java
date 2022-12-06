package agh.ics.oop;

import java.util.Comparator;

public class VectorComparator implements Comparator<Vector2d>{

    private boolean flag;
    VectorComparator (boolean flag){
        this.flag = flag;
    }

    @Override
    public int compare(Vector2d vector1, Vector2d vector2){
        if (this.flag) {
            if (vector1.getX() - vector2.getX() != 0)
                return vector1.getX() - vector2.getX();
            return vector1.getY() - vector2.getY();
        } else{
            if (vector1.getY() - vector2.getY() != 0)
                return vector1.getY() - vector2.getY();
            return vector1.getX() - vector2.getX();
        }
    }
}