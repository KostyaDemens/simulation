package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.factory.EntityFactory;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnRabbitAction extends SpawnAction<Rabbit> {


    public SpawnRabbitAction(MapImpl map) {
        super(map);
        spawnRate = 1;
    }




    @Override
    public Rabbit spawnEntity(Coordinates coordinates) {
        return EntityFactory.createRabbit(coordinates);
    }
}
