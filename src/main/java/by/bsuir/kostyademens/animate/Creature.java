package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;

public abstract class Creature extends Entity {
    private Coordinates coordinates;
    private int speed;
    public abstract void makeMove();

    public abstract void eat();

    public Creature(Coordinates coordinates, int speed) {
        super(coordinates);
        this.speed = speed;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
