package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapImpl {

    private final int mapWidth;
    private final int mapHeight;

    public MapImpl(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    HashMap<Coordinates, Entity> map = new HashMap<>();

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public void makeMove(Coordinates from, Coordinates to, Creature creature) {
        if (!from.equals(to)) {
            addEntity(to, creature);
            map.remove(from, creature);
        } else {
            addEntity(to, creature);
        }
    }


    public Coordinates getRandomCoordinates() {
        if (map.size() >= mapWidth * mapHeight) {
            return null;
        }

        while (true) {
            int x = (int) (Math.random() * mapWidth + 1);
            int y = (int) (Math.random() * mapHeight + 1);
            Coordinates coordinates = new Coordinates(y, x);
            if (isCellEmpty(coordinates)) {
                return coordinates;
            }
        }
    }

    public <T extends Entity> List<T> getListOfEntitiesOnTheMap(Class<T> entityType) {
        List<T> entityList = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            Entity entity = entry.getValue();
            if (entityType.isInstance(entity)) {
                entityList.add(entityType.cast(entity));
            }
        }
        return entityList;
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
