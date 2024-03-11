package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.map.MapInterface;

import java.util.ArrayDeque;
import java.util.Queue;

public class Wolf extends Creature {
    private int damagePoints;

    public Wolf(Coordinates coordinates) {
        super(coordinates, 1);
        this.damagePoints = 2;
        this.healPoints = 4;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    @Override
    public void makeMove(MapInterface map) {
        Queue<Coordinates> queue = new ArrayDeque<>(pathBuilder.buildPath(map, this.getCoordinates(), Rabbit.class));
        queue.poll();


        if (map.getEntityFromCoordinates(queue.peek()) instanceof Rabbit) {
            eat();
            map.makeMove(this.getCoordinates(), queue.poll(), this);
        } else {

            map.makeMove(this.getCoordinates(), queue.poll(), this);
        }
    }

    @Override
    public void eat() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
