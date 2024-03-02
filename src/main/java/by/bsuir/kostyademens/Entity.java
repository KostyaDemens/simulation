package by.bsuir.kostyademens;

import by.bsuir.kostyademens.map.MapImpl;

public class Entity {

    protected MapImpl map;

    private Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
