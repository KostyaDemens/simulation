package by.bsuir.kostyademens.action;


import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.map.MapImpl;


public class SpawnRabbitAction extends SpawnAction<Rabbit> {


    public SpawnRabbitAction(MapImpl map) {
        super(map);
        spawnRate = 3;
    }




    @Override
    public Rabbit spawnEntity(Coordinates coordinates) {
        return new Rabbit(coordinates);
    }
}
