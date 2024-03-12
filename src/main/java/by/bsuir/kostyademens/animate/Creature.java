package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.pathfinder.PathBuilder;

public abstract class Creature extends Entity {

    protected PathBuilder pathBuilder = new PathBuilder();

    protected int damagePoints;
    protected int healPoints;
    private Coordinates coordinates;
    protected int speed;
    public abstract void makeMove(MapImpl map);

    public abstract void eat();

    public Creature(Coordinates coordinates) {
        super(coordinates);
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
