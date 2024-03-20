package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.pathfinder.PathBuilder;


public abstract class Creature extends Entity {

    protected PathBuilder pathBuilder = new PathBuilder();

    protected int healPoints;
    private Coordinates coordinates;
    protected int speed;

    public abstract void makeMove(MapImpl map);

    public abstract void eat();

    protected void roamAround(MapImpl map) {
        map.makeMove(coordinates, pathBuilder.getRandomNeighborFiltered(map, coordinates), this);
    }

    public Creature(Coordinates coordinates, int healPoints, int speed) {
        super(coordinates);
        this.healPoints = healPoints;
        this.speed = speed;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
