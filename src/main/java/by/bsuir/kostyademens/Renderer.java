package by.bsuir.kostyademens;

import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.map.MapImpl;

public class Renderer {

    public void render(MapImpl map) {
        System.out.print("\033[H\033[J");
        for (int i = 1; i <= map.getMapWidth(); i++) {
            for (int j = 1; j <= map.getMapHeight(); j++) {
                if (map.isCellEmpty(new Coordinates(i, j))) {
                    System.out.print("\uD83D\uDFEB");
                } else {
                System.out.print(setEntitySprite(map.getEntityFromCoordinates(new Coordinates(i, j))));
                }
            }
            System.out.println();
        }
    }

    private String setEntitySprite(Entity entity) {
        String type = entity.getClass().getSimpleName();
        switch (type) {
            case "Rock":
                return "\uD83D\uDDFB";
            case "Tree":
                return "\uD83C\uDF33";
            case "Rabbit":
                return "\uD83D\uDC07";
            case "Wolf":
                return "\uD83D\uDC3A";
            case "Carrot":
                return "\uD83E\uDD55";
            default:
                return "\uD83D\uDFEB";
        }
    }
}
