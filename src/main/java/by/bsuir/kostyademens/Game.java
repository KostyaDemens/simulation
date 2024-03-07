package by.bsuir.kostyademens;

import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapInterface;

public class Game {

    private final MapInterface map;

    private final Renderer renderer = new Renderer();

    private final Rabbit rabbit = new Rabbit(new Coordinates(1, 1));


    public Game(MapInterface map) {
        this.map = map;

        map.addEntity(new Coordinates(1, 1), rabbit);
    }


    public void start() {
        while (isCarrotExists()) {
            renderer.render(map);
            rabbit.makeMove(map);
            System.out.println();
            sleep();
            System.out.print("\033[H\033[J");
        }
    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isObjectExists(Class<? extends Entity> classToFind) {
        return map.findEntity(classToFind) != null;

    }

    private boolean isCarrotExists() {
        return isObjectExists(Carrot.class);
    }

    private boolean isWolfExists() {
        return isObjectExists(Wolf.class);
    }

}
