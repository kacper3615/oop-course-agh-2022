package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

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

    public List<Grass> createFields(int n){
        List<Grass> positions = new ArrayList<>();
        for (int i=0; i<n; i++){
            Vector2d pos = randomField();
            while (isGrassAt(pos, positions)){
                pos = randomField();
            }
            positions.add(new Grass(pos));
        }
        return positions;
    }

    public boolean isGrassAt(Vector2d pos, List<Grass> grass_list){
        if(grass_list == null) return false;
        for (Grass position : grass_list){
            if(position.getPosition().equals(pos)) return true;
        }
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
        if (object instanceof Animal){
            this.animals.remove(object);
        } else if (object instanceof Grass) {
            this.grass_list.remove(object);
            Vector2d position = randomField();
            while (isOccupied(position)){
                position = randomField();
            }
            grass_list.add(new Grass(position));
        }
    }

    @Override
    public Vector2d getLowerLeft(){
        Vector2d v = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals) {
            v = v.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grass_list) {
            v = v.lowerLeft(grass.getPosition());
        }
        return v;
    }
    @Override
    public Vector2d getUpperRight(){
        Vector2d v = new Vector2d(0, 0);
        for (Animal animal : animals) {
            v = v.upperRight(animal.getPosition());
        }
        for (Grass grass : grass_list) {
            v = v.upperRight(grass.getPosition());
        }
        return v;
    }
}