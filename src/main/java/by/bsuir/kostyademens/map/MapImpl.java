package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    @Override
    public void makeMove(Coordinates from, Coordinates to, Creature creature) {
        addEntity(to, creature);
        map.remove(from, creature);
    }

    @Override
    public Entity findEntity(Class <? extends Entity> classToFind) {
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            if (classToFind.isInstance(entry.getValue())) {
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

    @Override
    public List<? extends Entity> getListOfEntitiesOnTheMap(Class<? extends Entity> entities) {
        List<Entity> entityList = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            if (entities.isInstance(entry.getValue())) {
                entityList.add(entry.getValue());
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
