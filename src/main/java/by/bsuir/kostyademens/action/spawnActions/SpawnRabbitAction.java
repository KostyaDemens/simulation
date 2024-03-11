package by.bsuir.kostyademens.action.spawnActions;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.action.SpawnAction;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.map.MapInterface;


public class SpawnRabbitAction extends SpawnAction<Rabbit> {


    public SpawnRabbitAction(MapInterface map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Rabbit spawnEntity(Coordinates coordinates) {
        return new Rabbit(coordinates);
    }
}
