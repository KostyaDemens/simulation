package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.factory.EntityFactory;
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
