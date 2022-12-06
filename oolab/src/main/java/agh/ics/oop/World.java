package agh.ics.oop;

import static agh.ics.oop.Direction.*;
import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        //Lab 1
//        System.out.print("Start\n");
//        World.run(args);
//        System.out.print("Stop\n");

        //Lab 2
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

        //Lab 3
//        Animal animal = new Animal();
//        System.out.println(animal.toString());
//        MoveDirection[] directions = OptionsParser.parse(args);
//        System.out.println(Arrays.toString(directions));
//        for (MoveDirection argument: directions){
//            animal.move(argument);
//            System.out.println(animal);
//        }
//        System.out.println(Arrays.toString(directions));

        //Lab 4
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }

        //Lab 5, 6
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new GrassField(10);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//    }

        //Lab 7
        Application.launch(App.class, args);
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
