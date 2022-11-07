package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] args = {"f", "F", "forward",
                "b", "B", "backward",
                "l", "L", "left",
                "r", "R", "right",
                "abc", "fblr"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.LEFT,
                MoveDirection.RIGHT, MoveDirection.RIGHT};
        MoveDirection[] result = OptionsParser.parse(args);
        for (int i = 0; i < result.length; i++)
            assertEquals(result[i], expected[i]);
    }
}
