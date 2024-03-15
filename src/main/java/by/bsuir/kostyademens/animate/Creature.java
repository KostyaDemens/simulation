package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.pathfinder.PathBuilder;

import java.util.Random;

public abstract class Creature extends Entity {

    protected PathBuilder pathBuilder = new PathBuilder();

    protected int damagePoints;
    protected int healPoints;
    private Coordinates coordinates;
    protected int speed;

    public abstract void makeMove(MapImpl map);

    public abstract void eat();

    protected void roamAround(MapImpl map) {


        Random random = new Random();
        if (!pathBuilder.getListOfNeighbours(this.getCoordinates(), map).isEmpty()) {
            int randomIndex = random.nextInt(pathBuilder.getListOfNeighbours(this.getCoordinates(), map).size());
            map.makeMove(this.getCoordinates(), (pathBuilder.getListOfNeighbours(this.getCoordinates(), map).get(randomIndex)), this);
        }
    }

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
