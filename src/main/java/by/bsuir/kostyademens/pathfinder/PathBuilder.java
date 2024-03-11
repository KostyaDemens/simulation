package by.bsuir.kostyademens.pathfinder;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.inanimate.Obstacle;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.*;

public class PathBuilder {

    public List<Coordinates> buildPath(MapImpl map, Coordinates from, Class<? extends Entity> entity) {
        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Карта для отслеживания родительских координат

        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (entity.isInstance(map.getEntityFromCoordinates(current))) {
                List<Coordinates> path = new ArrayList<>();
                Coordinates backtrack = map.getEntityFromCoordinates(current).getCoordinates();
                while (backtrack != null) {
                    path.add(backtrack);
                    backtrack = parentMap.get(backtrack);
                }
                Collections.reverse(path);
                return path;
            }

            for (Coordinates neighbor : getListOfNeighbours(current, map)) {
                if (!visited.contains(neighbor) && !(map.getEntityFromCoordinates(neighbor) instanceof Obstacle)
                    && !(map.getEntityFromCoordinates(neighbor) instanceof Rabbit)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        return null;
    }


    public List<Coordinates> getListOfNeighbours(Coordinates coordinates, MapImpl map) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        Coordinates[] arrayOfNeighbours = new Coordinates[]{new Coordinates(x, y - 1), new Coordinates(x, y + 1), new Coordinates(x + 1, y), new Coordinates(x - 1, y)};
        List<Coordinates> listOfNeighbours = new ArrayList<>();
        for (Coordinates coordinate : arrayOfNeighbours) {
            if (coordinate.getX() >= 1 && coordinate.getY() >= 1 && coordinate.getX() <= map.getMapWidth() && coordinate.getY() <= map.getMapWidth()) {
                listOfNeighbours.add(coordinate);
            }
        }
        return listOfNeighbours;
    }


}


