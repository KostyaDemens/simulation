package by.bsuir.kostyademens;

import by.bsuir.kostyademens.map.MapImpl;

public class Renderer {

    public void render(MapImpl map) {
        for (int i = 0; i <= map.getMapWidth(); i++) {
            for (int j = 0; j <= map.getMapHeight(); j++) {
                System.out.print(map.getEntityFromCoordinates(new Coordinates(i, j)));
            }
            System.out.println();
        }
    }
}
