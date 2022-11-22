package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void grassFieldTest(){
        String[] args = {"f", "f", "b",
                         "f", "r", "f",
                         "l", "f", "r",
                         "f", "r", "f",
                         "f", "l", "f",
                         "l", "b", "l"};
        MoveDirection[] directions = (new OptionsParser()).parse(args);

        IWorldMap map = new GrassField(12);
        Vector2d[] positions = { new Vector2d(3,3), new Vector2d(5,5), new Vector2d(7,7)   };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();

        assertTrue(engine.getAnimal(0).isAt(new Vector2d(1,5)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(5,6)));
        assertTrue(engine.getAnimal(2).isAt(new Vector2d(9,7)));
    }
}