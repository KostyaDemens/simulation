package by.bsuir.kostyademens.factory;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;

public class EntityFactory {

    public static Rabbit createRabbit(Coordinates coordinates) {
        return new Rabbit(coordinates, 2);
    }

    public static Wolf createWolf(Coordinates coordinates) {
        return new Wolf(coordinates, 3, 4);
    }
}
