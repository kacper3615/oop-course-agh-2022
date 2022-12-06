package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        List<MoveDirection> direction_list = new ArrayList<>();
        for (String option: args){
            switch (option){
                case "f", "forward" -> direction_list.add(MoveDirection.FORWARD);
                case "b", "backward" -> direction_list.add(MoveDirection.BACKWARD);
                case "l", "left" -> direction_list.add(MoveDirection.LEFT);
                case "r", "right" -> direction_list.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(option + " is not legal move specification.");
            }
        }
        MoveDirection[] res = new MoveDirection[direction_list.size()];
        direction_list.toArray(res);
        return res;
    }
}
