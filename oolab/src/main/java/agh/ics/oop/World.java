package agh.ics.oop;

import static agh.ics.oop.Direction.*;

public class World {
    public static void main(String[] args) {
        System.out.print("Start\n");
        World.run(args);
        System.out.print("Stop");
    }

    private static Direction[] getDirection(String[] args) {
        Direction[] directions = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            directions[i] = switch (args[i]) {
                case "f" -> FORWARD;
                case "b" -> BACKWARD;
                case "l" -> LEFT;
                case "r" -> RIGHT;
                default -> OTHER;
            };
        }
        return directions;
    }
    private static void run(String[] args){
        Direction[] directionsArr = getDirection(args);
        for (Direction direction : directionsArr) {
            switch (direction) {
                case FORWARD -> System.out.print("Zwierzak idzie do przodu\n");
                case BACKWARD -> System.out.print("Zwierzak idzie do tyłu\n");
                case LEFT -> System.out.print("Zwierzak idzie w lewo\n");
                case RIGHT -> System.out.print("Zwierzak idzie w prawo\n");
            }
        }
    }
}
