package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;

public class Wolf extends Creature {
    private int damagePoints = 2;

    public Wolf(Coordinates coordinates, int speed, int damagePoints) {
        super(coordinates, 1);
        this.damagePoints = damagePoints;
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
}
