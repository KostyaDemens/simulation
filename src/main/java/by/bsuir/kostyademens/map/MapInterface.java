package by.bsuir.kostyademens.map;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.Entity;
import by.bsuir.kostyademens.animate.Creature;

public interface MapInterface {

    void addEntity(Coordinates coordinates, Entity entity);

    void makeMove(Coordinates from, Coordinates to, Creature creature);

    void removeEntity(Coordinates coordinates);

    Coordinates getRandomCoordinates();

    Entity getEntityFromCoordinates(Coordinates coordinates);

    Entity findEntity(Class <? extends Entity> randomEntity);
    boolean isCellEmpty(Coordinates coordinates);

    int getMapWidth();

    int getMapHeight();

}
