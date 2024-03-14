package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Wolf extends Creature {
    private int damagePoints;

    public Wolf(Coordinates coordinates, int damagePoints, int healPoints) {
        super(coordinates);
        this.damagePoints = damagePoints;
        this.healPoints = healPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void makeMove(MapImpl map) {
        if (map.findEntity(Rabbit.class) == null) {
            roamAround(map);
        } else {

            List<Coordinates> path = pathBuilder.buildPath(map, this.getCoordinates(), Rabbit.class);

            for (Coordinates coordinates : path) {
                if (map.getEntityFromCoordinates(coordinates) instanceof Rabbit) {
                    eat();
                    map.makeMove(this.getCoordinates(), coordinates, this);
                } else {
                    map.makeMove(this.getCoordinates(), coordinates, this);
                    break;
                }
            }
        }
    }

    @Override
    public void eat() {

    }

}
