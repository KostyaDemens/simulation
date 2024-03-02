package by.bsuir.kostyademens;

import by.bsuir.kostyademens.map.MapImpl;

public class Renderer {

    public void render(MapImpl map) {
        for (int i = 1; i <= map.getMapWidth(); i++) {
            for (int j = 1; j <= map.getMapHeight(); j++) {
                if (map.isCellEmpty(new Coordinates(i, j))) {
                    System.out.print(" . ");
                } else {
                System.out.print(map.getEntityFromCoordinates(new Coordinates(i, j)));

                }
            }
            System.out.println();
        }
    }
}
