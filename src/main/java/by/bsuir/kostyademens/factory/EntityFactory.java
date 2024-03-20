package by.bsuir.kostyademens.factory;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;

public class EntityFactory {

    public static Rabbit createRabbit(Coordinates coordinates) {
        return new Rabbit(coordinates, 1, 1);
    }

    public static Wolf createWolf(Coordinates coordinates) {
        return new Wolf(coordinates, 1, 4, 1);
    }
}
