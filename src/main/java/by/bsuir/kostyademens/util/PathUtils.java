package by.bsuir.kostyademens.util;

import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.entity.Entity;
import by.bsuir.kostyademens.entity.creature.Creature;
import by.bsuir.kostyademens.entity.inanimate.Obstacle;
import by.bsuir.kostyademens.map.GameMap;

import java.util.*;

public class PathUtils {

    public static List<Coordinates> buildPathToTheNearestEntity(GameMap map, Coordinates from, Class<? extends Entity> targetEntityClass) {
        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();
        Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Карта для отслеживания родительских координат

        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Entity entity = map.getEntityFromCoordinates(current);

            if (!current.equals(from)) {
                if (targetEntityClass.isInstance(entity)) {
                    return makeBacktrack(parentMap, entity);
                }

                if (entity instanceof Obstacle || entity instanceof Creature) {
                    continue;
                }
            }

            for (Coordinates neighbor : map.getListOfNeighbours(current, map)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        return null;
    }

    private static List<Coordinates> makeBacktrack(Map<Coordinates, Coordinates> parentMap, Entity entity) {
        Deque<Coordinates> stack = new LinkedList<>();
        Coordinates backtrack = entity.getCoordinates();
        while (backtrack != null) {
            stack.push(backtrack);
            backtrack = parentMap.get(backtrack);
        }
        stack.pop();
        return (List<Coordinates>) stack;
    }
}


