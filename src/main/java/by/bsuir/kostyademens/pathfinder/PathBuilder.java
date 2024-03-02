package by.bsuir.kostyademens.pathfinder;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.inanimate.Obstacle;
import by.bsuir.kostyademens.map.MapInterface;

import java.util.*;

public class PathBuilder {


public List<Coordinates> buildPath(MapInterface map, Coordinates from, Class <? extends Entity> entity) {
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

        for (Coordinates neighbor : getListOfNeighbours(current)) {
            if (!visited.contains(neighbor) && !(map.getEntityFromCoordinates(neighbor) instanceof Obstacle)) {
                visited.add(neighbor);
                queue.add(neighbor);
                parentMap.put(neighbor, current);
            }
        }
    }
    return null;
}


    private List<Coordinates> getListOfNeighbours(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        Coordinates[] arrayOfNeighbours = new Coordinates[]{new Coordinates(x, y - 1), new Coordinates(x, y + 1), new Coordinates(x + 1, y), new Coordinates(x - 1, y)};
        List<Coordinates> listOfNeighbours = new ArrayList<>();
        for (Coordinates coordinate : arrayOfNeighbours) {
            if (coordinate.getX() >= 1 && coordinate.getY() >= 1 && coordinate.getX() <= 10 && coordinate.getY() <= 10) {
                listOfNeighbours.add(coordinate);
            }
        }
        return listOfNeighbours;
    }


}


