package by.bsuir.kostyademens;


import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.map.MapImpl;

public class MapFactory {
    public MapImpl get() {
        MapImpl map = new MapImpl(3, 4);
//        SpawnCarrotAction carrot = new SpawnCarrotAction(map);
//        SpawnRabbitAction rabbit = new SpawnRabbitAction(map);
//        SpawnWolfAction wolf = new SpawnWolfAction(map);
//        wolf.perform();
//        carrot.perform();
//        rabbit.perform();

        map.addEntity(new Coordinates(1, 1), new Rock(new Coordinates(1, 1)));
        map.addEntity(new Coordinates(1, 2), new Rock(new Coordinates(1, 2)));
        map.addEntity(new Coordinates(2, 1), new Rock(new Coordinates(2, 1)));
        map.addEntity(new Coordinates(2, 2), new Rock(new Coordinates(2, 2)));
        map.addEntity(new Coordinates(4, 1), new Rock(new Coordinates(4, 1)));
        map.addEntity(new Coordinates(4, 2), new Rock(new Coordinates(4, 2)));

        map.addEntity(new Coordinates(3, 1), new Rabbit(new Coordinates(3, 1), 2));
        map.addEntity(new Coordinates(1, 3), new Rabbit(new Coordinates(1, 3), 2));

        map.addEntity(new Coordinates(4, 3), new Carrot(new Coordinates(4, 3)));

        map.addEntity(new Coordinates(2, 1), new Rock(new Coordinates(2, 1)));
        map.addEntity(new Coordinates(1, 2), new Rock(new Coordinates(1, 2)));
        map.addEntity(new Coordinates(1, 2), new Rock(new Coordinates(1, 2)));

        return map;
    }
}
