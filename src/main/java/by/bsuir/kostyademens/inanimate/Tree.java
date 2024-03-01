package by.bsuir.kostyademens.inanimate;

import by.bsuir.kostyademens.Coordinates;

public class Tree extends Obstacle {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
