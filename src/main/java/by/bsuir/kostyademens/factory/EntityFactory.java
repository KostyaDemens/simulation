package by.bsuir.kostyademens.factory;

import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.entity.creature.Rabbit;
import by.bsuir.kostyademens.entity.creature.Wolf;
import by.bsuir.kostyademens.entity.inanimate.Carrot;
import by.bsuir.kostyademens.entity.inanimate.Rock;
import by.bsuir.kostyademens.entity.inanimate.Tree;

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
