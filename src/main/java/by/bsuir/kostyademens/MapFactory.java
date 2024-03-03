package by.bsuir.kostyademens;

import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.map.MapInterface;

public class MapFactory {
    public MapInterface get() {
        MapInterface map = new MapImpl();
        Carrot carrot = new Carrot(new Coordinates(5, 5));
        Carrot carrot2 = new Carrot(new Coordinates(9, 9));
        map.addEntity(new Coordinates(5, 5), carrot);
        map.addEntity(new Coordinates(9, 9), carrot2);
        return map;
    }
}
