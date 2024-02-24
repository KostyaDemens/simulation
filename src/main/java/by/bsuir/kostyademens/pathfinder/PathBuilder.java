package by.bsuir.kostyademens.pathfinder;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.ArrayList;
import java.util.List;

public class PathBuilder {
    MapImpl map = new MapImpl();

    public List<Coordinates> getListOfNeighbours(Coordinates coordinates) {
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


