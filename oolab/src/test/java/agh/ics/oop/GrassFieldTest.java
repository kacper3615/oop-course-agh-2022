package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
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

    @Test
    public void placeTest(){
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] args = {};
            MoveDirection[] directions = (new OptionsParser()).parse(args);
            IWorldMap map = new GrassField(12);
            Vector2d[] positions = {};
            SimulationEngine engine = new SimulationEngine(directions, map, positions);

            Animal animal_1 = new Animal(map, new Vector2d(0, 0));
            Animal animal_2 = new Animal(map, new Vector2d(0, 0));

            map.place(animal_1);
            map.place(animal_2);

            engine.run();
        });
        Assertions.assertEquals("(0,0) is not legal move specification.", exeption.getMessage());
    }
}