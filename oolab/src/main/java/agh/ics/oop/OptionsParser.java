package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        List<MoveDirection> directionlist = new ArrayList<>();
        for (String option: args){
            switch (option){
                case "f", "forward" -> directionlist.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionlist.add(MoveDirection.BACKWARD);
                case "l", "left" -> directionlist.add(MoveDirection.LEFT);
                case "r", "right" -> directionlist.add(MoveDirection.RIGHT);
            }
        }
        MoveDirection[] res = new MoveDirection[directionlist.size()];
        directionlist.toArray(res);
        return res;
    }
}
