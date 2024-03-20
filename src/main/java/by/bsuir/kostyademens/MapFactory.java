package by.bsuir.kostyademens;


import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.action.spawnActions.*;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.animate.Wolf;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.MapImpl;


public class MapFactory {
    public MapImpl get() {
//        return wolfAndRabbitTest();
//        return rabbitHealPointsCollapseTest();
//        return rabbitAndCarrotTes();
//        return rabbitRoamingCollapseTest();
//        return wolfDamageTest();
        return readySimulation();
    }

    public MapImpl rabbitHealPointsCollapseTest() {
        MapImpl map = new MapImpl(3, 4);

        map.addEntity(new Coordinates(1, 1), new Rock(new Coordinates(1, 1)));
        map.addEntity(new Coordinates(1, 2), new Rock(new Coordinates(1, 2)));
        map.addEntity(new Coordinates(2, 1), new Rock(new Coordinates(2, 1)));
        map.addEntity(new Coordinates(2, 2), new Rock(new Coordinates(2, 2)));
        map.addEntity(new Coordinates(4, 1), new Rock(new Coordinates(4, 1)));
        map.addEntity(new Coordinates(4, 2), new Rock(new Coordinates(4, 2)));

        map.addEntity(new Coordinates(3, 2), new Rabbit(new Coordinates(3, 2), 2, 1));
        map.addEntity(new Coordinates(2, 3), new Rabbit(new Coordinates(2, 3), 2, 1));

        map.addEntity(new Coordinates(3, 3), new Wolf(new Coordinates(3, 3), 1, 1, 2));

        map.addEntity(new Coordinates(4, 3), new Carrot(new Coordinates(4, 3)));
        return map;
    }

    private MapImpl wolfAndRabbitTest() {
        MapImpl map = new MapImpl(3, 3);

        map.addEntity(new Coordinates(3, 3), new Rabbit(new Coordinates(3, 3), 2, 1));

        map.addEntity(new Coordinates(1, 1), new Wolf(new Coordinates(1, 1), 1, 8, 1));
        return map;
    }

    private MapImpl rabbitAndCarrotTest() {
        MapImpl map = new MapImpl(5, 5);

        map.addEntity(new Coordinates(1, 1), new Rabbit(new Coordinates(1, 1), 1, 1));

        map.addEntity(new Coordinates(5, 5), new Carrot(new Coordinates(5, 5)));

        return map;
    }

    private MapImpl rabbitRoamingCollapseTest() {
        MapImpl map = new MapImpl(2, 1);

        map.addEntity(new Coordinates(1, 1), new Rabbit(new Coordinates(1, 1), 1, 1));
        map.addEntity(new Coordinates(1, 2), new Rabbit(new Coordinates(1, 2), 1, 1));

        return map;
    }

    private MapImpl wolfDamageTest() {
        MapImpl map = new MapImpl(2, 1);

        map.addEntity(new Coordinates(1, 1), new Wolf(new Coordinates(1, 1), 1, 1, 2));

        map.addEntity(new Coordinates(1, 2), new Rabbit(new Coordinates(1, 2), 5, 1));

        return map;
    }

    private MapImpl readySimulation() {
        MapImpl map = new MapImpl(10, 10);
        SpawnAction<Carrot> carrot = new SpawnCarrotAction(map);
        SpawnAction<Rabbit> rabbit = new SpawnRabbitAction(map);
        SpawnAction<Wolf> wolf = new SpawnWolfAction(map);
        SpawnAction<Rock> rock = new SpawnRockAction(map);
        SpawnAction<Tree> tree = new SpawnTreeAction(map);

        rock.perform();
        tree.perform();
        wolf.perform();
        carrot.perform();
        rabbit.perform();
        return map;
    }
}
