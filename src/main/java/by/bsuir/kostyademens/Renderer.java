package by.bsuir.kostyademens;

import by.bsuir.kostyademens.animate.Creature;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.MapImpl;

public class Renderer {

    public void render(MapImpl map) {
        System.out.print("\033[H\033[J");
        for (int i = 1; i <= map.getMapHeight(); i++) {
            for (int j = 1; j <= map.getMapWidth(); j++) {
                Coordinates coords = new Coordinates(i, j);
                Entity entity = map.getEntityFromCoordinates(coords);
                System.out.print(getSpriteByEntityType(entity));
                if (entity instanceof Creature) {
                    System.out.print("[" + ((Creature) entity).getHealPoints() + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private String getSpriteByEntityType(Entity entity) {
        if (entity == null) { // empty cell
            return "\uD83D\uDFEB";
        }
        if (entity instanceof Rock) {
            return "\uD83D\uDDFB";
        }
        if (entity instanceof Tree) {
            return "\uD83C\uDF33";
        }
        if (entity instanceof Rabbit) {
            return "\uD83D\uDC07";
        }
        if (entity instanceof Wolf) {
            return "\uD83D\uDC3A";
        }
        if (entity instanceof Carrot) {
            return "\uD83E\uDD55";
        }
        return "\uD83D\uDFEB";
    }
}
