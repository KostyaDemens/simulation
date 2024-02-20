package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;

public abstract class Creature {
    private Coordinates coordinates;
    private int speed;
    public abstract void makeMove();

    public abstract void eat();

    public Creature(Coordinates coordinates, int speed) {
        this.coordinates = coordinates;
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
