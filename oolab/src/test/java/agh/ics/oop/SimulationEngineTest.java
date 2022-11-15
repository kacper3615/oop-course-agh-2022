package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SimulationEngineTest {
    @Test
    public void worldSimulationFirstTest(){
        // given
        String[] dirArgs = {"f", "b", "r", "l", "f", "f", "f", "f", "f", "f"};
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2, 2), new Vector2d(3, 4) };
        MoveDirection[] directions1 = OptionsParser.parse(dirArgs);
        SimulationEngine engine = new SimulationEngine(directions1, map, positions);

        // when
        engine.run();

        // then
        assertEquals(engine.animals.get(0).getPosition(), new Vector2d(2, 3));
        assertEquals(engine.animals.get(0).getDirection(), MapDirection.EAST);
        assertNotEquals(engine.animals.get(0).getPosition(), new Vector2d(5, 3));
        assertEquals(engine.animals.get(1).getPosition(), new Vector2d(3, 3));
        assertEquals(engine.animals.get(1).getDirection(), MapDirection.WEST);
        assertNotEquals(engine.animals.get(1).getPosition(), new Vector2d(0, 3));
    }

    @Test
    public void worldSimulationSecondTest(){
        //GIVEN
        String[] dirArgs = {"f", "b", "r", "l", "f", "f", "r", "r", "r", "r",
                "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2, 2), new Vector2d(3, 4) };
        MoveDirection[] directions = OptionsParser.parse(dirArgs);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);

        //WHEN
        engine.run();

        //THEN
        assertEquals(engine.animals.get(0).getPosition(), new Vector2d(0, 3));
        assertEquals(engine.animals.get(0).getDirection(), MapDirection.WEST);
        assertEquals(engine.animals.get(1).getPosition(), new Vector2d(10, 5));
        assertEquals(engine.animals.get(1).getDirection(), MapDirection.EAST);
    }
}