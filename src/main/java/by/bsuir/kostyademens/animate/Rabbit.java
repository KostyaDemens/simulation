package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Rabbit extends Creature {


    public Rabbit(Coordinates coordinates, int healPoints) {
        super(coordinates);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void makeMove(MapImpl map) {
        if (map.findEntity(Carrot.class) == null) {
            Random random = new Random();
            int randomIndex = random.nextInt(pathBuilder.getListOfNeighbours(this.getCoordinates(), map).size());
            map.makeMove(this.getCoordinates(), (pathBuilder.getListOfNeighbours(this.getCoordinates(), map).get(randomIndex)), this);
        } else {

            Queue<Coordinates> queue = new ArrayDeque<>(pathBuilder.buildPath(map, this.getCoordinates(), Carrot.class));


            queue.poll();

            if (map.getEntityFromCoordinates(queue.peek()) instanceof Carrot) {
                eat();
                map.makeMove(this.getCoordinates(), queue.poll(), this);
            } else {

                map.makeMove(this.getCoordinates(), queue.poll(), this);
            }
        }


    }

    @Override
    public void eat() {
        healPoints++;
    }

}
