package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {

    private final int mapWidth;
    private final int mapHeight;

    public GameMap(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    private final Map<Coordinates, Entity> map = new HashMap<>();

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        map.put(coordinates, entity);
    }

    public void moveEntityOnTheMap(Coordinates from, Coordinates to) {
        Entity entity = getEntityFromCoordinates(from);
        if (!from.equals(to)) {
            addEntity(to, entity);
            map.remove(from, entity);
        } else {
            addEntity(to, entity);
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

    public <T> List<T> getListOfEntitiesOnTheMap(Class<T> entityType) {
        List<T> entities = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            Entity entity = entry.getValue();
            if (entityType.isInstance(entity)) {
                entities.add(entityType.cast(entity));
            }
        }
        return entities;
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

    public List<Coordinates> getListOfNeighbours(Coordinates coordinates, GameMap map) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        Coordinates[] arrayOfNeighbours = new Coordinates[]{
                new Coordinates(y - 1, x),
                new Coordinates(y + 1, x),
                new Coordinates(y, x + 1),
                new Coordinates(y, x - 1)
        };
        List<Coordinates> neighbourCells = new ArrayList<>();
        for (Coordinates coordinate : arrayOfNeighbours) {

            if (coordinate.getX() >= 1 && coordinate.getY() >= 1
                    && coordinate.getX() <= map.getMapWidth() && coordinate.getY() <= map.getMapHeight()) {
                neighbourCells.add(coordinate);
            }
        }
        return neighbourCells;
    }

}
