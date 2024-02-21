package by.bsuir.kostyademens.inanimate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
