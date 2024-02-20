package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;

public class Rabbit extends Creature {

    private int healPoints = 5;

    public Rabbit(Coordinates coordinates, int speed, int healPoints) {
        super(coordinates, 2);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public void eat() {

    }
}
