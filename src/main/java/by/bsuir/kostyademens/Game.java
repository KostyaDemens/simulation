package by.bsuir.kostyademens;

import by.bsuir.kostyademens.animate.Creature;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;


public class Game {


    private final MapImpl map;

    private final Renderer renderer = new Renderer();

    public Game(MapImpl map) {
        this.map = map;
    }



    public void start() {
        while (true) {
            renderer.render(map);
            List<Creature> creatures = map.getListOfCreaturesOnTheMap();
            for (Creature creature : creatures) {
                creature.makeMove(map);
            }
            System.out.println();
            sleep();
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

    private boolean isRabbitExists() {
        return isObjectExists(Rabbit.class);
    }

}
