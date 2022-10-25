package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Vector2dTest {
    int MAX_INT = 2147483647;
    int MIN_INT = -2147483648;

    @Test
    public void equalsTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, 1);
        Vector2d vector_3 = new Vector2d(1, 2);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertNotEquals(vector_1, vector_2);
        assertEquals(vector_1, vector_3);
        assertNotEquals(vector_2, vector_3);
        assertEquals(vector_1, vector_1);
        assertNotEquals(vector_max, vector_min);
    }

    @Test
    public void toStringTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, 1);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertEquals("(1,2)", vector_1.toString());
        assertEquals("(-5,1)", vector_2.toString());
        assertEquals("(-7,-1)", vector_3.toString());
        assertEquals("(2147483647,2147483647)", vector_max.toString());
        assertEquals("(-2147483648,-2147483648)", vector_min.toString());
    }

    @Test
    public void precedesTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertFalse(vector_1.precedes(vector_3));
        assertTrue(vector_3.precedes(vector_1));
        assertFalse(vector_2.precedes(vector_3));
        assertFalse(vector_3.precedes(vector_2));
        assertTrue(vector_min.precedes(vector_max));
    }

    @Test
    public void followsTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertTrue(vector_1.follows(vector_3));
        assertFalse(vector_3.follows(vector_1));
        assertFalse(vector_2.follows(vector_3));
        assertFalse(vector_3.follows(vector_2));
        assertTrue(vector_max.follows(vector_min));
    }

    @Test
    public void upperRightTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vector_1.upperRight(vector_2), new Vector2d(1, 2));
        assertEquals(vector_2.upperRight(vector_3), new Vector2d(-5, -1));
        assertNotEquals(vector_1.upperRight(vector_3), new Vector2d(-7, 2));
        assertEquals(vector_min.upperRight(vector_max), new Vector2d(2147483647, 2147483647));
    }

    @Test
    public void lowerLeftTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vector_1.lowerLeft(vector_2), new Vector2d(-5, -3));
        assertEquals(vector_2.lowerLeft(vector_3), new Vector2d(-7, -3));
        assertNotEquals(vector_1.lowerLeft(vector_3), new Vector2d(-7, 2));
        assertEquals(vector_min.lowerLeft(vector_max), new Vector2d(-2147483648, -2147483648));
    }

    @Test
    public void addTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vector_1.add(vector_2), new Vector2d(-4, -1));
        assertEquals(vector_2.add(vector_3), new Vector2d(-12, -4));
        assertNotEquals(vector_1.add(vector_3), new Vector2d(-7, 2));
        assertEquals(vector_max.add(vector_min), new Vector2d(-1, -1));
        assertEquals(vector_min.add(vector_max), new Vector2d(-1, -1));
    }

    @Test
    public void subtractTest(){
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(-7, -1);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vector_min = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vector_1.subtract(vector_2), new Vector2d(6, 5));
        assertEquals(vector_2.subtract(vector_3), new Vector2d(2, -2));
        assertNotEquals(vector_1.subtract(vector_3), new Vector2d(-7, 2));
        assertEquals(vector_max.subtract(vector_max), new Vector2d(0, 0));
        assertEquals(vector_min.subtract(vector_min), new Vector2d(0, 0));

    }

    @Test
    public void oppositeTest() {
        Vector2d vector_1 = new Vector2d(1, 2);
        Vector2d vector_2 = new Vector2d(-5, -3);
        Vector2d vector_3 = new Vector2d(5, 3);
        Vector2d vector_max = new Vector2d(MAX_INT, MAX_INT);

        assertEquals(vector_1.opposite(), new Vector2d(-1, -2));
        assertEquals(vector_2.opposite(), vector_3);
        assertEquals(vector_max.opposite(), new Vector2d(-MAX_INT, -MAX_INT));
    }
}
