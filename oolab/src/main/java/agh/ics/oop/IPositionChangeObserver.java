package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d old_position, Vector2d new_position);
}
