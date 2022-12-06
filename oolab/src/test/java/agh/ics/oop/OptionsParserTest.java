package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] args = {"f", "forward",
                "b", "backward",
                "l", "left",
                "r", "right",};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.LEFT,
                MoveDirection.RIGHT, MoveDirection.RIGHT};
        MoveDirection[] result = OptionsParser.parse(args);
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], expected[i]);
    }

    @Test
    public void testMoveParserWithIncorrectInput() {
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"b", "left", "f", "unexpected", "r", "x", "right", "y", "z", "backward"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("unexpected is not legal move specification.", exeption.getMessage());
    }

    @Test
    public void testMoveParserWithAlIncorrectInput() {
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"x", "unexpected", "y", "z", "surprise"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("x is not legal move specification.", exeption.getMessage());
    }

}
