package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;

public class Wolf extends Creature {
    private int damagePoints;

    public Wolf(Coordinates coordinates) {
        super(coordinates, 1);
        this.damagePoints = 2;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public void eat() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
