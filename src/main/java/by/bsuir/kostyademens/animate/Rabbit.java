package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;

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
    public void makeMove() {

    }

    @Override
    public void eat() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }
}
