package by.bsuir.kostyademens.entity.creature;

import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.entity.Entity;
import by.bsuir.kostyademens.entity.inanimate.Obstacle;
import by.bsuir.kostyademens.map.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Creature extends Entity {


    protected int healPoints;
    private Coordinates coordinates;
    protected int speed;

    public abstract void makeMove(GameMap map);

    public abstract void eat();

    protected void roamAround(GameMap map) {
        map.moveEntityOnTheMap(coordinates, getRandomNeighborFiltered(map, coordinates));
    }

    private Coordinates getRandomNeighborFiltered(GameMap map, Coordinates from) {
        List<Coordinates> neighbours = map.getListOfNeighbours(from, map);
        List<Coordinates> candidates = new ArrayList<>();
        for (Coordinates neighbour : neighbours) {
            Entity entity = map.getEntityFromCoordinates(neighbour);
            if (!(entity instanceof Obstacle || entity instanceof Creature)) {
                candidates.add(neighbour);
            }
        }
        Random random = new Random();
        if (!candidates.isEmpty()) {
            int randomIndex = random.nextInt(candidates.size());
            return candidates.get(randomIndex);
        } else {
            return from;
        }
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
