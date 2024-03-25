package by.bsuir.kostyademens.factory;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.inanimate.Tree;

public class EntityFactory {

    public static Rabbit createRabbit(Coordinates coordinates) {
        return new Rabbit(coordinates, 1, 1);
    }

    public static Wolf createWolf(Coordinates coordinates) {
        return new Wolf(coordinates, 1, 4, 1);
    }

    public static Rock createRock(Coordinates coordinates) { return new Rock(coordinates); }

    public static Carrot createCarrot(Coordinates coordinates) { return new Carrot(coordinates); }

    public static Tree createTree(Coordinates coordinates) { return new Tree(coordinates); }
}
