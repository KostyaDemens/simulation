package by.bsuir.kostyademens.inanimate;

import by.bsuir.kostyademens.Coordinates;

public class Rock extends Obstacle {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return "\uD83D\uDDFF";
    }
}
