package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapInterface;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rabbit extends Creature {

    private int healPoints;

    public Rabbit(Coordinates coordinates) {
        super(coordinates, 2);
        this.healPoints = 5;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void makeMove(MapInterface map) {
        Queue<Coordinates> queue = new ArrayDeque<>(pathBuilder.buildPath(map, this.getCoordinates(), Carrot.class));
        queue.poll();


        if (map.getEntityFromCoordinates(queue.peek()) instanceof Carrot) {
            eat();
            map.makeMove(this.getCoordinates(), queue.poll(), this);
        } else {

            map.makeMove(this.getCoordinates(), queue.poll(), this);
        }
    }

    @Override
    public void eat() {
        healPoints++;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
