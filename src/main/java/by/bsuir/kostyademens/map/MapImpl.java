package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Creature;

import java.util.HashMap;
import java.util.Map;

public class MapImpl implements MapInterface {

    private final int mapWidth = 10;
    private final int mapHeight = 10;

    HashMap<Coordinates, Entity> map = new HashMap<>();

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    @Override
    public void addEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    @Override
    public void makeMove(Coordinates from, Coordinates to, Creature creature) {
        addEntity(to, creature);
        map.remove(from, creature);
    }

    public Entity findEntity(Class <? extends Entity> randomEntity) {
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            if (randomEntity.isInstance(entry.getValue())) {
                return entry.getValue();
            }
        }
        return null;
    }


    public Coordinates getRandomCoordinates() {
        if (map.size() >= mapWidth * mapHeight) {
            return null;
        }

        while (true) {
            int x = (int) (Math.random() * mapWidth + 1);
            int y = (int) (Math.random() * mapHeight + 1);
            Coordinates coordinates = new Coordinates(x, y);
            if (isCellEmpty(coordinates)) {
                return coordinates;
            }
        }
    }

    public Entity getEntityFromCoordinates(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}
