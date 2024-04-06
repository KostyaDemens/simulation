package by.bsuir.kostyademens.action.spawn;


import by.bsuir.kostyademens.entity.creature.Rabbit;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.map.Coordinates;
import by.bsuir.kostyademens.map.GameMap;


public class SpawnRabbitAction extends SpawnAction {


    public SpawnRabbitAction(GameMap map, int spawnRate) {
        super(map, spawnRate);
    }


    @Override
    public Rabbit spawnEntity(Coordinates coordinates) {
        return EntityFactory.createRabbit(coordinates);
    }
}
