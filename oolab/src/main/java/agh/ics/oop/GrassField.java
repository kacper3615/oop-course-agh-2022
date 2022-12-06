package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GrassField extends AbstractWorldMap {
    private int no_of_grass;
    private int width = Integer.MAX_VALUE;
    private int height = Integer.MAX_VALUE;
    private MapVisualizer visualizer = new MapVisualizer(this);
    private MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int no_of_grass) {
        super(new Vector2d(0, 0), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.no_of_grass = no_of_grass;
        this.grass_list = this.createFields(no_of_grass);
    }

    public Map<Vector2d, Grass> createFields(int n) {
        Map<Vector2d, Grass> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Vector2d pos = randomField();
            while (positions.containsKey(pos)) {
                pos = randomField();
            }
            this.mapBoundary.addElement(pos);
            positions.put(pos, new Grass(pos));
        }
        return positions;
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getPosition()) ||
                this.objectAt(animal.getPosition()) instanceof Grass) {
            this.animals.put(animal.getPosition(), animal);
            this.mapBoundary.addElement(animal.getPosition());
            animal.addObserver(this);
            return true;
        } else if (this.objectAt(animal.getPosition()) instanceof Animal) {
            throw new IllegalArgumentException(animal.getPosition() + " is not legal move specification.");
        }
        return false;
    }

    public boolean isGrassAt(Vector2d pos, Map<Vector2d, Grass> grass_list) {
        if (grass_list == null) return false;
        if (grass_list.containsKey(pos)) return true;
        return false;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Vector2d randomField() {
        Vector2d position = new Vector2d(
                getRandomNumber(0, (int) Math.sqrt(this.no_of_grass * 10)),
                getRandomNumber(0, (int) Math.sqrt(this.no_of_grass * 10))
        );
        return position;
    }

    public Vector2d[] getObjects() {
        Vector2d[] res = new Vector2d[animals.size() + grass_list.size()];

        int i = 0;
        for (Vector2d v : this.animals.keySet()) {
            res[i] = v;
            i++;
        }
        for (Vector2d v : this.grass_list.keySet()) {
            res[i] = v;
            i++;
        }
        return res;
    }

    @Override
    public void removeObject(Object object) {
        super.removeObject(object);
        if (object instanceof Grass) {
            this.grass_list.remove(((Grass) object).position);
            Vector2d position = randomField();
            while (isOccupied(position)) {
                position = randomField();
            }
            grass_list.put(position, new Grass(position));
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grass_list.containsKey(position)) {
            return grass_list.get(position);
        }
        return null;
    }

    public Vector2d getLowerLeft() {
        return mapBoundary.lowerLeft();
    }

    public Vector2d getUpperRight() {
        return mapBoundary.upperRight();
    }
}