package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static agh.ics.oop.MapDirection.*;

public class AnimalTest {
    @Test
    public void directionTest(){
        Animal animal = new Animal();
        assertEquals(NORTH, animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(EAST, animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(SOUTH, animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(WEST, animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(NORTH, animal.getDirection());
        animal.move(MoveDirection.LEFT);
        assertEquals(WEST, animal.getDirection());
        animal.move(MoveDirection.LEFT);
        assertEquals(SOUTH, animal.getDirection());
        animal.move(MoveDirection.LEFT);
        assertEquals(EAST, animal.getDirection());
        animal.move(MoveDirection.LEFT);
        assertEquals(NORTH, animal.getDirection());
    }

    @Test
    public void moveTest(){
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 3)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2, 3)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3, 3)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 3)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 3)));
    }

    @Test
    public void mapBorderTest(){
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2,2)));

        //Top border
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 3)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 4)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 4)));

        //Right border
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2, 4)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3, 4)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 4)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 4)));

        //Bottom border
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(4, 4)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 3)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 1)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4, 0)));

        //Left border
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(4, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0, 0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0, 0)));
    }
}
