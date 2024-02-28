package by.bsuir.kostyademens.inanimate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;

public class Rock extends Entity implements Obstacle {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83D\uDDFF";
    }
}
