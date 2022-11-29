package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GrassField extends AbstractWorldMap{
    private int no_of_grass;
    private int width = Integer.MAX_VALUE;
    private int height = Integer.MAX_VALUE;
    private MapVisualizer visualizer = new MapVisualizer(this);

    public GrassField(int no_of_grass){
        super(new Vector2d(0, 0), new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.no_of_grass = no_of_grass;
        this.grass_list = this.createFields(no_of_grass);
    }

    public Map<Vector2d, Grass> createFields(int n){
        Map<Vector2d, Grass> positions = new HashMap<>();
        for (int i=0; i<n; i++){
            Vector2d pos = randomField();
            while (isGrassAt(pos, positions)){
                pos = randomField();
            }
            positions.put(pos, new Grass(pos));
        }
        return positions;
    }

    public boolean isGrassAt(Vector2d pos, Map<Vector2d, Grass> grass_list){
        if(grass_list == null) return false;
        if(grass_list.containsKey(pos)) return true;
        return false;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Vector2d randomField(){
        Vector2d position = new Vector2d(
                getRandomNumber(0, (int)Math.sqrt(this.no_of_grass*10)),
                getRandomNumber(0, (int)Math.sqrt(this.no_of_grass*10))
        );
        return position;
    }

    @Override
    public void removeObject(Object object){
        super.removeObject(object);
        if (object instanceof Grass) {
            this.grass_list.remove(((Grass) object).position);
            Vector2d position = randomField();
            while (isOccupied(position)){
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

    @Override
    public Vector2d getLowerLeft(){
        Vector2d v = new Vector2d(0, 0);
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            v = v.lowerLeft(animal.getValue().getPosition());
        }
        for (Map.Entry<Vector2d, Grass> grass : grass_list.entrySet()) {
            v = v.lowerLeft(grass.getValue().getPosition());
        }
        return v;
    }
    @Override
    public Vector2d getUpperRight(){
        Vector2d v = new Vector2d(0, 0);
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            v = v.upperRight(animal.getValue().getPosition());
        }
        for (Map.Entry<Vector2d, Grass> grass : grass_list.entrySet()) {
            v = v.upperRight(grass.getValue().getPosition());
        }
        return v;
    }
}