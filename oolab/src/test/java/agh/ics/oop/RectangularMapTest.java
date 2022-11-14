package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest{

    @Test
    void canMoveToTest(){
        // given
        RectangularMap map = new RectangularMap(6, 6);
        Animal animal_1 = new Animal(map, new Vector2d(0, 0));
        Animal animal_2 = new Animal(map, new Vector2d(6, 6));
        Animal animal_3 = new Animal(map, new Vector2d(0, 6));
        Animal animal_4 = new Animal(map, new Vector2d(6, 0));
        Animal animal_5 = new Animal(map, new Vector2d(2, 1));

        // when
        map.place(animal_1);
        map.place(animal_2);
        map.place(animal_3);
        map.place(animal_4);
        map.place(animal_5);

        // then
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(0, 0)));
        assertFalse(map.canMoveTo(new Vector2d(6, 6)));
        assertFalse(map.canMoveTo(new Vector2d(0, 6)));
        assertFalse(map.canMoveTo(new Vector2d(6, 0)));
        assertFalse(map.canMoveTo(new Vector2d(2, 1)));
    }

    @Test
    public void placeTest(){
        // given
        RectangularMap map = new RectangularMap(6, 6);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(6, 6));
        Animal animal3 = new Animal(map, new Vector2d(0, 6));
        Animal animal4 = new Animal(map, new Vector2d(6, 0));
        Animal animal5 = new Animal(map, new Vector2d(2, 1));
        Animal animal6 = new Animal(map, new Vector2d(2, 1));
        Animal animal7 = new Animal();
        Animal animal8 = new Animal();
        Animal animal9 = new Animal(map, new Vector2d(7, 7));

        // then
        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertTrue(map.place(animal3));
        assertTrue(map.place(animal4));
        assertTrue(map.place(animal5));
        assertFalse(map.place(animal6));
        assertTrue(map.place(animal7));
        assertFalse(map.place(animal8));
        assertFalse(map.place(animal9));
    }

    @Test
    public void isOccupiedTest(){
        // given
        RectangularMap map = new RectangularMap(3, 3);
        Animal animal1 = new Animal(map, new Vector2d(1, 2));
        Animal animal2 = new Animal(map, new Vector2d(4, 3));

        // when
        map.place(animal1);
        map.place(animal2);

        // then
        assertTrue(map.isOccupied(new Vector2d(1, 2)));
        assertFalse(map.isOccupied(new Vector2d(3, 3)));
        assertFalse(map.isOccupied(new Vector2d(4, 3)));
    }

    @Test
    public void objectAtTest(){
        // given
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(map, new Vector2d(4, 4));
        Animal animal2 = new Animal(map, new Vector2d(4, 0));
        Animal animal3 = new Animal(map, new Vector2d(0, 4));
        Animal animal4 = new Animal(map, new Vector2d(0, 0));

        // when
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);

        // then
        assertNull(map.objectAt(new Vector2d(2, 2)));
        assertNull(map.objectAt(new Vector2d(5, 4)));
        assertEquals(animal1, map.objectAt(new Vector2d(4, 4)));
        assertEquals(animal2, map.objectAt(new Vector2d(4, 0)));
        assertEquals(animal3, map.objectAt(new Vector2d(0, 4)));
        assertEquals(animal4, map.objectAt(new Vector2d(0, 0)));
    }
}