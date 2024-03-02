package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Creature;

public interface MapInterface {

    void addEntity(Coordinates coordinates, Entity entity);

    void makeMove(Coordinates from, Coordinates to, Creature creature);

    Entity getEntityFromCoordinates(Coordinates coordinates);

}
